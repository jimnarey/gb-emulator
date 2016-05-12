import csv


class SwitchMaker(object):


    def __init__(self):

        self.main_table = open('../other/working/op_codes_implementations.csv', newline='')
        self.cb_table = open('../other/working/op_codes_implementations_cb.csv', newline='')

        self.main_csv_reader = csv.reader(self.main_table, delimiter=',')
        self.cb_csv_reader = csv.reader(self.cb_table, delimiter=',')

        self.main_array = SwitchMaker.create_array(self.main_csv_reader)
        self.cb_array = SwitchMaker.create_array(self.cb_csv_reader)

        self.columns = {
            'opcode': 2,
            'instruction': 6,
            'operand_1': 7,
            'operand_2': 8,
            'length': 9,
            'cycles': 10,
            'Z': 11,
            'N': 12,
            'H': 13,
            'C': 14,
            'write': 18,
        }

        self.registers = ['A', 'F', 'B', 'C', 'D', 'E', 'H', 'L', 'AF', 'BC', 'DE', 'HL', 'SP', 'PC']

        self.reg_name = 'r'

        self.mem_name = 'm'

    def d8(self):
        d8_string = '%s.address(%s.PC.read() + 1).read()' % (self.mem_name, self.reg_name)
        return d8_string

    def d16(self):
        d16_string = 

    @staticmethod
    def create_array(csv_reader):
        op_table = []
        for row in csv_reader:
            op_table.append(row)
        return op_table

    # Think about clearing any whitespace from instructions/operands?
