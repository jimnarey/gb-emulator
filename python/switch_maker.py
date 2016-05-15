import csv
import pprint


class SwitchMaker(object):

    def __init__(self):

        self.columns = {
            '1' : 'opcode',
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

        # Open source files, read as CSV, copy into 2dim array then
        # convert each *row* to a dictionary using the key above (self.columns)

        self.main_table = open('../other/working/op_codes_main.csv', newline='')
        self.cb_table = open('../other/working/op_codes_cb.csv', newline='')

        self.main_csv_reader = csv.reader(self.main_table, delimiter=',')
        self.cb_csv_reader = csv.reader(self.cb_table, delimiter=',')

        self.main_array = SwitchMaker.create_array(self.main_csv_reader)
        self.cb_array = SwitchMaker.create_array(self.cb_csv_reader)

        self.main_dict = self.rows_to_dicts(self.main_array)
        self.cb_dict = self.rows_to_dicts(self.cb_array)

        self.registers = ['A', 'F', 'B', 'C', 'D', 'E', 'H', 'L', 'AF', 'BC', 'DE', 'HL', 'SP', 'PC']

        self.blank_lines = 0
        self.skipped = []
        self.missing = []
        self.error = []

    # Methods for creating initial arrays and dicts

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
                    row_dict[self.columns[str(index)]] = cell
            list_of_dicts.append(row_dict)
        return list_of_dicts

    @staticmethod
    def d8():
        d8_string = 'm.address( r.PC.read() + 1 )'
        return d8_string

    @staticmethod
    def d16():
        d16_string = 'new BShort( m.address( r.PC.read() + 1 ), m.address( r.PC.read() + 2 ) )'
        return d16_string

    @staticmethod
    def r8():
        r8_string = 'm.address( r.PC.read() + 1 ).readSigned()'
        return r8_string

    # Not sure about this! --
    @staticmethod
    def a8():
        # a8_string = SwitchMaker.d8() + '.read()'
        a8_string = SwitchMaker.d8()
        return a8_string

    # Not sure about this! --
    @staticmethod
    def a16():
        #a16_string = SwitchMaker.d16() + '.read()'
        a16_string = SwitchMaker.d16()
        return a16_string

    @staticmethod
    def resolve_brackets(bracketed_operand):
        result_string = 'm.address( ' + bracketed_operand + '.read() )'
        return result_string

    # Methods for interpreting operands into the correct java code
    def get_register_or_memloc(self, operand):

        if operand in self.registers:
            op_text = 'r.' + operand
        elif operand in ['0', '1', '2', '3', '4', '5', '6', '7']:
            op_text = operand
        else:
            op_text = getattr(SwitchMaker, operand)()

        return op_text

    @staticmethod
    def strip_brackets(string):
        result = string.replace('(', '')
        result = result.replace(')', '')
        return result

    def get_operand(self, input_operand):

        # print(input_operand)
        # Is the operand bracketed?
        if input_operand[0] == '(':

            operand = SwitchMaker.strip_brackets(input_operand)
            operand = self.get_register_or_memloc(operand)
            operand = SwitchMaker.resolve_brackets(operand)
            
        else:
            operand = self.get_register_or_memloc(input_operand)

        return operand

    # Generate tabs
    @staticmethod
    def ins_tabs(num):
        tab_string = ''
        i = 0
        while i < num:
            tab_string = tab_string + '\t'
            i += 1

        return tab_string

    # Generate flag setting function calls
    @staticmethod
    def get_flag_methods(row, num_tabs):
        
        flag_string = ''
        
        if row['Z'] != '-':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setZ(' + row['Z'] + '); \n'
        else:
            pass
        
        if row['N'] != '-':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setN(' + row['N'] + '); \n'
        else:
            pass

        if row['H'] != '-':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setH(' + row['H'] + '); \n'
        else:
            pass

        if row['C'] != '-':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setC(' + row['C'] + '); \n'
        else:
            pass
        
        return flag_string + '\n'

    # Generate call to set the number of cycles used by current instruction
    @staticmethod
    def set_opcode_time(cycles):
        if '/' not in cycles:
            return '\t\t\tcurrentOpcodeCycles = ' + cycles + ';'
        else:
            return '\t\t\t//**currentOpcodeCycles = CONDITIONAL;' + cycles

    # Generate call to increment the PC at the end of each opcode's execution
    @staticmethod
    def get_PC_command(length):
        return '\t\t\tr.PC.add(' + length + ');\n'

    # Create a switch statement for either the main opcode table or the CB table
    # taking a dictionary based on one/other as second argument
    def make_cases(self, list_of_dicts):

        cases_text = ''
        for row in list_of_dicts:

            if row['instruction'] == '':
                self.blank_lines += 1

            else:
                cases_text = cases_text +\
                            '\t\t' +\
                            'case ' + '0x' + row['opcode'] + ':' + '\n' +\
                            '\t\t\t' +\
                            '//ins ' +\
                            row['full_instruction'] + '\n' +\
                            '\t\t\t' +\
                            '//length ' +\
                            row['length'] + '\n' +\
                            '\t\t\t' +\
                            '//time ' +\
                            row['cycles'] + '\n' +\
                            '\t\t\t' +\
                            '//flags ' +\
                            row['Z'] + row['N'] + row['H'] + row['C'] + '\n\n'

                cases_text = cases_text + SwitchMaker.set_opcode_time(row['cycles']) + '\n\n\n' + '\t\t\t'

                if row['instruction'] in ['LD', 'ADD']:
                    cases_text += self.dest_source_op(row, row['instruction'].lower())
                elif row['instruction'] in ['SUB', 'AND', 'OR', 'XOR', 'ADC', 'SBC']:
                    cases_text += self.a_reg_op(row, row['instruction'].lower())
                elif row['instruction'] in ['SWAP', 'RRC', 'RR', 'RLC', 'RL', 'INC', 'DEC', 'SRL', 'SRA', 'SLA']:
                    cases_text += self.dest_op(row, row['instruction'].lower())
                elif row['instruction'] in ['RES', 'BIT', 'SET']:
                    cases_text += self.single_bit_gen(row)
                else:
                    cases_text += self.add_missing(row)

                cases_text += '\n\n\n'

                cases_text += SwitchMaker.get_flag_methods(row, 3)

                cases_text = cases_text + SwitchMaker.get_PC_command(row['length']) + '\n'

                cases_text = cases_text + SwitchMaker.ins_tabs(3) + 'break;' + '\n\n'

        return cases_text

    # Generate function declaration, line containing switch statement itself and
    # necessary curly braces to wrap around output from main_cases
    def top_and_tail(self, func_name, list_of_dicts):

        full_text = 'public void ' + func_name + ' (int opcode) {\n\n\t' + 'switch(opcode) {\n\n'

        full_text = full_text + self.make_cases(list_of_dicts)

        full_text = full_text + '\n}\n}'

        return full_text

    # Produce a single large string with both switch/case functions (main and cb)
    def make_string(self):

        main_text = self.top_and_tail('mainTable', self.main_dict) + '\n\n'

        main_text = main_text + self.top_and_tail('cBTable', self.cb_dict) + '\n\n'

        return main_text

    @staticmethod
    def skip_chars(*args):

        skip_list = ['+', '-', 'a', 'r']

        for arg in args:

            for char in arg:
                if char in skip_list:
                    return True

        return False

    def add_skip(self, row, reason):
        self.skipped.append([row['full_instruction'], reason])
        return '//**skipped'

    def add_missing(self, row):
        self.missing.append([row['full_instruction'], row['instruction']])
        return '//**missing'

    def add_error(self, row):
        self.error.append(row['full_instruction'])
        return '//**error'

    def dest_op(self, row, method):

        if row['operand_2'] != '':
            return self.add_skip(row, 'Op2 not empty, dest_op')

        elif SwitchMaker.skip_chars(row['operand_1']):
            return self.add_skip(row, 'Op1 has skip chars, dest_op')

        else:
            dest = self.get_operand(row['operand_1'])
            return method + '( ' + dest + ' );'


    def dest_source_op(self, row, method):

        if row['operand_1'] == '':

            return self.add_skip(row, 'Op1 (poss Op2) is empty, dest_source_op')

        elif row['operand_2'] == '':

            return self.add_skip(row, 'Op2 is empty, dest_source_op')

        elif SwitchMaker.skip_chars(row['operand_1']):

            return self.add_skip(row, 'Op1 (poss Op2) has skipchars, dest_source_op')

        elif SwitchMaker.skip_chars(row['operand_2']):

            return self.add_skip(row, 'Op2 has skipchars, dest_source_op')

        else:
            dest = self.get_operand(row['operand_1'])
            source = self.get_operand(row['operand_2'])

            # return dest + '.' + method + '( ' + source + '.read() );'
            return method + '( ' + dest + ', ' + source + ' );'

    def single_bit_gen(self, row):

        if row['operand_1'] == '' or row['operand_2'] == '':
            return self.add_skip(row)

        if SwitchMaker.skip_chars(row['operand_1']) or SwitchMaker.skip_chars(row['operand_2']):
            return self.add_skip(row)

        bit = self.get_operand(row['operand_1'])
        byte = self.get_operand(row['operand_2'])

        if row['instruction'] == 'BIT':
            method_string = 'bit( ' + byte + ', ' + bit +  ' );'
            # method_string = 'checkBit(' + bit + ')'
        elif row['instruction'] == 'RES':
            method_string = 'bit( ' + byte + ', 0' + ' );'
            # method_string = 'setBit(' + bit + ', 0' + ')'
        elif row['instruction'] == 'SET':
            method_string = 'bit( ' + byte + ', 0' + ' );'
            # method_string = 'setBit(' + bit + ', 1' + ')'
        else:
            method_string = self.add_error(row)

        return byte + '.' + method_string + ';'

    def adc_sbc_gen(self, row, method):

        if row['operand_1'] == '' or row['operand_2'] == '':
            return self.add_skip(row)

        if SwitchMaker.skip_chars(row['operand_1']) or SwitchMaker.skip_chars(row['operand_2']):
            return self.add_skip(row)

        source = self.get_operand(row['operand_2'])

        return method + '( ' + source + ' );'

    def a_reg_op(self, row, method):

        if row['operand_2'] != '':
            return self.add_skip(row, 'Op2 not empty')
        elif SwitchMaker.skip_chars(row['operand_1']):
            return self.add_skip(row, 'Op1 has skipchars')
        else:
            source = self.get_operand(row['operand_1'])

            return method + '( ' + source + ' );'


if __name__ == "__main__":

    sm = SwitchMaker()
    output_string = sm.make_string()

    output_file = open('../other/full_switch.txt', 'w')
    output_file.write(output_string)
    output_file.close()

    print('Skipped:')
    pprint.pprint(sorted(sm.skipped))
    print('Missing:')
    pprint.pprint(sorted(sm.missing))
    print('Error:')
    pprint.pprint(sorted(sm.error))
    print(' ')
    print('Missing commands: ' + str(output_string.count('missing')))
    print('Skipped commands: ' + str(output_string.count('skipped')))
    print('Blank lines: ' + str(sm.blank_lines))
