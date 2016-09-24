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
        d16_string = 'new GBShort( m.address( r.PC.read() + 1 ), m.address( r.PC.read() + 2 ) )'
        return d16_string

    @staticmethod
    def C():
        C_string = 'r.F.getC()'
        return C_string

    @staticmethod
    def NC():
        NC_string = 'r.F.getNotC()'
        return NC_string

    @staticmethod
    def Z():
        Z_string = 'r.F.getZ()'
        return Z_string

    @staticmethod
    def NZ():
        NZ_string = 'r.F.getNotZ()'
        return NZ_string

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
        a16_string = SwitchMaker.d16()
        return a16_string

    @staticmethod
    def resolve_brackets(bracketed_operand):
        result_string = 'm.address( ' + bracketed_operand + '.read() )'
        return result_string

    # Methods for interpreting operands into the correct java code
    def get_register_or_memloc(self, operand, is_jr):

        if operand in self.registers and is_jr is False:
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

    def get_operand(self, input_operand, is_jr=False):

        # Is the operand bracketed?
        if input_operand[0] == '(':

            operand = SwitchMaker.strip_brackets(input_operand)
            operand = self.get_register_or_memloc(operand, False)
            operand = SwitchMaker.resolve_brackets(operand)
            
        else:
            operand = self.get_register_or_memloc(input_operand, is_jr)

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
    def get_flag_methods(row, dest, num_tabs):
        
        flag_string = ''

        if row['Z'] == 'Z':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setZ(' + dest + '.isZero() ); \n'
        elif row['Z'] == '0':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setZ( false ); \n'
        elif row['Z'] == '1':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setZ( true ); \n'
        else:
            pass

        if row['N'] == '0':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setN( false ); \n'
        elif row['N'] == '1':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setN( true ); \n'
        else:
            pass

        if row['H'] == 'H':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setH(' + dest + '.getHalfFlag() ); \n'
        elif row['H'] == '0':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setH( false ); \n'
        elif row['H'] == '1':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setH( true ); \n'
        else:
            pass

        if row['C'] == 'C':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setC(' + dest + '.getCarryFlag() ); \n'
        elif row['C'] == '0':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setC( false ); \n'
        elif row['C'] == '1':
            flag_string = flag_string + SwitchMaker.ins_tabs(num_tabs) + 'r.F.setC( true ); \n'
        else:
            pass

        if flag_string != '':
            flag_string += '\n'

        return flag_string

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
                            '\t\t\t' + '//ins: ' +\
                            row['full_instruction'] + ' -- length: ' + row['length'] + ' -- cycles: ' +\
                            row['cycles'] + ' -- flags: ' + row['Z'] + row['N'] + row['H'] + row['C'] + '\n\n'

                cases_text = cases_text + SwitchMaker.set_opcode_time(row['cycles']) + '\n\n' + '\t\t\t'

                # Single commands
                if row['full_instruction'] == 'CCF':
                    pass
                elif row['full_instruction'] == 'CPL':
                    pass
                elif row['full_instruction'] == 'DAA':
                    pass
                elif row['full_instruction'] == 'DI':
                    pass
                elif row['full_instruction'] == 'EI':
                    pass
                elif row['full_instruction'] == 'HALT':
                    pass
                elif row['full_instruction'] == 'NOP':
                    pass
                elif row['full_instruction'] == 'PREFIX_CB':
                    pass
                elif row['full_instruction'] == 'RETI':
                    pass
                elif row['full_instruction'] == 'RLA':
                    pass
                elif row['full_instruction'] == 'RLCA':
                    pass
                elif row['full_instruction'] == 'RRA':
                    pass
                elif row['full_instruction'] == 'RRCA':
                    pass
                elif row['full_instruction'] == 'SCF':
                    pass
                elif row['full_instruction'] == 'STOP':
                    pass
                # Automatically generated commands, generally those of which there are
                # several instances
                elif row['instruction'] == 'LD':
                    cases_text += self.ld_gen(row)
                elif row['instruction'] in ['INC', 'DEC', 'SWAP']:
                    # Note that this next line adds brackets/line end
                    cases_text += self.simple_single_operand_gen(row, row['instruction'].lower() + '();')
                elif row['instruction'] == 'ADD':
                    cases_text += self.simple_double_operand_gen(row, 'add')
                elif row['instruction'] in ['SUB', 'AND', 'OR', 'XOR', 'CP']:
                    cases_text += self.a_reg_op_gen(row, row['instruction'].lower())
                elif row['instruction'] in ['RES', 'BIT', 'SET']:
                    cases_text += self.single_bit_gen(row)
                elif row['instruction'] == 'ADC':
                    cases_text += self.adc_gen(row)
                elif row['instruction'] == 'SBC':
                    cases_text += self.sbc_gen(row)
                elif row['instruction'] == 'RRC':
                    cases_text += self.simple_single_operand_gen(row, 'rotateRight();')
                elif row['instruction'] == 'RR':
                    cases_text += self.simple_single_operand_gen(row, 'rotateRightThroughFlag( r.F.getC() );')
                elif row['instruction'] == 'RLC':
                    cases_text += self.simple_single_operand_gen(row, 'rotateLeft();')
                elif row['instruction'] == 'RL':
                    cases_text += self.simple_single_operand_gen(row, 'rotateLeftThroughFlag( r.F.getC() );')
                elif row['instruction'] == 'SRA':
                    cases_text += self.sra_sla_srl_gen(row, 'rotateRightThroughFlag', self.get_operand(row['operand_1']) + '.checkBit(7)')
                elif row['instruction'] == 'SLA':
                    cases_text += self.sra_sla_srl_gen(row, 'rotateLeftThroughFlag', 'false')
                elif row['instruction'] == 'SRL':
                    cases_text += self.sra_sla_srl_gen(row, 'rotateRightThroughFlag', 'false')
                elif row['instruction'] == 'RST':
                    cases_text += self.rst_gen(row)
                elif row['instruction'] == 'PUSH':
                    cases_text += self.push_gen(row)
                elif row['instruction'] == 'POP':
                    cases_text += self.pop_gen(row)
                elif row['instruction'] in ['JP']:
                    cases_text += self.jp_gen(row, row['instruction'].lower())
                elif row['instruction'] in ['CALL']:
                    cases_text += self.call_gen(row, row['instruction'].lower())
                elif row['instruction'] in ['JR']:
                    cases_text += self.jr_gen(row, row['instruction'].lower())
                elif row['instruction'] in ['RET']:
                    cases_text += self.ret_gen(row, row['instruction'].lower())

                else:
                    cases_text += self.add_missing(row) + '\n\n'

                # cases_text += '\n\n\n'

                # cases_text += SwitchMaker.get_flag_methods(row, 3)

                cases_text = cases_text + SwitchMaker.get_PC_command(row['length']) + '\n'

                cases_text = cases_text + SwitchMaker.ins_tabs(3) + 'break;' + '\n\n'

        return cases_text

    # Generate single commands

    def CCF(self):
        pass

    def CPL(self):
        pass

    def DAA(self):
        pass

    def DI(self):
        pass

    def EI(self):
        pass

    def HALT(self):
        pass

    def NOP(self):
        pass

    def PREFIX_CB(self):
        pass

    def RETI(self):
        pass

    def RLA(self):
        pass

    def RLCA(self):
        pass

    def RRA(self):
        pass

    def RRCA(self):
        pass

    def SCF(self):
        pass

    def STOP(self):
        pass

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

        skip_list = ['+', '-', 'a8', '+r8']

        for arg in args:

            for item in skip_list:
                if item in arg:
                    return True

        return False

    def add_skip(self, row):
        self.skipped.append(row['full_instruction'])
        return '//**skipped'

    def add_missing(self, row):
        self.missing.append(row['full_instruction'])
        return '//**missing'

    def add_error(self, row):
        self.error.append(row['full_instruction'])
        return '//**error'

    def push_gen(self, row):

        source = self.get_operand(row['operand_1'])

        command_text = 'pushShort( ' + source + ' );' + '\n\n'

        return command_text

    def pop_gen(self, row):

        source = self.get_operand(row['operand_1'])

        command_text = source + '.write( popShort().read() );' + '\n\n'

        return command_text

    def rst_gen(self, row):

        source = row['operand_1'].replace('H', '')
        source = int(source, 16)

        command_text = 'rst( ' + str(source) + ' );' + '\n\n'

        return command_text

    def ld_gen(self, row):

        if SwitchMaker.skip_chars(row['operand_1'], row['operand_2']):
            return self.add_skip(row)

        dest = self.get_operand(row['operand_1'])
        source = self.get_operand(row['operand_2'])
        # Call read because both bits of operand text refer to objects, not values
        command_text = dest + '.write( ' + source + '.read() );' + '\n\n' + SwitchMaker.get_flag_methods(row, dest, 3)
        return command_text

    def single_bit_gen(self, row):

        if row['operand_1'] == '' or row['operand_2'] == '':
            return self.add_skip(row)

        if SwitchMaker.skip_chars(row['operand_1']) or SwitchMaker.skip_chars(row['operand_2']):
            return self.add_skip(row)

        bit = self.get_operand(row['operand_1'])
        byte = self.get_operand(row['operand_2'])

        if row['instruction'] == 'BIT':
            method_string = 'checkBit(' + bit + ')'
        elif row['instruction'] == 'RES':
            method_string = 'setBit(' + bit + ', false' + ')'
        elif row['instruction'] == 'SET':
            method_string = 'setBit(' + bit + ', true' + ')'
        else:
            method_string = self.add_error(row)

        return byte + '.' + method_string + ';' + '\n\n' + SwitchMaker.get_flag_methods(row, byte, 3)

    def adc_gen(self, row):

        if row['operand_1'] == '' or row['operand_2'] == '':
            return self.add_skip(row)

        if SwitchMaker.skip_chars(row['operand_1']) or SwitchMaker.skip_chars(row['operand_2']):
            return self.add_skip(row)

        dest = self.get_operand(row['operand_1'])
        source = self.get_operand(row['operand_2'])

        return dest + '.add( ' + source + '.read() + (r.F.checkBit(4) ? 1 : 0) );' + '\n\n' + SwitchMaker.get_flag_methods(row, dest, 3)

    def sbc_gen(self, row):

        if row['operand_1'] == '' or row['operand_2'] == '':
            return self.add_skip(row)

        if SwitchMaker.skip_chars(row['operand_1']) or SwitchMaker.skip_chars(row['operand_2']):
            return self.add_skip(row)

        dest = self.get_operand(row['operand_1'])
        source = self.get_operand(row['operand_2'])

        return dest + '.sub( ' + source + '.read() + (r.F.checkBit(4) ? 1 : 0) );' + '\n\n' + SwitchMaker.get_flag_methods(row, dest, 3)

    def sra_sla_srl_gen(self, row, method, param):

        if row['operand_2'] == '' and not SwitchMaker.skip_chars(row['operand_1']):
            dest = self.get_operand(row['operand_1'])

            return dest + '.' + method + '(' + param + ');' + '\n\n' + SwitchMaker.get_flag_methods(row, dest, 3)

        return self.add_skip(row)

    def a_reg_op_gen(self, row, method):

        if row['operand_2'] == '' and not SwitchMaker.skip_chars(row['operand_1']):
            source = self.get_operand(row['operand_1'])

            return 'r.A.' + method + '( ' + source + '.read() );' + '\n\n' + SwitchMaker.get_flag_methods(row, 'r.A', 3)

        return self.add_skip(row)

    def simple_single_operand_gen(self, row, method):

        if row['operand_2'] == '' and not SwitchMaker.skip_chars(row['operand_1']):
            dest = self.get_operand(row['operand_1'])

            return dest + '.' + method + '\n\n' + SwitchMaker.get_flag_methods(row, dest, 3)

        return self.add_skip(row)

    def simple_double_operand_gen(self, row, method):

        if row['operand_1'] == '' or row['operand_2'] == '':
            return self.add_skip(row)

        if SwitchMaker.skip_chars(row['operand_1']) or SwitchMaker.skip_chars(row['operand_2']):
            return self.add_skip(row)

        dest = self.get_operand(row['operand_1'])
        source = self.get_operand(row['operand_2'])

        return dest + '.' + method + '( ' + source + '.read() );' + '\n\n' + SwitchMaker.get_flag_methods(row, dest, 3)

    def jp_gen(self, row, method):

        if SwitchMaker.skip_chars(row['operand_1'], row['operand_2']):
            return self.add_skip(row)

        if row['operand_2'] == '':
            source = self.get_operand(row['operand_1'])
            command_text = method + '( true, ' + source + ' );' + '\n\n'
            return command_text

        else:
            cond = self.get_operand(row['operand_1'], True)
            source = self.get_operand(row['operand_2'])
            command_text = method + '( ' + cond + ', ' + source + ' );' + '\n\n'
            return command_text

    def call_gen(self, row, method):

        if SwitchMaker.skip_chars(row['operand_1'], row['operand_2']):
            return self.add_skip(row)

        if row['operand_2'] == '':
            command_text = method + '( true );' + '\n\n'
            return command_text

        else:
            cond = self.get_operand(row['operand_1'], True)
            command_text = method + '( ' + cond + ' );' + '\n\n'
            return command_text

    def jr_gen(self, row, method):

        if row['operand_2'] == '':
            source = self.get_operand(row['operand_1'])
            command_text = method + '( true, ' + source + ' );' + '\n\n'
            return command_text

        else:
            cond = self.get_operand(row['operand_1'], True)
            source = self.get_operand(row['operand_2'])
            command_text = method + '( ' + cond + ', ' + source + ' );' + '\n\n'
            return command_text

    def ret_gen(self, row, method):

        if row['operand_1'] == '':
            command_text = method + '( true );' + '\n\n'
            return command_text

        else:
            cond = self.get_operand(row['operand_1'])
            command_text = method + '( ' + cond + ' );' + '\n\n'
            return command_text

if __name__ == "__main__":

    sm = SwitchMaker()
    output_string = sm.make_string()

    output_file = open('../other/full_switch.txt', 'w')
    output_file.write(output_string)
    output_file.close()

    print('Missing commands: ' + str(output_string.count('missing')))
    print('Skipped commands: ' + str(output_string.count('skipped')))
    print('Blank lines: ' + str(sm.blank_lines))
    print(' ')
    pprint.pprint(sorted(sm.skipped))
    pprint.pprint(sorted(sm.missing))
    pprint.pprint(sorted(sm.error))
