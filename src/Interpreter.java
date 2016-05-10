/**
 * Created by jamesnarey on 10/05/2016.
 */
public class Interpreter {


    public Interpreter() {

    }

    public static void run(int opcode) {

        switch (opcode) {

            case 0x00:
                //NOP
                //length 1
                //time 4
                //flags ----


                break;

            case 0x01:
                //LD BC,d16
                //length 3
                //time 12
                //flags ----


                break;

            case 0x02:
                //LD (BC),A
                //length 1
                //time 8
                //flags ----


                break;

            case 0x03:
                //INC BC
                //length 1
                //time 8
                //flags ----


                break;

            case 0x04:
                //INC B
                //length 1
                //time 4
                //flags Z0H-


                break;

            case 0x05:
                //DEC B
                //length 1
                //time 4
                //flags Z1H-


                break;

            case 0x06:
                //LD B,d8
                //length 2
                //time 8
                //flags ----


                break;

            case 0x07:
                //RLCA
                //length 1
                //time 4
                //flags 000C


                break;

            case 0x08:
                //LD (a16),SP
                //length 3
                //time 20
                //flags ----


                break;

            case 0x09:
                //ADD HL,BC
                //length 1
                //time 8
                //flags -0HC


                break;

            case 0x0A:
                //LD A,(BC)
                //length 1
                //time 8
                //flags ----


                break;

            case 0x0B:
                //DEC BC
                //length 1
                //time 8
                //flags ----


                break;

            case 0x0C:
                //INC C
                //length 1
                //time 4
                //flags Z0H-


                break;

            case 0x0D:
                //DEC C
                //length 1
                //time 4
                //flags Z1H-


                break;

            case 0x0E:
                //LD C,d8
                //length 2
                //time 8
                //flags ----


                break;

            case 0x0F:
                //RRCA
                //length 1
                //time 4
                //flags 000C


                break;

            case 0x10:
                //STOP 0
                //length 2
                //time 4
                //flags ----


                break;

            case 0x11:
                //LD DE,d16
                //length 3
                //time 12
                //flags ----


                break;

            case 0x12:
                //LD (DE),A
                //length 1
                //time 8
                //flags ----


                break;

            case 0x13:
                //INC DE
                //length 1
                //time 8
                //flags ----


                break;

            case 0x14:
                //INC D
                //length 1
                //time 4
                //flags Z0H-


                break;

            case 0x15:
                //DEC D
                //length 1
                //time 4
                //flags Z1H-


                break;

            case 0x16:
                //LD D,d8
                //length 2
                //time 8
                //flags ----


                break;

            case 0x17:
                //RLA
                //length 1
                //time 4
                //flags 000C


                break;

            case 0x18:
                //JR r8
                //length 2
                //time 12
                //flags ----


                break;

            case 0x19:
                //ADD HL,DE
                //length 1
                //time 8
                //flags -0HC


                break;

            case 0x1A:
                //LD A,(DE)
                //length 1
                //time 8
                //flags ----


                break;

            case 0x1B:
                //DEC DE
                //length 1
                //time 8
                //flags ----


                break;

            case 0x1C:
                //INC E
                //length 1
                //time 4
                //flags Z0H-


                break;

            case 0x1D:
                //DEC E
                //length 1
                //time 4
                //flags Z1H-


                break;

            case 0x1E:
                //LD E,d8
                //length 2
                //time 8
                //flags ----


                break;

            case 0x1F:
                //RRA
                //length 1
                //time 4
                //flags 000C


                break;

            case 0x20:
                //JR NZ,r8
                //length 2
                //time 12/8
                //flags ----


                break;

            case 0x21:
                //LD HL,d16
                //length 3
                //time 12
                //flags ----


                break;

            case 0x22:
                //LD (HL+),A
                //length 1
                //time 8
                //flags ----


                break;

            case 0x23:
                //INC HL
                //length 1
                //time 8
                //flags ----


                break;

            case 0x24:
                //INC H
                //length 1
                //time 4
                //flags Z0H-


                break;

            case 0x25:
                //DEC H
                //length 1
                //time 4
                //flags Z1H-


                break;

            case 0x26:
                //LD H,d8
                //length 2
                //time 8
                //flags ----


                break;

            case 0x27:
                //DAA
                //length 1
                //time 4
                //flags Z-0C


                break;

            case 0x28:
                //JR Z,r8
                //length 2
                //time 12/8
                //flags ----


                break;

            case 0x29:
                //ADD HL,HL
                //length 1
                //time 8
                //flags -0HC


                break;

            case 0x2A:
                //LD A,(HL+)
                //length 1
                //time 8
                //flags ----


                break;

            case 0x2B:
                //DEC HL
                //length 1
                //time 8
                //flags ----


                break;

            case 0x2C:
                //INC L
                //length 1
                //time 4
                //flags Z0H-


                break;

            case 0x2D:
                //DEC L
                //length 1
                //time 4
                //flags Z1H-


                break;

            case 0x2E:
                //LD L,d8
                //length 2
                //time 8
                //flags ----


                break;

            case 0x2F:
                //CPL
                //length 1
                //time 4
                //flags -11-


                break;

            case 0x30:
                //JR NC,r8
                //length 2
                //time 12/8
                //flags ----


                break;

            case 0x31:
                //LD SP,d16
                //length 3
                //time 12
                //flags ----


                break;

            case 0x32:
                //LD (HL-),A
                //length 1
                //time 8
                //flags ----


                break;

            case 0x33:
                //INC SP
                //length 1
                //time 8
                //flags ----


                break;

            case 0x34:
                //INC (HL)
                //length 1
                //time 12
                //flags Z0H-


                break;

            case 0x35:
                //DEC (HL)
                //length 1
                //time 12
                //flags Z1H-


                break;

            case 0x36:
                //LD (HL),d8
                //length 2
                //time 12
                //flags ----


                break;

            case 0x37:
                //SCF
                //length 1
                //time 4
                //flags -001


                break;

            case 0x38:
                //JR C,r8
                //length 2
                //time 12/8
                //flags ----


                break;

            case 0x39:
                //ADD HL,SP
                //length 1
                //time 8
                //flags -0HC


                break;

            case 0x3A:
                //LD A,(HL-)
                //length 1
                //time 8
                //flags ----


                break;

            case 0x3B:
                //DEC SP
                //length 1
                //time 8
                //flags ----


                break;

            case 0x3C:
                //INC A
                //length 1
                //time 4
                //flags Z0H-


                break;

            case 0x3D:
                //DEC A
                //length 1
                //time 4
                //flags Z1H-


                break;

            case 0x3E:
                //LD A,d8
                //length 2
                //time 8
                //flags ----


                break;

            case 0x3F:
                //CCF
                //length 1
                //time 4
                //flags -00C


                break;

            case 0x40:
                //LD B,B
                //length 1
                //time 4
                //flags ----


                break;

            case 0x41:
                //LD B,C
                //length 1
                //time 4
                //flags ----


                break;

            case 0x42:
                //LD B,D
                //length 1
                //time 4
                //flags ----


                break;

            case 0x43:
                //LD B,E
                //length 1
                //time 4
                //flags ----


                break;

            case 0x44:
                //LD B,H
                //length 1
                //time 4
                //flags ----


                break;

            case 0x45:
                //LD B,L
                //length 1
                //time 4
                //flags ----


                break;

            case 0x46:
                //LD B,(HL)
                //length 1
                //time 8
                //flags ----


                break;

            case 0x47:
                //LD B,A
                //length 1
                //time 4
                //flags ----


                break;

            case 0x48:
                //LD C,B
                //length 1
                //time 4
                //flags ----


                break;

            case 0x49:
                //LD C,C
                //length 1
                //time 4
                //flags ----


                break;

            case 0x4A:
                //LD C,D
                //length 1
                //time 4
                //flags ----


                break;

            case 0x4B:
                //LD C,E
                //length 1
                //time 4
                //flags ----


                break;

            case 0x4C:
                //LD C,H
                //length 1
                //time 4
                //flags ----


                break;

            case 0x4D:
                //LD C,L
                //length 1
                //time 4
                //flags ----


                break;

            case 0x4E:
                //LD C,(HL)
                //length 1
                //time 8
                //flags ----


                break;

            case 0x4F:
                //LD C,A
                //length 1
                //time 4
                //flags ----


                break;

            case 0x50:
                //LD D,B
                //length 1
                //time 4
                //flags ----


                break;

            case 0x51:
                //LD D,C
                //length 1
                //time 4
                //flags ----


                break;

            case 0x52:
                //LD D,D
                //length 1
                //time 4
                //flags ----


                break;

            case 0x53:
                //LD D,E
                //length 1
                //time 4
                //flags ----


                break;

            case 0x54:
                //LD D,H
                //length 1
                //time 4
                //flags ----


                break;

            case 0x55:
                //LD D,L
                //length 1
                //time 4
                //flags ----


                break;

            case 0x56:
                //LD D,(HL)
                //length 1
                //time 8
                //flags ----


                break;

            case 0x57:
                //LD D,A
                //length 1
                //time 4
                //flags ----


                break;

            case 0x58:
                //LD E,B
                //length 1
                //time 4
                //flags ----


                break;

            case 0x59:
                //LD E,C
                //length 1
                //time 4
                //flags ----


                break;

            case 0x5A:
                //LD E,D
                //length 1
                //time 4
                //flags ----


                break;

            case 0x5B:
                //LD E,E
                //length 1
                //time 4
                //flags ----


                break;

            case 0x5C:
                //LD E,H
                //length 1
                //time 4
                //flags ----


                break;

            case 0x5D:
                //LD E,L
                //length 1
                //time 4
                //flags ----


                break;

            case 0x5E:
                //LD E,(HL)
                //length 1
                //time 8
                //flags ----


                break;

            case 0x5F:
                //LD E,A
                //length 1
                //time 4
                //flags ----


                break;

            case 0x60:
                //LD H,B
                //length 1
                //time 4
                //flags ----


                break;

            case 0x61:
                //LD H,C
                //length 1
                //time 4
                //flags ----


                break;

            case 0x62:
                //LD H,D
                //length 1
                //time 4
                //flags ----


                break;

            case 0x63:
                //LD H,E
                //length 1
                //time 4
                //flags ----


                break;

            case 0x64:
                //LD H,H
                //length 1
                //time 4
                //flags ----


                break;

            case 0x65:
                //LD H,L
                //length 1
                //time 4
                //flags ----


                break;

            case 0x66:
                //LD H,(HL)
                //length 1
                //time 8
                //flags ----


                break;

            case 0x67:
                //LD H,A
                //length 1
                //time 4
                //flags ----


                break;

            case 0x68:
                //LD L,B
                //length 1
                //time 4
                //flags ----


                break;

            case 0x69:
                //LD L,C
                //length 1
                //time 4
                //flags ----


                break;

            case 0x6A:
                //LD L,D
                //length 1
                //time 4
                //flags ----


                break;

            case 0x6B:
                //LD L,E
                //length 1
                //time 4
                //flags ----


                break;

            case 0x6C:
                //LD L,H
                //length 1
                //time 4
                //flags ----


                break;

            case 0x6D:
                //LD L,L
                //length 1
                //time 4
                //flags ----


                break;

            case 0x6E:
                //LD L,(HL)
                //length 1
                //time 8
                //flags ----


                break;

            case 0x6F:
                //LD L,A
                //length 1
                //time 4
                //flags ----


                break;

            case 0x70:
                //LD (HL),B
                //length 1
                //time 8
                //flags ----


                break;

            case 0x71:
                //LD (HL),C
                //length 1
                //time 8
                //flags ----


                break;

            case 0x72:
                //LD (HL),D
                //length 1
                //time 8
                //flags ----


                break;

            case 0x73:
                //LD (HL),E
                //length 1
                //time 8
                //flags ----


                break;

            case 0x74:
                //LD (HL),H
                //length 1
                //time 8
                //flags ----


                break;

            case 0x75:
                //LD (HL),L
                //length 1
                //time 8
                //flags ----


                break;

            case 0x76:
                //HALT
                //length 1
                //time 4
                //flags ----


                break;

            case 0x77:
                //LD (HL),A
                //length 1
                //time 8
                //flags ----


                break;

            case 0x78:
                //LD A,B
                //length 1
                //time 4
                //flags ----


                break;

            case 0x79:
                //LD A,C
                //length 1
                //time 4
                //flags ----


                break;

            case 0x7A:
                //LD A,D
                //length 1
                //time 4
                //flags ----


                break;

            case 0x7B:
                //LD A,E
                //length 1
                //time 4
                //flags ----


                break;

            case 0x7C:
                //LD A,H
                //length 1
                //time 4
                //flags ----


                break;

            case 0x7D:
                //LD A,L
                //length 1
                //time 4
                //flags ----


                break;

            case 0x7E:
                //LD A,(HL)
                //length 1
                //time 8
                //flags ----


                break;

            case 0x7F:
                //LD A,A
                //length 1
                //time 4
                //flags ----


                break;

            case 0x80:
                //ADD A,B
                //length 1
                //time 4
                //flags Z0HC


                break;

            case 0x81:
                //ADD A,C
                //length 1
                //time 4
                //flags Z0HC


                break;

            case 0x82:
                //ADD A,D
                //length 1
                //time 4
                //flags Z0HC


                break;

            case 0x83:
                //ADD A,E
                //length 1
                //time 4
                //flags Z0HC


                break;

            case 0x84:
                //ADD A,H
                //length 1
                //time 4
                //flags Z0HC


                break;

            case 0x85:
                //ADD A,L
                //length 1
                //time 4
                //flags Z0HC


                break;

            case 0x86:
                //ADD A,(HL)
                //length 1
                //time 8
                //flags Z0HC


                break;

            case 0x87:
                //ADD A,A
                //length 1
                //time 4
                //flags Z0HC


                break;

            case 0x88:
                //ADC A,B
                //length 1
                //time 4
                //flags Z0HC


                break;

            case 0x89:
                //ADC A,C
                //length 1
                //time 4
                //flags Z0HC


                break;

            case 0x8A:
                //ADC A,D
                //length 1
                //time 4
                //flags Z0HC


                break;

            case 0x8B:
                //ADC A,E
                //length 1
                //time 4
                //flags Z0HC


                break;

            case 0x8C:
                //ADC A,H
                //length 1
                //time 4
                //flags Z0HC


                break;

            case 0x8D:
                //ADC A,L
                //length 1
                //time 4
                //flags Z0HC


                break;

            case 0x8E:
                //ADC A,(HL)
                //length 1
                //time 8
                //flags Z0HC


                break;

            case 0x8F:
                //ADC A,A
                //length 1
                //time 4
                //flags Z0HC


                break;

            case 0x90:
                //SUB B
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0x91:
                //SUB C
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0x92:
                //SUB D
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0x93:
                //SUB E
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0x94:
                //SUB H
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0x95:
                //SUB L
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0x96:
                //SUB (HL)
                //length 1
                //time 8
                //flags Z1HC


                break;

            case 0x97:
                //SUB A
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0x98:
                //SBC A,B
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0x99:
                //SBC A,C
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0x9A:
                //SBC A,D
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0x9B:
                //SBC A,E
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0x9C:
                //SBC A,H
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0x9D:
                //SBC A,L
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0x9E:
                //SBC A,(HL)
                //length 1
                //time 8
                //flags Z1HC


                break;

            case 0x9F:
                //SBC A,A
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0xA0:
                //AND B
                //length 1
                //time 4
                //flags Z010


                break;

            case 0xA1:
                //AND C
                //length 1
                //time 4
                //flags Z010


                break;

            case 0xA2:
                //AND D
                //length 1
                //time 4
                //flags Z010


                break;

            case 0xA3:
                //AND E
                //length 1
                //time 4
                //flags Z010


                break;

            case 0xA4:
                //AND H
                //length 1
                //time 4
                //flags Z010


                break;

            case 0xA5:
                //AND L
                //length 1
                //time 4
                //flags Z010


                break;

            case 0xA6:
                //AND (HL)
                //length 1
                //time 8
                //flags Z010


                break;

            case 0xA7:
                //AND A
                //length 1
                //time 4
                //flags Z010


                break;

            case 0xA8:
                //XOR B
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xA9:
                //XOR C
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xAA:
                //XOR D
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xAB:
                //XOR E
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xAC:
                //XOR H
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xAD:
                //XOR L
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xAE:
                //XOR (HL)
                //length 1
                //time 8
                //flags Z000


                break;

            case 0xAF:
                //XOR A
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB0:
                //OR B
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB1:
                //OR C
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB2:
                //OR D
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB3:
                //OR E
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB4:
                //OR H
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB5:
                //OR L
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB6:
                //OR (HL)
                //length 1
                //time 8
                //flags Z000


                break;

            case 0xB7:
                //OR A
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB8:
                //CP B
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0xB9:
                //CP C
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0xBA:
                //CP D
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0xBB:
                //CP E
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0xBC:
                //CP H
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0xBD:
                //CP L
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0xBE:
                //CP (HL)
                //length 1
                //time 8
                //flags Z1HC


                break;

            case 0xBF:
                //CP A
                //length 1
                //time 4
                //flags Z1HC


                break;

            case 0xC0:
                //RET NZ
                //length 1
                //time 20/8
                //flags ----


                break;

            case 0xC1:
                //POP BC
                //length 1
                //time 12
                //flags ----


                break;

            case 0xC2:
                //JP NZ,a16
                //length 3
                //time 16/12
                //flags ----


                break;

            case 0xC3:
                //JP a16
                //length 3
                //time 16
                //flags ----


                break;

            case 0xC4:
                //CALL NZ,a16
                //length 3
                //time 24/12
                //flags ----


                break;

            case 0xC5:
                //PUSH BC
                //length 1
                //time 16
                //flags ----


                break;

            case 0xC6:
                //ADD A,d8
                //length 2
                //time 8
                //flags Z0HC


                break;

            case 0xC7:
                //RST 00H
                //length 1
                //time 16
                //flags ----


                break;

            case 0xC8:
                //RET Z
                //length 1
                //time 20/8
                //flags ----


                break;

            case 0xC9:
                //RET
                //length 1
                //time 16
                //flags ----


                break;

            case 0xCA:
                //JP Z,a16
                //length 3
                //time 16/12
                //flags ----


                break;

            case 0xCB:
                //PREFIX CB
                //length 1
                //time 4
                //flags ----


                break;

            case 0xCC:
                //CALL Z,a16
                //length 3
                //time 24/12
                //flags ----


                break;

            case 0xCD:
                //CALL a16
                //length 3
                //time 24
                //flags ----


                break;

            case 0xCE:
                //ADC A,d8
                //length 2
                //time 8
                //flags Z0HC


                break;

            case 0xCF:
                //RST 08H
                //length 1
                //time 16
                //flags ----


                break;

            case 0xD0:
                //RET NC
                //length 1
                //time 20/8
                //flags ----


                break;

            case 0xD1:
                //POP DE
                //length 1
                //time 12
                //flags ----


                break;

            case 0xD2:
                //JP NC,a16
                //length 3
                //time 16/12
                //flags ----


                break;

            case 0xD4:
                //CALL NC,a16
                //length 3
                //time 24/12
                //flags ----


                break;

            case 0xD5:
                //PUSH DE
                //length 1
                //time 16
                //flags ----


                break;

            case 0xD6:
                //SUB d8
                //length 2
                //time 8
                //flags Z1HC


                break;

            case 0xD7:
                //RST 10H
                //length 1
                //time 16
                //flags ----


                break;

            case 0xD8:
                //RET C
                //length 1
                //time 20/8
                //flags ----


                break;

            case 0xD9:
                //RETI
                //length 1
                //time 16
                //flags ----


                break;

            case 0xDA:
                //JP C,a16
                //length 3
                //time 16/12
                //flags ----


                break;

            case 0xDC:
                //CALL C,a16
                //length 3
                //time 24/12
                //flags ----


                break;

            case 0xDE:
                //SBC A,d8
                //length 2
                //time 8
                //flags Z1HC


                break;

            case 0xDF:
                //RST 18H
                //length 1
                //time 16
                //flags ----


                break;

            case 0xE0:
                //LDH (a8),A
                //length 2
                //time 12
                //flags ----


                break;

            case 0xE1:
                //POP HL
                //length 1
                //time 12
                //flags ----


                break;

            case 0xE2:
                //LD (C),A
                //length 2
                //time 8
                //flags ----


                break;

            case 0xE5:
                //PUSH HL
                //length 1
                //time 16
                //flags ----


                break;

            case 0xE6:
                //AND d8
                //length 2
                //time 8
                //flags Z010


                break;

            case 0xE7:
                //RST 20H
                //length 1
                //time 16
                //flags ----


                break;

            case 0xE8:
                //ADD SP,r8
                //length 2
                //time 16
                //flags 00HC


                break;

            case 0xE9:
                //JP (HL)
                //length 1
                //time 4
                //flags ----


                break;

            case 0xEA:
                //LD (a16),A
                //length 3
                //time 16
                //flags ----


                break;

            case 0xEE:
                //XOR d8
                //length 2
                //time 8
                //flags Z000


                break;

            case 0xEF:
                //RST 28H
                //length 1
                //time 16
                //flags ----


                break;

            case 0xF0:
                //LDH A,(a8)
                //length 2
                //time 12
                //flags ----


                break;

            case 0xF1:
                //POP AF
                //length 1
                //time 12
                //flags ZNHC


                break;

            case 0xF2:
                //LD A,(C)
                //length 2
                //time 8
                //flags ----


                break;

            case 0xF3:
                //DI
                //length 1
                //time 4
                //flags ----


                break;

            case 0xF5:
                //PUSH AF
                //length 1
                //time 16
                //flags ----


                break;

            case 0xF6:
                //OR d8
                //length 2
                //time 8
                //flags Z000


                break;

            case 0xF7:
                //RST 30H
                //length 1
                //time 16
                //flags ----


                break;

            case 0xF8:
                //LD HL,SP+r8
                //length 2
                //time 12
                //flags 00HC


                break;

            case 0xF9:
                //LD SP,HL
                //length 1
                //time 8
                //flags ----


                break;

            case 0xFA:
                //LD A,(a16)
                //length 3
                //time 16
                //flags ----


                break;

            case 0xFB:
                //EI
                //length 1
                //time 4
                //flags ----


                break;

            case 0xFE:
                //CP d8
                //length 2
                //time 8
                //flags Z1HC


                break;

            case 0xFF:
                //RST 38H
                //length 1
                //time 16
                //flags ----


                break;

        }


    }

}
