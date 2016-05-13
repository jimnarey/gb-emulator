/**
 * Created by jamesnarey on 13/03/2016.
 */
public class Instructions {

    public Instructions() {



    }

    // Main table instructions

    public static void NOP() {

        // NOP : L1:T4: -:-:-:- :0x00


    }

    public static void LD(ByteInterface dest, ByteInterface source ) {

        dest.write(source.read());

        // LD BC,d16 : L3:T12: -:-:-:- :0x01    16
        // LD (BC),A : L1:T8: -:-:-:- :0x02     8
        // LD B,d8 : L2:T8: -:-:-:- :0x06       8
        // LD (a16),SP : L3:T20: -:-:-:- :0x08  16
        // LD A,(BC) : L1:T8: -:-:-:- :0x0A     8
        // LD C,d8 : L2:T8: -:-:-:- :0x0E       8
        // LD DE,d16 : L3:T12: -:-:-:- :0x11    16
        // LD (DE),A : L1:T8: -:-:-:- :0x12     8
        // LD D,d8 : L2:T8: -:-:-:- :0x16       8
        // LD A,(DE) : L1:T8: -:-:-:- :0x1A     8
        // LD E,d8 : L2:T8: -:-:-:- :0x1E       8
        // LD HL,d16 : L3:T12: -:-:-:- :0x21
        // LD (HL+),A : L1:T8: -:-:-:- :0x22
        // LD H,d8 : L2:T8: -:-:-:- :0x26
        // LD A,(HL+) : L1:T8: -:-:-:- :0x2A
        // LD L,d8 : L2:T8: -:-:-:- :0x2E
        // LD SP,d16 : L3:T12: -:-:-:- :0x31
        // LD (HL-),A : L1:T8: -:-:-:- :0x32
        // LD (HL),d8 : L2:T12: -:-:-:- :0x36
        // LD A,(HL-) : L1:T8: -:-:-:- :0x3A
        // LD A,d8 : L2:T8: -:-:-:- :0x3E
        // LD B,B : L1:T4: -:-:-:- :0x40
        // LD B,C : L1:T4: -:-:-:- :0x41
        // LD B,D : L1:T4: -:-:-:- :0x42
        // LD B,E : L1:T4: -:-:-:- :0x43
        // LD B,H : L1:T4: -:-:-:- :0x44
        // LD B,L : L1:T4: -:-:-:- :0x45
        // LD B,(HL) : L1:T8: -:-:-:- :0x46
        // LD B,A : L1:T4: -:-:-:- :0x47
        // LD C,B : L1:T4: -:-:-:- :0x48
        // LD C,C : L1:T4: -:-:-:- :0x49
        // LD C,D : L1:T4: -:-:-:- :0x4A
        // LD C,E : L1:T4: -:-:-:- :0x4B
        // LD C,H : L1:T4: -:-:-:- :0x4C
        // LD C,L : L1:T4: -:-:-:- :0x4D
        // LD C,(HL) : L1:T8: -:-:-:- :0x4E
        // LD C,A : L1:T4: -:-:-:- :0x4F
        // LD D,B : L1:T4: -:-:-:- :0x50
        // LD D,C : L1:T4: -:-:-:- :0x51
        // LD D,D : L1:T4: -:-:-:- :0x52
        // LD D,E : L1:T4: -:-:-:- :0x53
        // LD D,H : L1:T4: -:-:-:- :0x54
        // LD D,L : L1:T4: -:-:-:- :0x55
        // LD D,(HL) : L1:T8: -:-:-:- :0x56
        // LD D,A : L1:T4: -:-:-:- :0x57
        // LD E,B : L1:T4: -:-:-:- :0x58
        // LD E,C : L1:T4: -:-:-:- :0x59
        // LD E,D : L1:T4: -:-:-:- :0x5A
        // LD E,E : L1:T4: -:-:-:- :0x5B
        // LD E,H : L1:T4: -:-:-:- :0x5C
        // LD E,L : L1:T4: -:-:-:- :0x5D
        // LD E,(HL) : L1:T8: -:-:-:- :0x5E
        // LD E,A : L1:T4: -:-:-:- :0x5F
        // LD H,B : L1:T4: -:-:-:- :0x60
        // LD H,C : L1:T4: -:-:-:- :0x61
        // LD H,D : L1:T4: -:-:-:- :0x62
        // LD H,E : L1:T4: -:-:-:- :0x63
        // LD H,H : L1:T4: -:-:-:- :0x64
        // LD H,L : L1:T4: -:-:-:- :0x65
        // LD H,(HL) : L1:T8: -:-:-:- :0x66
        // LD H,A : L1:T4: -:-:-:- :0x67
        // LD L,B : L1:T4: -:-:-:- :0x68
        // LD L,C : L1:T4: -:-:-:- :0x69
        // LD L,D : L1:T4: -:-:-:- :0x6A
        // LD L,E : L1:T4: -:-:-:- :0x6B
        // LD L,H : L1:T4: -:-:-:- :0x6C
        // LD L,L : L1:T4: -:-:-:- :0x6D
        // LD L,(HL) : L1:T8: -:-:-:- :0x6E
        // LD L,A : L1:T4: -:-:-:- :0x6F
        // LD (HL),B : L1:T8: -:-:-:- :0x70
        // LD (HL),C : L1:T8: -:-:-:- :0x71
        // LD (HL),D : L1:T8: -:-:-:- :0x72
        // LD (HL),E : L1:T8: -:-:-:- :0x73
        // LD (HL),H : L1:T8: -:-:-:- :0x74
        // LD (HL),L : L1:T8: -:-:-:- :0x75
        // LD (HL),A : L1:T8: -:-:-:- :0x77
        // LD A,B : L1:T4: -:-:-:- :0x78
        // LD A,C : L1:T4: -:-:-:- :0x79
        // LD A,D : L1:T4: -:-:-:- :0x7A
        // LD A,E : L1:T4: -:-:-:- :0x7B
        // LD A,H : L1:T4: -:-:-:- :0x7C
        // LD A,L : L1:T4: -:-:-:- :0x7D
        // LD A,(HL) : L1:T8: -:-:-:- :0x7E
        // LD A,A : L1:T4: -:-:-:- :0x7F
        // LD (C),A : L2:T8: -:-:-:- :0xE2
        // LD (a16),A : L3:T16: -:-:-:- :0xEA
        // LD A,(C) : L2:T8: -:-:-:- :0xF2
        // LD HL,SP+r8 : L2:T12: 0:0:H:C :0xF8
        // LD SP,HL : L1:T8: -:-:-:- :0xF9
        // LD A,(a16) : L3:T16: -:-:-:- :0xFA



    }

    public static void INC(ByteInterface target) {

        target.inc();

        // INC BC : L1:T8: -:-:-:- :0x03
        // INC B : L1:T4: Z:0:H:- :0x04
        // INC C : L1:T4: Z:0:H:- :0x0C
        // INC DE : L1:T8: -:-:-:- :0x13
        // INC D : L1:T4: Z:0:H:- :0x14
        // INC E : L1:T4: Z:0:H:- :0x1C
        // INC HL : L1:T8: -:-:-:- :0x23
        // INC H : L1:T4: Z:0:H:- :0x24
        // INC L : L1:T4: Z:0:H:- :0x2C
        // INC SP : L1:T8: -:-:-:- :0x33
        // INC (HL) : L1:T12: Z:0:H:- :0x34
        // INC A : L1:T4: Z:0:H:- :0x3C



    }

    public static void DEC(ByteInterface target) {

        target.dec();

        // DEC B : L1:T4: Z:1:H:- :0x05
        // DEC BC : L1:T8: -:-:-:- :0x0B
        // DEC C : L1:T4: Z:1:H:- :0x0D
        // DEC D : L1:T4: Z:1:H:- :0x15
        // DEC DE : L1:T8: -:-:-:- :0x1B
        // DEC E : L1:T4: Z:1:H:- :0x1D
        // DEC H : L1:T4: Z:1:H:- :0x25
        // DEC HL : L1:T8: -:-:-:- :0x2B
        // DEC L : L1:T4: Z:1:H:- :0x2D
        // DEC (HL) : L1:T12: Z:1:H:- :0x35
        // DEC SP : L1:T8: -:-:-:- :0x3B
        // DEC A : L1:T4: Z:1:H:- :0x3D



    }

    public static void RLCA(BetterByte target) {

        // Target is always A register

        

        // RLCA : L1:T4: 0:0:0:C :0x07



    }

    public static void ADD(ByteInterface addendDest, ByteInterface addend) {
        
        addendDest.add(addend.read());
        
        // ADD HL,BC : L1:T8: -:0:H:C :0x09
        // ADD HL,DE : L1:T8: -:0:H:C :0x19
        // ADD HL,HL : L1:T8: -:0:H:C :0x29
        // ADD HL,SP : L1:T8: -:0:H:C :0x39
        // ADD A,B : L1:T4: Z:0:H:C :0x80
        // ADD A,C : L1:T4: Z:0:H:C :0x81
        // ADD A,D : L1:T4: Z:0:H:C :0x82
        // ADD A,E : L1:T4: Z:0:H:C :0x83
        // ADD A,H : L1:T4: Z:0:H:C :0x84
        // ADD A,L : L1:T4: Z:0:H:C :0x85
        // ADD A,(HL) : L1:T8: Z:0:H:C :0x86
        // ADD A,A : L1:T4: Z:0:H:C :0x87
        // ADD A,d8 : L2:T8: Z:0:H:C :0xC6
        // ADD SP,r8 : L2:T16: 0:0:H:C :0xE8



    }

    public static void RRCA() {

        // RRCA : L1:T4: 0:0:0:C :0x0F



    }

    public static void STOP() {

        // STOP 0 : L2:T4: -:-:-:- :0x10



    }

    public static void RLA() {

        // RLA : L1:T4: 0:0:0:C :0x17



    }

    public static void JR() {

        // JR r8 : L2:T12: -:-:-:- :0x18
        // JR NZ,r8 : L2:T12/8: -:-:-:- :0x20
        // JR Z,r8 : L2:T12/8: -:-:-:- :0x28
        // JR NC,r8 : L2:T12/8: -:-:-:- :0x30
        // JR C,r8 : L2:T12/8: -:-:-:- :0x38



    }

    public static void RRA() {

        // RRA : L1:T4: 0:0:0:C :0x1F



    }

    public static void DAA() {

        // DAA : L1:T4: Z:-:0:C :0x27



    }

    public static void CPL() {

        // CPL : L1:T4: -:1:1:- :0x2F



    }

    public static void SCF() {

        // SCF : L1:T4: -:0:0:1 :0x37



    }

    public static void CCF() {

        // CCF : L1:T4: -:0:0:C :0x3F



    }

    public static void HALT() {

        // HALT : L1:T4: -:-:-:- :0x76



    }

    public static void ADC() {

        // ADC A,B : L1:T4: Z:0:H:C :0x88
        // ADC A,C : L1:T4: Z:0:H:C :0x89
        // ADC A,D : L1:T4: Z:0:H:C :0x8A
        // ADC A,E : L1:T4: Z:0:H:C :0x8B
        // ADC A,H : L1:T4: Z:0:H:C :0x8C
        // ADC A,L : L1:T4: Z:0:H:C :0x8D
        // ADC A,(HL) : L1:T8: Z:0:H:C :0x8E
        // ADC A,A : L1:T4: Z:0:H:C :0x8F
        // ADC A,d8 : L2:T8: Z:0:H:C :0xCE



    }

    public static void SUB(ByteInterface minuendDest, ByteInterface subtrahend) {

        //minuendDest must be the A register

        minuendDest.sub(subtrahend.read());

        // SUB B : L1:T4: Z:1:H:C :0x90
        // SUB C : L1:T4: Z:1:H:C :0x91
        // SUB D : L1:T4: Z:1:H:C :0x92
        // SUB E : L1:T4: Z:1:H:C :0x93
        // SUB H : L1:T4: Z:1:H:C :0x94
        // SUB L : L1:T4: Z:1:H:C :0x95
        // SUB (HL) : L1:T8: Z:1:H:C :0x96
        // SUB A : L1:T4: Z:1:H:C :0x97
        // SUB d8 : L2:T8: Z:1:H:C :0xD6



    }

    public static void SBC() {

        // SBC A,B : L1:T4: Z:1:H:C :0x98
        // SBC A,C : L1:T4: Z:1:H:C :0x99
        // SBC A,D : L1:T4: Z:1:H:C :0x9A
        // SBC A,E : L1:T4: Z:1:H:C :0x9B
        // SBC A,H : L1:T4: Z:1:H:C :0x9C
        // SBC A,L : L1:T4: Z:1:H:C :0x9D
        // SBC A,(HL) : L1:T8: Z:1:H:C :0x9E
        // SBC A,A : L1:T4: Z:1:H:C :0x9F
        // SBC A,d8 : L2:T8: Z:1:H:C :0xDE



    }

    public static void AND() {

        // AND B : L1:T4: Z:0:1:0 :0xA0
        // AND C : L1:T4: Z:0:1:0 :0xA1
        // AND D : L1:T4: Z:0:1:0 :0xA2
        // AND E : L1:T4: Z:0:1:0 :0xA3
        // AND H : L1:T4: Z:0:1:0 :0xA4
        // AND L : L1:T4: Z:0:1:0 :0xA5
        // AND (HL) : L1:T8: Z:0:1:0 :0xA6
        // AND A : L1:T4: Z:0:1:0 :0xA7
        // AND d8 : L2:T8: Z:0:1:0 :0xE6



    }

    public static void XOR() {

        // XOR B : L1:T4: Z:0:0:0 :0xA8
        // XOR C : L1:T4: Z:0:0:0 :0xA9
        // XOR D : L1:T4: Z:0:0:0 :0xAA
        // XOR E : L1:T4: Z:0:0:0 :0xAB
        // XOR H : L1:T4: Z:0:0:0 :0xAC
        // XOR L : L1:T4: Z:0:0:0 :0xAD
        // XOR (HL) : L1:T8: Z:0:0:0 :0xAE
        // XOR A : L1:T4: Z:0:0:0 :0xAF
        // XOR d8 : L2:T8: Z:0:0:0 :0xEE



    }

    public static void OR() {

        // OR B : L1:T4: Z:0:0:0 :0xB0
        // OR C : L1:T4: Z:0:0:0 :0xB1
        // OR D : L1:T4: Z:0:0:0 :0xB2
        // OR E : L1:T4: Z:0:0:0 :0xB3
        // OR H : L1:T4: Z:0:0:0 :0xB4
        // OR L : L1:T4: Z:0:0:0 :0xB5
        // OR (HL) : L1:T8: Z:0:0:0 :0xB6
        // OR A : L1:T4: Z:0:0:0 :0xB7
        // OR d8 : L2:T8: Z:0:0:0 :0xF6



    }

    public static void CP() {

        // CP B : L1:T4: Z:1:H:C :0xB8
        // CP C : L1:T4: Z:1:H:C :0xB9
        // CP D : L1:T4: Z:1:H:C :0xBA
        // CP E : L1:T4: Z:1:H:C :0xBB
        // CP H : L1:T4: Z:1:H:C :0xBC
        // CP L : L1:T4: Z:1:H:C :0xBD
        // CP (HL) : L1:T8: Z:1:H:C :0xBE
        // CP A : L1:T4: Z:1:H:C :0xBF
        // CP d8 : L2:T8: Z:1:H:C :0xFE



    }

    public static void RET() {

        // RET NZ : L1:T20/8: -:-:-:- :0xC0
        // RET Z : L1:T20/8: -:-:-:- :0xC8
        // RET : L1:T16: -:-:-:- :0xC9
        // RET NC : L1:T20/8: -:-:-:- :0xD0
        // RET C : L1:T20/8: -:-:-:- :0xD8



    }

    public static void POP() {
        // Addresses flagregister
        // POP BC : L1:T12: -:-:-:- :0xC1
        // POP DE : L1:T12: -:-:-:- :0xD1
        // POP HL : L1:T12: -:-:-:- :0xE1
        // POP AF : L1:T12: Z:N:H:C :0xF1



    }

    public static void JP() {

        // JP NZ,a16 : L3:T16/12: -:-:-:- :0xC2
        // JP a16 : L3:T16: -:-:-:- :0xC3
        // JP Z,a16 : L3:T16/12: -:-:-:- :0xCA
        // JP NC,a16 : L3:T16/12: -:-:-:- :0xD2
        // JP C,a16 : L3:T16/12: -:-:-:- :0xDA
        // JP (HL) : L1:T4: -:-:-:- :0xE9



    }

    public static void CALL() {

        // CALL NZ,a16 : L3:T24/12: -:-:-:- :0xC4
        // CALL Z,a16 : L3:T24/12: -:-:-:- :0xCC
        // CALL a16 : L3:T24: -:-:-:- :0xCD
        // CALL NC,a16 : L3:T24/12: -:-:-:- :0xD4
        // CALL C,a16 : L3:T24/12: -:-:-:- :0xDC



    }

    public static void PUSH() {
        // Addresses flagregister
        // PUSH BC : L1:T16: -:-:-:- :0xC5
        // PUSH DE : L1:T16: -:-:-:- :0xD5
        // PUSH HL : L1:T16: -:-:-:- :0xE5
        // PUSH AF : L1:T16: -:-:-:- :0xF5



    }

    public static void RST() {

        // RST 00H : L1:T16: -:-:-:- :0xC7
        // RST 08H : L1:T16: -:-:-:- :0xCF
        // RST 10H : L1:T16: -:-:-:- :0xD7
        // RST 18H : L1:T16: -:-:-:- :0xDF
        // RST 20H : L1:T16: -:-:-:- :0xE7
        // RST 28H : L1:T16: -:-:-:- :0xEF
        // RST 30H : L1:T16: -:-:-:- :0xF7
        // RST 38H : L1:T16: -:-:-:- :0xFF



    }

    public static void PREFIX() {

        // PREFIX CB : L1:T4: -:-:-:- :0xCB



    }

    public static void RETI() {

        // RETI : L1:T16: -:-:-:- :0xD9



    }

    public static void LDH() {

        // LDH (a8),A : L2:T12: -:-:-:- :0xE0
        // LDH A,(a8) : L2:T12: -:-:-:- :0xF0



    }

    public static void DI() {

        // DI : L1:T4: -:-:-:- :0xF3



    }

    public static void EI() {

        // EI : L1:T4: -:-:-:- :0xFB



    }


    // CB table instructions

    public static void RLC() {

        // RLC B : L2:T8: Z:0:0:C :0x00
        // RLC C : L2:T8: Z:0:0:C :0x01
        // RLC D : L2:T8: Z:0:0:C :0x02
        // RLC E : L2:T8: Z:0:0:C :0x03
        // RLC H : L2:T8: Z:0:0:C :0x04
        // RLC L : L2:T8: Z:0:0:C :0x05
        // RLC (HL) : L2:T16: Z:0:0:C :0x06
        // RLC A : L2:T8: Z:0:0:C :0x07



    }

    public static void RRC() {

        // RRC B : L2:T8: Z:0:0:C :0x08
        // RRC C : L2:T8: Z:0:0:C :0x09
        // RRC D : L2:T8: Z:0:0:C :0x0A
        // RRC E : L2:T8: Z:0:0:C :0x0B
        // RRC H : L2:T8: Z:0:0:C :0x0C
        // RRC L : L2:T8: Z:0:0:C :0x0D
        // RRC (HL) : L2:T16: Z:0:0:C :0x0E
        // RRC A : L2:T8: Z:0:0:C :0x0F



    }

    public static void RL() {

        // RL B : L2:T8: Z:0:0:C :0x10
        // RL C : L2:T8: Z:0:0:C :0x11
        // RL D : L2:T8: Z:0:0:C :0x12
        // RL E : L2:T8: Z:0:0:C :0x13
        // RL H : L2:T8: Z:0:0:C :0x14
        // RL L : L2:T8: Z:0:0:C :0x15
        // RL (HL) : L2:T16: Z:0:0:C :0x16
        // RL A : L2:T8: Z:0:0:C :0x17



    }

    public static void RR() {

        // RR B : L2:T8: Z:0:0:C :0x18
        // RR C : L2:T8: Z:0:0:C :0x19
        // RR D : L2:T8: Z:0:0:C :0x1A
        // RR E : L2:T8: Z:0:0:C :0x1B
        // RR H : L2:T8: Z:0:0:C :0x1C
        // RR L : L2:T8: Z:0:0:C :0x1D
        // RR (HL) : L2:T16: Z:0:0:C :0x1E
        // RR A : L2:T8: Z:0:0:C :0x1F



    }

    public static void SLA() {

        // SLA B : L2:T8: Z:0:0:C :0x20
        // SLA C : L2:T8: Z:0:0:C :0x21
        // SLA D : L2:T8: Z:0:0:C :0x22
        // SLA E : L2:T8: Z:0:0:C :0x23
        // SLA H : L2:T8: Z:0:0:C :0x24
        // SLA L : L2:T8: Z:0:0:C :0x25
        // SLA (HL) : L2:T16: Z:0:0:C :0x26
        // SLA A : L2:T8: Z:0:0:C :0x27



    }

    public static void SRA() {

        // SRA B : L2:T8: Z:0:0:0 :0x28
        // SRA C : L2:T8: Z:0:0:0 :0x29
        // SRA D : L2:T8: Z:0:0:0 :0x2A
        // SRA E : L2:T8: Z:0:0:0 :0x2B
        // SRA H : L2:T8: Z:0:0:0 :0x2C
        // SRA L : L2:T8: Z:0:0:0 :0x2D
        // SRA (HL) : L2:T16: Z:0:0:0 :0x2E
        // SRA A : L2:T8: Z:0:0:0 :0x2F



    }

    public static void SWAP() {

        // SWAP B : L2:T8: Z:0:0:0 :0x30
        // SWAP C : L2:T8: Z:0:0:0 :0x31
        // SWAP D : L2:T8: Z:0:0:0 :0x32
        // SWAP E : L2:T8: Z:0:0:0 :0x33
        // SWAP H : L2:T8: Z:0:0:0 :0x34
        // SWAP L : L2:T8: Z:0:0:0 :0x35
        // SWAP (HL) : L2:T16: Z:0:0:0 :0x36
        // SWAP A : L2:T8: Z:0:0:0 :0x37



    }

    public static void SRL() {

        // SRL B : L2:T8: Z:0:0:C :0x38
        // SRL C : L2:T8: Z:0:0:C :0x39
        // SRL D : L2:T8: Z:0:0:C :0x3A
        // SRL E : L2:T8: Z:0:0:C :0x3B
        // SRL H : L2:T8: Z:0:0:C :0x3C
        // SRL L : L2:T8: Z:0:0:C :0x3D
        // SRL (HL) : L2:T16: Z:0:0:C :0x3E
        // SRL A : L2:T8: Z:0:0:C :0x3F



    }

    public static void BIT() {

        // BIT 0,B : L2:T8: Z:0:1:- :0x40
        // BIT 0,C : L2:T8: Z:0:1:- :0x41
        // BIT 0,D : L2:T8: Z:0:1:- :0x42
        // BIT 0,E : L2:T8: Z:0:1:- :0x43
        // BIT 0,H : L2:T8: Z:0:1:- :0x44
        // BIT 0,L : L2:T8: Z:0:1:- :0x45
        // BIT 0,(HL) : L2:T16: Z:0:1:- :0x46
        // BIT 0,A : L2:T8: Z:0:1:- :0x47
        // BIT 1,B : L2:T8: Z:0:1:- :0x48
        // BIT 1,C : L2:T8: Z:0:1:- :0x49
        // BIT 1,D : L2:T8: Z:0:1:- :0x4A
        // BIT 1,E : L2:T8: Z:0:1:- :0x4B
        // BIT 1,H : L2:T8: Z:0:1:- :0x4C
        // BIT 1,L : L2:T8: Z:0:1:- :0x4D
        // BIT 1,(HL) : L2:T16: Z:0:1:- :0x4E
        // BIT 1,A : L2:T8: Z:0:1:- :0x4F
        // BIT 2,B : L2:T8: Z:0:1:- :0x50
        // BIT 2,C : L2:T8: Z:0:1:- :0x51
        // BIT 2,D : L2:T8: Z:0:1:- :0x52
        // BIT 2,E : L2:T8: Z:0:1:- :0x53
        // BIT 2,H : L2:T8: Z:0:1:- :0x54
        // BIT 2,L : L2:T8: Z:0:1:- :0x55
        // BIT 2,(HL) : L2:T16: Z:0:1:- :0x56
        // BIT 2,A : L2:T8: Z:0:1:- :0x57
        // BIT 3,B : L2:T8: Z:0:1:- :0x58
        // BIT 3,C : L2:T8: Z:0:1:- :0x59
        // BIT 3,D : L2:T8: Z:0:1:- :0x5A
        // BIT 3,E : L2:T8: Z:0:1:- :0x5B
        // BIT 3,H : L2:T8: Z:0:1:- :0x5C
        // BIT 3,L : L2:T8: Z:0:1:- :0x5D
        // BIT 3,(HL) : L2:T16: Z:0:1:- :0x5E
        // BIT 3,A : L2:T8: Z:0:1:- :0x5F
        // BIT 4,B : L2:T8: Z:0:1:- :0x60
        // BIT 4,C : L2:T8: Z:0:1:- :0x61
        // BIT 4,D : L2:T8: Z:0:1:- :0x62
        // BIT 4,E : L2:T8: Z:0:1:- :0x63
        // BIT 4,H : L2:T8: Z:0:1:- :0x64
        // BIT 4,L : L2:T8: Z:0:1:- :0x65
        // BIT 4,(HL) : L2:T16: Z:0:1:- :0x66
        // BIT 4,A : L2:T8: Z:0:1:- :0x67
        // BIT 5,B : L2:T8: Z:0:1:- :0x68
        // BIT 5,C : L2:T8: Z:0:1:- :0x69
        // BIT 5,D : L2:T8: Z:0:1:- :0x6A
        // BIT 5,E : L2:T8: Z:0:1:- :0x6B
        // BIT 5,H : L2:T8: Z:0:1:- :0x6C
        // BIT 5,L : L2:T8: Z:0:1:- :0x6D
        // BIT 5,(HL) : L2:T16: Z:0:1:- :0x6E
        // BIT 5,A : L2:T8: Z:0:1:- :0x6F
        // BIT 6,B : L2:T8: Z:0:1:- :0x70
        // BIT 6,C : L2:T8: Z:0:1:- :0x71
        // BIT 6,D : L2:T8: Z:0:1:- :0x72
        // BIT 6,E : L2:T8: Z:0:1:- :0x73
        // BIT 6,H : L2:T8: Z:0:1:- :0x74
        // BIT 6,L : L2:T8: Z:0:1:- :0x75
        // BIT 6,(HL) : L2:T16: Z:0:1:- :0x76
        // BIT 6,A : L2:T8: Z:0:1:- :0x77
        // BIT 7,B : L2:T8: Z:0:1:- :0x78
        // BIT 7,C : L2:T8: Z:0:1:- :0x79
        // BIT 7,D : L2:T8: Z:0:1:- :0x7A
        // BIT 7,E : L2:T8: Z:0:1:- :0x7B
        // BIT 7,H : L2:T8: Z:0:1:- :0x7C
        // BIT 7,L : L2:T8: Z:0:1:- :0x7D
        // BIT 7,(HL) : L2:T16: Z:0:1:- :0x7E
        // BIT 7,A : L2:T8: Z:0:1:- :0x7F



    }

    public static void RES() {

        // RES 0,B : L2:T8: -:-:-:- :0x80
        // RES 0,C : L2:T8: -:-:-:- :0x81
        // RES 0,D : L2:T8: -:-:-:- :0x82
        // RES 0,E : L2:T8: -:-:-:- :0x83
        // RES 0,H : L2:T8: -:-:-:- :0x84
        // RES 0,L : L2:T8: -:-:-:- :0x85
        // RES 0,(HL) : L2:T16: -:-:-:- :0x86
        // RES 0,A : L2:T8: -:-:-:- :0x87
        // RES 1,B : L2:T8: -:-:-:- :0x88
        // RES 1,C : L2:T8: -:-:-:- :0x89
        // RES 1,D : L2:T8: -:-:-:- :0x8A
        // RES 1,E : L2:T8: -:-:-:- :0x8B
        // RES 1,H : L2:T8: -:-:-:- :0x8C
        // RES 1,L : L2:T8: -:-:-:- :0x8D
        // RES 1,(HL) : L2:T16: -:-:-:- :0x8E
        // RES 1,A : L2:T8: -:-:-:- :0x8F
        // RES 2,B : L2:T8: -:-:-:- :0x90
        // RES 2,C : L2:T8: -:-:-:- :0x91
        // RES 2,D : L2:T8: -:-:-:- :0x92
        // RES 2,E : L2:T8: -:-:-:- :0x93
        // RES 2,H : L2:T8: -:-:-:- :0x94
        // RES 2,L : L2:T8: -:-:-:- :0x95
        // RES 2,(HL) : L2:T16: -:-:-:- :0x96
        // RES 2,A : L2:T8: -:-:-:- :0x97
        // RES 3,B : L2:T8: -:-:-:- :0x98
        // RES 3,C : L2:T8: -:-:-:- :0x99
        // RES 3,D : L2:T8: -:-:-:- :0x9A
        // RES 3,E : L2:T8: -:-:-:- :0x9B
        // RES 3,H : L2:T8: -:-:-:- :0x9C
        // RES 3,L : L2:T8: -:-:-:- :0x9D
        // RES 3,(HL) : L2:T16: -:-:-:- :0x9E
        // RES 3,A : L2:T8: -:-:-:- :0x9F
        // RES 4,B : L2:T8: -:-:-:- :0xA0
        // RES 4,C : L2:T8: -:-:-:- :0xA1
        // RES 4,D : L2:T8: -:-:-:- :0xA2
        // RES 4,E : L2:T8: -:-:-:- :0xA3
        // RES 4,H : L2:T8: -:-:-:- :0xA4
        // RES 4,L : L2:T8: -:-:-:- :0xA5
        // RES 4,(HL) : L2:T16: -:-:-:- :0xA6
        // RES 4,A : L2:T8: -:-:-:- :0xA7
        // RES 5,B : L2:T8: -:-:-:- :0xA8
        // RES 5,C : L2:T8: -:-:-:- :0xA9
        // RES 5,D : L2:T8: -:-:-:- :0xAA
        // RES 5,E : L2:T8: -:-:-:- :0xAB
        // RES 5,H : L2:T8: -:-:-:- :0xAC
        // RES 5,L : L2:T8: -:-:-:- :0xAD
        // RES 5,(HL) : L2:T16: -:-:-:- :0xAE
        // RES 5,A : L2:T8: -:-:-:- :0xAF
        // RES 6,B : L2:T8: -:-:-:- :0xB0
        // RES 6,C : L2:T8: -:-:-:- :0xB1
        // RES 6,D : L2:T8: -:-:-:- :0xB2
        // RES 6,E : L2:T8: -:-:-:- :0xB3
        // RES 6,H : L2:T8: -:-:-:- :0xB4
        // RES 6,L : L2:T8: -:-:-:- :0xB5
        // RES 6,(HL) : L2:T16: -:-:-:- :0xB6
        // RES 6,A : L2:T8: -:-:-:- :0xB7
        // RES 7,B : L2:T8: -:-:-:- :0xB8
        // RES 7,C : L2:T8: -:-:-:- :0xB9
        // RES 7,D : L2:T8: -:-:-:- :0xBA
        // RES 7,E : L2:T8: -:-:-:- :0xBB
        // RES 7,H : L2:T8: -:-:-:- :0xBC
        // RES 7,L : L2:T8: -:-:-:- :0xBD
        // RES 7,(HL) : L2:T16: -:-:-:- :0xBE
        // RES 7,A : L2:T8: -:-:-:- :0xBF



    }

    public static void SET() {

        // SET 0,B : L2:T8: -:-:-:- :0xC0
        // SET 0,C : L2:T8: -:-:-:- :0xC1
        // SET 0,D : L2:T8: -:-:-:- :0xC2
        // SET 0,E : L2:T8: -:-:-:- :0xC3
        // SET 0,H : L2:T8: -:-:-:- :0xC4
        // SET 0,L : L2:T8: -:-:-:- :0xC5
        // SET 0,(HL) : L2:T16: -:-:-:- :0xC6
        // SET 0,A : L2:T8: -:-:-:- :0xC7
        // SET 1,B : L2:T8: -:-:-:- :0xC8
        // SET 1,C : L2:T8: -:-:-:- :0xC9
        // SET 1,D : L2:T8: -:-:-:- :0xCA
        // SET 1,E : L2:T8: -:-:-:- :0xCB
        // SET 1,H : L2:T8: -:-:-:- :0xCC
        // SET 1,L : L2:T8: -:-:-:- :0xCD
        // SET 1,(HL) : L2:T16: -:-:-:- :0xCE
        // SET 1,A : L2:T8: -:-:-:- :0xCF
        // SET 2,B : L2:T8: -:-:-:- :0xD0
        // SET 2,C : L2:T8: -:-:-:- :0xD1
        // SET 2,D : L2:T8: -:-:-:- :0xD2
        // SET 2,E : L2:T8: -:-:-:- :0xD3
        // SET 2,H : L2:T8: -:-:-:- :0xD4
        // SET 2,L : L2:T8: -:-:-:- :0xD5
        // SET 2,(HL) : L2:T16: -:-:-:- :0xD6
        // SET 2,A : L2:T8: -:-:-:- :0xD7
        // SET 3,B : L2:T8: -:-:-:- :0xD8
        // SET 3,C : L2:T8: -:-:-:- :0xD9
        // SET 3,D : L2:T8: -:-:-:- :0xDA
        // SET 3,E : L2:T8: -:-:-:- :0xDB
        // SET 3,H : L2:T8: -:-:-:- :0xDC
        // SET 3,L : L2:T8: -:-:-:- :0xDD
        // SET 3,(HL) : L2:T16: -:-:-:- :0xDE
        // SET 3,A : L2:T8: -:-:-:- :0xDF
        // SET 4,B : L2:T8: -:-:-:- :0xE0
        // SET 4,C : L2:T8: -:-:-:- :0xE1
        // SET 4,D : L2:T8: -:-:-:- :0xE2
        // SET 4,E : L2:T8: -:-:-:- :0xE3
        // SET 4,H : L2:T8: -:-:-:- :0xE4
        // SET 4,L : L2:T8: -:-:-:- :0xE5
        // SET 4,(HL) : L2:T16: -:-:-:- :0xE6
        // SET 4,A : L2:T8: -:-:-:- :0xE7
        // SET 5,B : L2:T8: -:-:-:- :0xE8
        // SET 5,C : L2:T8: -:-:-:- :0xE9
        // SET 5,D : L2:T8: -:-:-:- :0xEA
        // SET 5,E : L2:T8: -:-:-:- :0xEB
        // SET 5,H : L2:T8: -:-:-:- :0xEC
        // SET 5,L : L2:T8: -:-:-:- :0xED
        // SET 5,(HL) : L2:T16: -:-:-:- :0xEE
        // SET 5,A : L2:T8: -:-:-:- :0xEF
        // SET 6,B : L2:T8: -:-:-:- :0xF0
        // SET 6,C : L2:T8: -:-:-:- :0xF1
        // SET 6,D : L2:T8: -:-:-:- :0xF2
        // SET 6,E : L2:T8: -:-:-:- :0xF3
        // SET 6,H : L2:T8: -:-:-:- :0xF4
        // SET 6,L : L2:T8: -:-:-:- :0xF5
        // SET 6,(HL) : L2:T16: -:-:-:- :0xF6
        // SET 6,A : L2:T8: -:-:-:- :0xF7
        // SET 7,B : L2:T8: -:-:-:- :0xF8
        // SET 7,C : L2:T8: -:-:-:- :0xF9
        // SET 7,D : L2:T8: -:-:-:- :0xFA
        // SET 7,E : L2:T8: -:-:-:- :0xFB
        // SET 7,H : L2:T8: -:-:-:- :0xFC
        // SET 7,L : L2:T8: -:-:-:- :0xFD
        // SET 7,(HL) : L2:T16: -:-:-:- :0xFE
        // SET 7,A : L2:T8: -:-:-:- :0xFF



    }



}
