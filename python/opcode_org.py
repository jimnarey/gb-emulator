#!/usr/bin/python3
import csv


class OpcodeHandler:

    def __init__(self):
        # Open CSV file containing opcode table
        self.csv_file = open('../other/main_opcodes.csv', newline='')
        self.csv_reader = csv.reader(self.csv_file, delimiter=',')
        self.op_table = self.create_code_table()
        self.clean_table = self.remove_line_feeds()
        self.num_table = self.clean_num_cells()
        self.code_list = self.create_code_list()

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
        pass

if __name__ == "__main__":
    ch = OpcodeHandler()
    l = ch.code_list

