#!/usr/bin/python3
import csv


class OpcodeHandler:

    def __init__(self, file_name):
        # Open CSV file containing opcode table
        self.csv_file = open(file_name, newline='')
        self.csv_reader = csv.reader(self.csv_file, delimiter=',')
        self.op_table = self.create_code_table()
        self.clean_table = self.remove_line_feeds()
        self.num_table = self.clean_num_cells()
        self.code_list = self.create_code_list()
        self.added_list = self.add_new_cells()
        self.code_descriptions = {

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

    def create_code_table(self):
        op_table = []
        for row in self.csv_reader:
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

    def split_code_cells(self):
        long_table = []

        for i in self.clean_table:

            long_row = []
            for j in i:
                if '\n' in j:
                    string_list = j.split('\n')
                    for k in string_list:
                        long_row.append(k)
                else:
                    long_row.append(j)

            long_table.append(long_row)

        return long_table

    def clean_num_cells(self):

        num_table = []

        # Iterate through top row and remove spaces and 'x' characters
        top_row = []
        for i in range(len(self.clean_table[0])):
            num_cell = self.clean_table[0][i].replace(' ', '')
            num_cell = num_cell.replace('x', '')
            #print(i)
            top_row.append(num_cell)
        num_table.append(top_row)

        # Iterate through remaining rows
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

    def add_new_cells(self):
        added_list = []
        added_list.append(['code_no', 'bin_no', 'length', 'duration', 'Z', 'N', 'H', 'C'])

        for i in range(len(self.code_list)):

            added_row = []

            # Turn hex value in string into int, then binary encoded as string
            code_number = int(self.code_list[i][0], 16)
            bin_number = bin(code_number)

            added_row.append(code_number)
            added_row.append(bin_number)

            print (i)
            print(self.code_list[i])
            if len(self.code_list[i]) > 2:
                # Split 'length in bytes' and duration columns
                length_and_duration = self.code_list[i][2].replace('  ', ' ')
                length_and_duration = length_and_duration.split(' ')
                for j in length_and_duration:
                    added_row.append(j)

                if len(self.code_list[i]) > 3:
                    # Split flag columns
                    flag_columns = self.code_list[i][3].split(' ')
                    for k in flag_columns:
                        added_row.append(k)

            added_list.append(added_row)

        return added_list


if __name__ == "__main__":

    main_handler = OpcodeHandler('../other/main_opcodes.csv')
    cb_handler = OpcodeHandler('../other/cb_opcodes.csv')

    main_table = main_handler.added_list
    
    cb_table = cb_handler.added_list
