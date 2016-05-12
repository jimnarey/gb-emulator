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

    # If contains brackets, if a8/a16

    # The java returned by each of these functions returns an int, not an object
    @staticmethod
    def d8():
        d8_string = 'm.address( r.PC.read() + 1 ).read()'
        return d8_string

    @staticmethod
    def d16():
        d16_string = 'BytePair.mergeBytes( m.address( r.PC.read() + 1 ), m.address( r.PC.read() + 2 ) )'
        return d16_string

    @staticmethod
    def resolve_brackets(bracketed_operand):
        bracketed_operand.replace('(', '')
        bracketed_operand.replace(')', '')
        operand_function = getattr(SwitchMaker, bracketed_operand)
        operand_string = operand_function()
        result_string = 'address( ' + operand_string + ' ).read()'
        return result_string

    @staticmethod
    def r8():
        r8_string = 'm.address( r.PC.read() + 1 ).readSigned()'
        return r8_string

    @staticmethod
    def a8():
        a8_string = SwitchMaker.d8()
        return a8_string

    @staticmethod
    def a16():
        a16_string = SwitchMaker.d16()
        return a16_string

    @staticmethod
    def create_array(csv_reader):
        op_table = []
        for row in csv_reader:
            op_table.append(row)
        return op_table

    # Think about clearing any whitespace from instructions/operands?
