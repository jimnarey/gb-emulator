#!/usr/bin/python3

# ! Incomplete following change of approach

import csv

class OpcodeHandler:

    # Command descriptions
    code_descriptions = {

        'LD': 'Put',
        'LDD': 'Put and decrement',
        'LDI': 'Put and increment',
        'LDH': 'Put in/out of memory address +0xFF00',
        'LDHL': 'Put SP + address into HL',
        'PUSH': 'Push register pair nn onto stack; Decrement Stack Pointer (SP) twice',
        'POP': 'Pop two bytes off stack into register pair nn; Increment Stack Pointer (SP) twice',
        'ADD': 'Add n to A',
        'ADC': 'Add n + Carry flag to A',
        'SUB': 'Subtract n from A',
        'SBC': 'Subtract n + Carry flag from A',
        'AND': 'Logically AND n with A, result in A',
        'OR': 'Logical OR n with register A, result in A',
        'XOR': 'Logical exclusive OR n with register A, result in A',
        'CP': 'Compare A with n; This is basically an A - n subtraction instruction but the results are thrown away',
        'INC': 'Increment register n',
        'DEC': 'Decrement register n',
        'SWAP': 'Swap upper & lower nibles of n',
        'DAA': 'Decimal adjust register A; This instruction adjusts register A so that the correct \
                representation of Binary Coded Decimal (BCD) is obtained',
        'CPL': 'Complement A register; (flip all bits)',
        'CCF': 'Complement carry flag; If C flag is set, then reset it; If C flag is reset, then set it',
        'SCF': 'Set Carry flag',
        'NOP': 'No operation',
        'HALT': 'Power down CPU until an interrupt occurs; Use this when ever possible to reduce energy consumption',
        'STOP': 'Halt CPU & LCD display until button pressed',
        'DI': 'This instruction disables interrupts but not immediately; Interrupts are disabled after \
                instruction after DI is executed',
        'EI': 'Enable interrupts. This intruction enables interrupts but not immediately. Interrupts \
                are enabled after instruction after EI is executed',
        'RLCA': 'Rotate A left. Old bit 7 to Carry flag',
        'RLA': 'Rotate A left through Carry flag',
        'RRCA': 'Rotate A right; Old bit 0 to Carry flag',
        'RRA': 'Rotate A right through Carry flag',
        'RLC': 'Rotate n left; Old bit 7 to Carry flag',
        'RL': 'Rotate n left through Carry flag',
        'RRC': 'Rotate n right; Old bit 0 to Carry flag',
        'RR': 'Rotate n right through Carry flag',
        'SLA': 'Shift n left into Carry; LSB of n set to 0',
        'SRA': 'Shift n right into Carry; MSB doesn`t change',
        'SRL': 'Shift n right into Carry; MSB set to 0',
        'BIT': 'Test bit b in register r',
        'SET': 'Set bit b in register r',
        'RES': 'Reset bit b in register r',
        'JP': 'Jump to address nn; nn = two byte immediate value. (LS byte first); Conditional jump',
        'JR': 'Add n to current address and jump to it; Conditional JR',
        'CALL': 'Push address of next instruction onto stack and then jump to address nn; Conditional CALL',
        'RST': 'Push present address onto stack; Jump to address $0000 + n',
        'RET': 'Pop two bytes from stack & jump to that address; Conditional RET',
        'RETI': 'Pop two bytes from stack & jump to that address then enable interrupts',

    }

    def __init__(self, file_name):
        # Open CSV file containing opcode table
        self.input_file = open(file_name, newline='')
        self.csv_reader = csv.reader(self.input_file, delimiter=',')

        # Run functions to incrementally build command list
        self.op_table = self.create_code_table()
        self.clean_table = self.remove_line_feeds()
        self.num_table = self.clean_num_cells()
        self.code_list = self.create_code_list()
        self.added_list = self.add_columns()

    @staticmethod
    def remove_duplicates(instruction_list):

        short_list = []
        for i in instruction_list:
            if i[6] != '':
                if i[6] not in short_list:
                    short_list.append(i[6])

        return short_list

    @staticmethod
    def fill_binary(bin_string):
        filled_binary = bin_string[2:]
        num_zeros = 8 - len(filled_binary)
        i = 0
        while i < num_zeros:
            filled_binary = '0' + filled_binary
            i += 1
        return filled_binary

    @staticmethod
    def create_methods(instruction_list, file_name):

        method_file = open(file_name, 'w', newline='')

        for i in instruction_list:
            method_file.write('public ' + 'void ' + i + '() {\n\t\n\n\n}\n\n')

    @staticmethod
    def create_annotated_methods(instruction_list, instruction_table, file_name):

        method_file = open(file_name, 'w', newline='')

        for inst in instruction_list:

            annotations = []

            for row in instruction_table:

                if inst == row[6]:

                    annotation = '// ' + row[5] + ' : L' + row[9] + ':T' + row[10] + ': ' + row[11] + ':' + \
                                 row[12] + ':' + row[13] + ':' + row[14] + ' :0x' + row[1]

                    annotations.append(annotation)

            comments = '\n\t'.join(annotations)

            method_file.write('public ' + 'void ' + inst + '() {\n\n\t' + comments + ' \n\n\n\n}\n\n')

        method_file.close()

    @staticmethod
    def create_switch(cmd_list, file_name):

        file_object = open(file_name, 'w')
        section = ""

        for i in cmd_list:

            tmp = str( i[6])

            if len(tmp) == 0:
                print('skipping')

            else:
                print(type(i[5]))
                print('************' + i[5] + ' ' + str( i[0] ) )
                section = section + 'case ' + '0x' + i[1] + ': \n' + '\t//' + i[5] + '\n\t//length ' + i[9] + '\n\t//time ' + i[10] + '\n\t//flags ' + i[11] + i[12] + i[13] + i[14] +'\n\n\n\tbreak;' + '\n\n' 

        
        file_object.write(section)
        file_object.close()



    def create_code_table(self):
        op_table = []
        for row in self.csv_reader:
            # Each row is a list, added to the op_table list
            op_table.append(row)
        return op_table

    def remove_line_feeds(self):
        clean_table = []
        for i in self.op_table:
            clean_row = []
            for j in i:
                clean_row.append(j.replace('\xa0', ' '))
            clean_table.append(clean_row)
        return clean_table

    def clean_num_cells(self):

        num_table = []

        # Iterate through top row and remove spaces and 'x' characters
        top_row = []
        for i in range(len(self.clean_table[0])):
            num_cell = self.clean_table[0][i].replace(' ', '')
            num_cell = num_cell.replace('x', '')
            top_row.append(num_cell)
        num_table.append(top_row)

        # Iterate through remaining rows and remove spaces and 'x' characters from first cell
        for i in range(1, len(self.clean_table)):
            num_row = []
            num_cell = self.clean_table[i][0].replace(' ', '')
            num_cell = num_cell.replace('x', '')
            num_row.append(num_cell)

            for j in range(1, len(self.clean_table[i])):
                num_row.append(self.clean_table[i][j])
            num_table.append(num_row)

        return num_table

    def create_code_list(self):

        code_list = []
        # Iterate through rows in table, ignoring first
        for i in range(1, len(self.num_table)):

            # Iterate through cells in each row, ignoring first
            for j in range(1, len(self.num_table[i])):

                list_item = self.num_table[i][j]

                nibble_1 = self.num_table[i][0]
                nibble_2 = self.num_table[0][j]

                list_item = nibble_1 + nibble_2 + '\n' + list_item

                list_item = list_item.split('\n')

                code_list.append(list_item)

        return code_list

    def add_columns(self):
        added_list = []
        # added_list.append(['code_no', 'bin_no', 'length', 'duration', 'Z', 'N', 'H', 'C'])

        for i in range(len(self.code_list)):

            added_row = []

            # Add further numerical columns
            dec_number = int(self.code_list[i][0], 16)
            hex_number = self.code_list[i][0]
            bin_number = bin(dec_number)

            added_row.append(dec_number)
            added_row.append(hex_number)

            # Add binary columns
            added_row.append(self.fill_binary(bin_number))

            # Add columns for each nibble
            for p in hex_number:
                nibble = int(p, 16)
                nibble = bin(nibble)
                nibble = self.fill_binary(nibble)[4:]
                added_row.append(nibble)

            # Add command/operand rows

            full_command = self.code_list[i][1]
            added_row.append(full_command)

            mnemonic = ""
            for x in range(len(full_command)):
                if full_command[x] != ' ':
                    mnemonic = mnemonic + full_command[x]
                else:
                    break

            operand_1 = ""
            for y in range(len(mnemonic) + 1, len(full_command)):
                if full_command[y] != ',':
                    operand_1 = operand_1 + full_command[y]
                else:
                    break

            operand_2 = ""
            for z in range(len(mnemonic) + len(operand_1) + 2, len(full_command)):
                    operand_2 = operand_2 + full_command[z]

            added_row.append(mnemonic)
            added_row.append(operand_1)
            added_row.append(operand_2)

            # Split up length and duration columns
            if len(self.code_list[i]) > 2:
                length_and_duration = self.code_list[i][2].replace('  ', ' ')
                length_and_duration = length_and_duration.split(' ')
                for j in length_and_duration:
                    added_row.append(j)

                if len(self.code_list[i]) > 3:
                    flag_columns = self.code_list[i][3].split(' ')
                    for k in flag_columns:
                        added_row.append(k)

            try:
                added_row.append(   OpcodeHandler.code_descriptions[mnemonic])
            except KeyError:
                print('Command ' + mnemonic + ' not found.')

            added_list.append(added_row)

        return added_list

    def write_added_list(self, file_name):
        output_file = open(file_name, 'w', newline='')
        csv_writer = csv.writer(output_file, delimiter=',')

        for i in self.added_list:
            csv_writer.writerow(i)
        output_file.close()


if __name__ == "__main__":

    main_handler = OpcodeHandler('../other/csv/main_opcodes.csv')
    cb_handler = OpcodeHandler('../other/csv/cb_opcodes.csv')

    main_handler.write_added_list('../other/csv/main_list.csv')
    cb_handler.write_added_list('../other/csv/cb_list.csv')

    m = main_handler.added_list

    c = cb_handler.added_list

    ml = OpcodeHandler.remove_duplicates(m)
    cl = OpcodeHandler.remove_duplicates(c)

    #OpcodeHandler.create_methods(ml, '../other/main_methods.txt')
    #OpcodeHandler.create_methods(cl, '../other/cb_methods.txt')

    #OpcodeHandler.create_annotated_methods(ml, m, '../other/main_ann_methods.txt')
    #OpcodeHandler.create_annotated_methods(cl, c, '../other/cb_ann_methods.txt')

    OpcodeHandler.create_switch(m, '../other/switch_text.txt')
    OpcodeHandler.create_switch(c, '../other/cb_switch_text.txt')
