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

    # The java returned by each of these functions returns a ByteInterface object
    @staticmethod
    def d8():
        d8_string = 'm.address( r.PC.read() + 1 )'
        return d8_string

    @staticmethod
    def d16():
        d16_string = 'new BytePair( m.address( r.PC.read() + 1 ), m.address( r.PC.read() + 2 ) )'
        return d16_string

    @staticmethod
    def resolve_brackets(bracketed_operand):
        bracketed_operand.replace('(', '')
        bracketed_operand.replace(')', '')
        operand_function = getattr(SwitchMaker, bracketed_operand)
        operand_string = operand_function()
        result_string = 'm.address( ' + operand_string + '.read() )'
        return result_string

    @staticmethod
    def create_array(csv_reader):
        op_table = []
        for row in csv_reader:
            op_table.append(row)
        return op_table

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

    # Think about clearing any whitespace from instructions/operands?

    def main_loop(self):

        def get_operand(operand_source):

            if operand_source in self.registers:
                return operand_source
            else:
                return getattr(SwitchMaker, operand_source)()

        for row in self.main_array:
            
            handler = getattr(SwitchMaker, row[self.columns['instruction']])
            
            if handler:

                operand_1_source = row[self.columns['operand_1']]
                operand_2_source = row[self.columns['operand_2']]
    
                operand_1 = get_operand(operand_1_source)
                operand_2 = get_operand(operand_2_source)
                
                main_line = handler(operand_1, operand_2)

            


    @staticmethod
    def LD(operand_1, operand_2):
        pass

    @staticmethod
    def LDD(operand_1, operand_2):
        pass

    @staticmethod
    def LDI(operand_1, operand_2):
        pass

    @staticmethod
    def LDH(operand_1, operand_2):
        pass

    @staticmethod
    def LDHL(operand_1, operand_2):
        pass

    @staticmethod
    def PUSH(operand_1, operand_2):
        pass

    @staticmethod
    def POP(operand_1, operand_2):
        pass

    @staticmethod
    def ADD(operand_1, operand_2):
        pass

    @staticmethod
    def ADC(operand_1, operand_2):
        pass

    @staticmethod
    def SUB(operand_1, operand_2):
        pass

    @staticmethod
    def SBC(operand_1, operand_2):
        pass

    @staticmethod
    def AND(operand_1, operand_2):
        pass

    @staticmethod
    def OR(operand_1, operand_2):
        pass

    @staticmethod
    def XOR(operand_1, operand_2):
        pass

    @staticmethod
    def CP(operand_1, operand_2):
        pass

    @staticmethod
    def INC(operand_1, operand_2):
        pass

    @staticmethod
    def DEC(operand_1, operand_2):
        pass

    @staticmethod
    def SWAP(operand_1, operand_2):
        pass

    @staticmethod
    def DAA(operand_1, operand_2):
        pass

    @staticmethod
    def CPL(operand_1, operand_2):
        pass

    @staticmethod
    def CCF(operand_1, operand_2):
        pass

    @staticmethod
    def SCF(operand_1, operand_2):
        pass

    @staticmethod
    def NOP(operand_1, operand_2):
        pass

    @staticmethod
    def HALT(operand_1, operand_2):
        pass

    @staticmethod
    def STOP(operand_1, operand_2):
        pass

    @staticmethod
    def DI(operand_1, operand_2):
        pass

    @staticmethod
    def EI(operand_1, operand_2):
        pass

    @staticmethod
    def RLCA(operand_1, operand_2):
        pass

    @staticmethod
    def RLA(operand_1, operand_2):
        pass

    @staticmethod
    def RRCA(operand_1, operand_2):
        pass

    @staticmethod
    def RRA(operand_1, operand_2):
        pass

    @staticmethod
    def RLC(operand_1, operand_2):
        pass

    @staticmethod
    def RL(operand_1, operand_2):
        pass

    @staticmethod
    def RRC(operand_1, operand_2):
        pass

    @staticmethod
    def RR(operand_1, operand_2):
        pass

    @staticmethod
    def SLA(operand_1, operand_2):
        pass

    @staticmethod
    def SRA(operand_1, operand_2):
        pass

    @staticmethod
    def SRL(operand_1, operand_2):
        pass

    @staticmethod
    def BIT(operand_1, operand_2):
        pass

    @staticmethod
    def SET(operand_1, operand_2):
        pass

    @staticmethod
    def RES(operand_1, operand_2):
        pass

    @staticmethod
    def JP(operand_1, operand_2):
        pass

    @staticmethod
    def JR(operand_1, operand_2):
        pass

    @staticmethod
    def CALL(operand_1, operand_2):
        pass

    @staticmethod
    def RST(operand_1, operand_2):
        pass

    @staticmethod
    def RET(operand_1, operand_2):
        pass

    @staticmethod
    def RETI(operand_1, operand_2):
        pass


