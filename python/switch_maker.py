import csv


class SwitchMaker(object):

    def __init__(self):

        self.columns = {
            '2' : 'opcode',
            '5' : 'full_instruction',
            '6' : 'instruction',
            '7' : 'operand_1',
            '8' : 'operand_2',
            '9' : 'length',
            '10' : 'cycles',
            '11' : 'Z',
            '12' : 'N',
            '13' : 'H',
            '14' : 'C',
            '18': 'write',
        }

        self.main_table = open('../other/working/op_codes_main.csv', newline='')
        self.cb_table = open('../other/working/op_codes_cb.csv', newline='')

        self.main_csv_reader = csv.reader(self.main_table, delimiter=',')
        self.cb_csv_reader = csv.reader(self.cb_table, delimiter=',')

        self.main_array = SwitchMaker.create_array(self.main_csv_reader)
        self.cb_array = SwitchMaker.create_array(self.cb_csv_reader)

        self.main_dict = self.rows_to_dicts(self.main_array)
        self.cb_dict = self.rows_to_dicts(self.cb_array)

        # self.columns2 = {
        #     'opcode': 2,
        #     'full_instruction': 5,
        #     'instruction': 6,
        #     'operand_1': 7,
        #     'operand_2': 8,
        #     'length': 9,
        #     'cycles': 10,
        #     'Z': 11,
        #     'N': 12,
        #     'H': 13,
        #     'C': 14,
        #     'write': 18,
        # }

        self.registers = ['A', 'F', 'B', 'C', 'D', 'E', 'H', 'L', 'AF', 'BC', 'DE', 'HL', 'SP', 'PC']

    # If contains brackets, if a8/a16

    @staticmethod
    def create_array(csv_reader):
        op_table = []
        for row in csv_reader:
            op_table.append(row)
        return op_table

    def rows_to_dicts(self, array):

        list_of_dicts = []

        for row in array:

            row_dict = {}

            for index, cell in enumerate(row):

                if str(index) in self.columns.keys():

                    row_dict[self.columns[str(index)]]  = cell

            list_of_dicts.append(row_dict)

        return list_of_dicts

    # The java returned by each of these functions returns a ByteInterface object
    @staticmethod
    def d8():
        d8_string = 'm.address( r.PC.read() + 1 )'
        return d8_string

    @staticmethod
    def d16():
        d16_string = 'new BytePair( m.address( r.PC.read() + 1 ), m.address( r.PC.read() + 2 ) )'
        return d16_string

    # The java returned by each of these functions returns an int
    @staticmethod
    def r8():
        r8_string = 'm.address( r.PC.read() + 1 ).readSigned()'
        return r8_string

    @staticmethod
    def a8():
        a8_string = SwitchMaker.d8() + '.read()'
        return a8_string

    @staticmethod
    def a16():
        a16_string = SwitchMaker.d16() + '.read()'
        return a16_string

    @staticmethod
    def resolve_brackets(bracketed_operand):

        # operand_function = getattr(SwitchMaker, bracketed_operand)
        # operand_string = operand_function()
        result_string = 'm.address( ' + bracketed_operand + '.read() )'
        return result_string

    def get_register_or_memloc(self, operand):

        if operand in self.registers:
            op_text = 'r.' + operand
        else:
            op_text = getattr(SwitchMaker, operand)()

        return op_text

    @staticmethod
    def strip_brackets(string):
        result = string.replace('(', '')
        result = result.replace(')', '')
        return result

    def get_operand(self, input_operand):

        # Is the operand bracketed?
        if input_operand[0] == '(':

            operand = SwitchMaker.strip_brackets(input_operand)
            operand = self.get_register_or_memloc(operand)
            operand = SwitchMaker.resolve_brackets(operand)
            
        else:
            operand = self.get_register_or_memloc(input_operand)

        return operand

    @staticmethod
    def get_flag_methods(row):
        
        flag_string = ''
        
        if row['Z'] != '-':
            flag_string = flag_string + 'r.setZF(' + row['Z'] + '); \n'
        else:
            pass
        
        if row['N'] != '-':
            flag_string = flag_string + 'r.setNF(' + row['N'] + '); \n'
        else:
            pass

        if row['H'] != '-':
            flag_string = flag_string + 'r.setHF(' + row['H'] + '); \n'
        else:
            pass

        if row['C'] != '-':
            flag_string = flag_string + 'r.setCF(' + row['C'] + '); \n'
        else:
            pass
        
        return flag_string

    # Think about clearing any whitespace from instructions/operands? 

    def make_cases(self, list_of_dicts):
        print (list_of_dicts)

        section = ''
        for row in list_of_dicts:

            print(row)

            if len( str(row['instruction']) ) == 0:
                pass

            else:
                section = section + 'case ' + '0x' + row['opcode'] + ': \n' + '\t//' + row['full_instruction'] + \
                          '\n\t//length ' + row['length'] + '\n\t//time ' + row['cycles'] + '\n\t//flags ' + row['Z'] + \
                          row['H'] + row['N'] + row['C'] + '\n\n'

                if row['instruction'] == 'LD':
                    section = section + self.LDgen(row) + '\n\n'

                section = section + SwitchMaker.get_flag_methods(row)

                section = section + '\n\n\tbreak;' + '\n\n'

        return section

    def top_and_tail(self, func_name, list_of_dicts):

        full_text = 'public void ' + func_name + ' (int opcode) {\n\t' + 'switch(opcode) {\n\t'

        full_text = full_text + self.make_cases(list_of_dicts)

        full_text = full_text + '\n}\n}'

        return full_text

    def make_file(self):

        output_file = open('../other/full_switch.txt', 'w')

        main_text = self.top_and_tail('mainTable', self.main_dict) + '\n\n'

        main_text = main_text + self.top_and_tail('cBTable', self.cb_dict) + '\n\n'

        output_file.write(main_text)

    @staticmethod
    def contains_operator(operand):

        if '+' in operand or '-' in operand:
            return True
        else:
            return False

    def LDgen(self, row):

        if SwitchMaker.contains_operator(row['operand_1']) or SwitchMaker.contains_operator(row['operand_2']):
            return ''
        else:

            dest = self.get_operand(row['operand_1'])
            source = self.get_operand(row['operand_2'])
            # Call read because both bits of operand text refer to objects, not values
            command_text = dest + '.write( ' + source + '.read() );'
            return command_text

if __name__ == "__main__":

    sm = SwitchMaker()
    sm.make_file()