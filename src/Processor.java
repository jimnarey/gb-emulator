/**
 * Created by jamesnarey on 11/03/2016.
 */
public class Processor {

    protected Registers r;
    protected Memory m;

    public Processor(Memory memory) {

        this.r = new Registers();
        this.m = memory;

    }

//    public void setFlags (ByteInterface result, boolean wasSubtraction) {
//
//        r.F.write(0);
//        if (result.read() == 0) {r.setZF(true);}
//        r.setNF(wasSubtraction);
//        if (result.)
//
//    }

    public void runInstruction() {

        if (m.address(r.PC.read()).read() == 0xCB) {
            r.PC.inc();
            cBTable();
        }
        else {
            mainTable();
        }

    }

    public void mainTable() {

        switch (r.PC.read())

        {

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
                //and B
                //length 1
                //time 4
                //flags Z010


                break;

            case 0xA1:
                //and C
                //length 1
                //time 4
                //flags Z010


                break;

            case 0xA2:
                //and D
                //length 1
                //time 4
                //flags Z010


                break;

            case 0xA3:
                //and E
                //length 1
                //time 4
                //flags Z010


                break;

            case 0xA4:
                //and H
                //length 1
                //time 4
                //flags Z010


                break;

            case 0xA5:
                //and L
                //length 1
                //time 4
                //flags Z010


                break;

            case 0xA6:
                //and (HL)
                //length 1
                //time 8
                //flags Z010


                break;

            case 0xA7:
                //and A
                //length 1
                //time 4
                //flags Z010


                break;

            case 0xA8:
                //xor B
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xA9:
                //xor C
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xAA:
                //xor D
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xAB:
                //xor E
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xAC:
                //xor H
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xAD:
                //xor L
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xAE:
                //xor (HL)
                //length 1
                //time 8
                //flags Z000


                break;

            case 0xAF:
                //xor A
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB0:
                //or B
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB1:
                //or C
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB2:
                //or D
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB3:
                //or E
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB4:
                //or H
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB5:
                //or L
                //length 1
                //time 4
                //flags Z000


                break;

            case 0xB6:
                //or (HL)
                //length 1
                //time 8
                //flags Z000


                break;

            case 0xB7:
                //or A
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
                //and d8
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
                //xor d8
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
                //or d8
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



    public void cBTable() {


        switch (r.PC.read()) {

            case 0x00:
                //RLC B
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x01:
                //RLC C
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x02:
                //RLC D
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x03:
                //RLC E
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x04:
                //RLC H
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x05:
                //RLC L
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x06:
                //RLC (HL)
                //length 2
                //time 16
                //flags Z00C


                break;

            case 0x07:
                //RLC A
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x08:
                //RRC B
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x09:
                //RRC C
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x0A:
                //RRC D
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x0B:
                //RRC E
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x0C:
                //RRC H
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x0D:
                //RRC L
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x0E:
                //RRC (HL)
                //length 2
                //time 16
                //flags Z00C


                break;

            case 0x0F:
                //RRC A
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x10:
                //RL B
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x11:
                //RL C
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x12:
                //RL D
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x13:
                //RL E
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x14:
                //RL H
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x15:
                //RL L
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x16:
                //RL (HL)
                //length 2
                //time 16
                //flags Z00C


                break;

            case 0x17:
                //RL A
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x18:
                //RR B
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x19:
                //RR C
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x1A:
                //RR D
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x1B:
                //RR E
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x1C:
                //RR H
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x1D:
                //RR L
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x1E:
                //RR (HL)
                //length 2
                //time 16
                //flags Z00C


                break;

            case 0x1F:
                //RR A
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x20:
                //SLA B
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x21:
                //SLA C
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x22:
                //SLA D
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x23:
                //SLA E
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x24:
                //SLA H
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x25:
                //SLA L
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x26:
                //SLA (HL)
                //length 2
                //time 16
                //flags Z00C


                break;

            case 0x27:
                //SLA A
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x28:
                //SRA B
                //length 2
                //time 8
                //flags Z000


                break;

            case 0x29:
                //SRA C
                //length 2
                //time 8
                //flags Z000


                break;

            case 0x2A:
                //SRA D
                //length 2
                //time 8
                //flags Z000


                break;

            case 0x2B:
                //SRA E
                //length 2
                //time 8
                //flags Z000


                break;

            case 0x2C:
                //SRA H
                //length 2
                //time 8
                //flags Z000


                break;

            case 0x2D:
                //SRA L
                //length 2
                //time 8
                //flags Z000


                break;

            case 0x2E:
                //SRA (HL)
                //length 2
                //time 16
                //flags Z000


                break;

            case 0x2F:
                //SRA A
                //length 2
                //time 8
                //flags Z000


                break;

            case 0x30:
                //SWAP B
                //length 2
                //time 8
                //flags Z000


                break;

            case 0x31:
                //SWAP C
                //length 2
                //time 8
                //flags Z000


                break;

            case 0x32:
                //SWAP D
                //length 2
                //time 8
                //flags Z000


                break;

            case 0x33:
                //SWAP E
                //length 2
                //time 8
                //flags Z000


                break;

            case 0x34:
                //SWAP H
                //length 2
                //time 8
                //flags Z000


                break;

            case 0x35:
                //SWAP L
                //length 2
                //time 8
                //flags Z000


                break;

            case 0x36:
                //SWAP (HL)
                //length 2
                //time 16
                //flags Z000


                break;

            case 0x37:
                //SWAP A
                //length 2
                //time 8
                //flags Z000


                break;

            case 0x38:
                //SRL B
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x39:
                //SRL C
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x3A:
                //SRL D
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x3B:
                //SRL E
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x3C:
                //SRL H
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x3D:
                //SRL L
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x3E:
                //SRL (HL)
                //length 2
                //time 16
                //flags Z00C


                break;

            case 0x3F:
                //SRL A
                //length 2
                //time 8
                //flags Z00C


                break;

            case 0x40:
                //BIT 0,B
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x41:
                //BIT 0,C
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x42:
                //BIT 0,D
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x43:
                //BIT 0,E
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x44:
                //BIT 0,H
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x45:
                //BIT 0,L
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x46:
                //BIT 0,(HL)
                //length 2
                //time 16
                //flags Z01-


                break;

            case 0x47:
                //BIT 0,A
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x48:
                //BIT 1,B
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x49:
                //BIT 1,C
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x4A:
                //BIT 1,D
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x4B:
                //BIT 1,E
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x4C:
                //BIT 1,H
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x4D:
                //BIT 1,L
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x4E:
                //BIT 1,(HL)
                //length 2
                //time 16
                //flags Z01-


                break;

            case 0x4F:
                //BIT 1,A
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x50:
                //BIT 2,B
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x51:
                //BIT 2,C
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x52:
                //BIT 2,D
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x53:
                //BIT 2,E
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x54:
                //BIT 2,H
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x55:
                //BIT 2,L
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x56:
                //BIT 2,(HL)
                //length 2
                //time 16
                //flags Z01-


                break;

            case 0x57:
                //BIT 2,A
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x58:
                //BIT 3,B
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x59:
                //BIT 3,C
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x5A:
                //BIT 3,D
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x5B:
                //BIT 3,E
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x5C:
                //BIT 3,H
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x5D:
                //BIT 3,L
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x5E:
                //BIT 3,(HL)
                //length 2
                //time 16
                //flags Z01-


                break;

            case 0x5F:
                //BIT 3,A
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x60:
                //BIT 4,B
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x61:
                //BIT 4,C
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x62:
                //BIT 4,D
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x63:
                //BIT 4,E
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x64:
                //BIT 4,H
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x65:
                //BIT 4,L
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x66:
                //BIT 4,(HL)
                //length 2
                //time 16
                //flags Z01-


                break;

            case 0x67:
                //BIT 4,A
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x68:
                //BIT 5,B
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x69:
                //BIT 5,C
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x6A:
                //BIT 5,D
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x6B:
                //BIT 5,E
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x6C:
                //BIT 5,H
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x6D:
                //BIT 5,L
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x6E:
                //BIT 5,(HL)
                //length 2
                //time 16
                //flags Z01-


                break;

            case 0x6F:
                //BIT 5,A
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x70:
                //BIT 6,B
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x71:
                //BIT 6,C
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x72:
                //BIT 6,D
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x73:
                //BIT 6,E
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x74:
                //BIT 6,H
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x75:
                //BIT 6,L
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x76:
                //BIT 6,(HL)
                //length 2
                //time 16
                //flags Z01-


                break;

            case 0x77:
                //BIT 6,A
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x78:
                //BIT 7,B
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x79:
                //BIT 7,C
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x7A:
                //BIT 7,D
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x7B:
                //BIT 7,E
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x7C:
                //BIT 7,H
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x7D:
                //BIT 7,L
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x7E:
                //BIT 7,(HL)
                //length 2
                //time 16
                //flags Z01-


                break;

            case 0x7F:
                //BIT 7,A
                //length 2
                //time 8
                //flags Z01-


                break;

            case 0x80:
                //RES 0,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0x81:
                //RES 0,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0x82:
                //RES 0,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0x83:
                //RES 0,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0x84:
                //RES 0,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0x85:
                //RES 0,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0x86:
                //RES 0,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0x87:
                //RES 0,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0x88:
                //RES 1,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0x89:
                //RES 1,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0x8A:
                //RES 1,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0x8B:
                //RES 1,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0x8C:
                //RES 1,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0x8D:
                //RES 1,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0x8E:
                //RES 1,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0x8F:
                //RES 1,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0x90:
                //RES 2,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0x91:
                //RES 2,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0x92:
                //RES 2,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0x93:
                //RES 2,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0x94:
                //RES 2,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0x95:
                //RES 2,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0x96:
                //RES 2,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0x97:
                //RES 2,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0x98:
                //RES 3,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0x99:
                //RES 3,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0x9A:
                //RES 3,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0x9B:
                //RES 3,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0x9C:
                //RES 3,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0x9D:
                //RES 3,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0x9E:
                //RES 3,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0x9F:
                //RES 3,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0xA0:
                //RES 4,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0xA1:
                //RES 4,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0xA2:
                //RES 4,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0xA3:
                //RES 4,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0xA4:
                //RES 4,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0xA5:
                //RES 4,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0xA6:
                //RES 4,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0xA7:
                //RES 4,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0xA8:
                //RES 5,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0xA9:
                //RES 5,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0xAA:
                //RES 5,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0xAB:
                //RES 5,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0xAC:
                //RES 5,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0xAD:
                //RES 5,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0xAE:
                //RES 5,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0xAF:
                //RES 5,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0xB0:
                //RES 6,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0xB1:
                //RES 6,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0xB2:
                //RES 6,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0xB3:
                //RES 6,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0xB4:
                //RES 6,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0xB5:
                //RES 6,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0xB6:
                //RES 6,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0xB7:
                //RES 6,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0xB8:
                //RES 7,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0xB9:
                //RES 7,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0xBA:
                //RES 7,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0xBB:
                //RES 7,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0xBC:
                //RES 7,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0xBD:
                //RES 7,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0xBE:
                //RES 7,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0xBF:
                //RES 7,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0xC0:
                //SET 0,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0xC1:
                //SET 0,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0xC2:
                //SET 0,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0xC3:
                //SET 0,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0xC4:
                //SET 0,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0xC5:
                //SET 0,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0xC6:
                //SET 0,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0xC7:
                //SET 0,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0xC8:
                //SET 1,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0xC9:
                //SET 1,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0xCA:
                //SET 1,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0xCB:
                //SET 1,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0xCC:
                //SET 1,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0xCD:
                //SET 1,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0xCE:
                //SET 1,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0xCF:
                //SET 1,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0xD0:
                //SET 2,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0xD1:
                //SET 2,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0xD2:
                //SET 2,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0xD3:
                //SET 2,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0xD4:
                //SET 2,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0xD5:
                //SET 2,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0xD6:
                //SET 2,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0xD7:
                //SET 2,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0xD8:
                //SET 3,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0xD9:
                //SET 3,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0xDA:
                //SET 3,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0xDB:
                //SET 3,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0xDC:
                //SET 3,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0xDD:
                //SET 3,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0xDE:
                //SET 3,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0xDF:
                //SET 3,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0xE0:
                //SET 4,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0xE1:
                //SET 4,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0xE2:
                //SET 4,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0xE3:
                //SET 4,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0xE4:
                //SET 4,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0xE5:
                //SET 4,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0xE6:
                //SET 4,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0xE7:
                //SET 4,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0xE8:
                //SET 5,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0xE9:
                //SET 5,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0xEA:
                //SET 5,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0xEB:
                //SET 5,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0xEC:
                //SET 5,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0xED:
                //SET 5,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0xEE:
                //SET 5,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0xEF:
                //SET 5,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0xF0:
                //SET 6,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0xF1:
                //SET 6,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0xF2:
                //SET 6,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0xF3:
                //SET 6,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0xF4:
                //SET 6,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0xF5:
                //SET 6,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0xF6:
                //SET 6,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0xF7:
                //SET 6,A
                //length 2
                //time 8
                //flags ----


                break;

            case 0xF8:
                //SET 7,B
                //length 2
                //time 8
                //flags ----


                break;

            case 0xF9:
                //SET 7,C
                //length 2
                //time 8
                //flags ----


                break;

            case 0xFA:
                //SET 7,D
                //length 2
                //time 8
                //flags ----


                break;

            case 0xFB:
                //SET 7,E
                //length 2
                //time 8
                //flags ----


                break;

            case 0xFC:
                //SET 7,H
                //length 2
                //time 8
                //flags ----


                break;

            case 0xFD:
                //SET 7,L
                //length 2
                //time 8
                //flags ----


                break;

            case 0xFE:
                //SET 7,(HL)
                //length 2
                //time 16
                //flags ----


                break;

            case 0xFF:
                //SET 7,A
                //length 2
                //time 8
                //flags ----


                break;


        }

    }

}
