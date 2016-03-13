/**
 * Created by jamesnarey on 13/03/2016.
 */
public class Registers {

    //8bit registers
    //A is accumulator, F for flags, others general purpose
    //How to neatly join when needed?
    private byte A, F, B, C, D, E, H, L;

    //16bit registers, stack pointer and program counter
    //How to split up if needed?
    private short SP, PC;

    private byte[] temp8;
    private byte[] temp16 = new byte[2];

    public Registers() {



    }
    
    
    public byte readA() {
        return this.A;
    }

    public byte readF() {
        return this.F;
    }

    public byte readB() {
        return  this.B;
    }

    public byte readC() {
        return this.C;
    }

    public byte readD() {
        return this.D;
    }

    public byte readE() {
        return this.E;
    }

    public byte readH() {
        return this.H;
    }

    public byte readL() {
        return this.L;
    }

    public writeA(byte byte_1) {
        this.A = byte_1;
    }

    public writeF(byte byte_1) {
        this.F = byte_1;
    }

    public writeB(byte byte_1) {
         this.B = byte_1;
    }

    public writeC(byte byte_1) {
        this.C = byte_1;
    }

    public writeD(byte byte_1) {
        this.D = byte_1;
    }

    public writeE(byte byte_1) {
        this.E = byte_1;
    }

    public writeH(byte byte_1) {
        this.H = byte_1;
    }

    public writeL(byte byte_1) {
        this.L = byte_1;
    }
    
    public short readAF() {
        return bytes_to_short(this.A, this.F);
        
    }

    public short readBC() {
        return bytes_to_short(this.B, this.C);

    }

    public short readDE() {
        return bytes_to_short(this.D, this.E);

    }

    public short readHL() {
        return bytes_to_short(this.H, this.L);

    }

    public writeShortAF(short byte_pair) {
        byte[] bytes;
        bytes = this.short_to_bytes(byte_pair);

    }

    public writeShortBC() {
        return bytes_to_short(this.B, this.C);

    }

    public writeShortDE() {
        return bytes_to_short(this.D, this.E);

    }

    public writeShortHL() {
        return bytes_to_short(this.H, this.L);

    }
    
    
    private short bytes_to_short(byte byte_1, byte byte_2) {
        return (short) ((byte_1 << 8) | (byte_2 & 0xFF));
    }

    //Find a more efficient way of doing this
    //Consider making static
    private byte[] short_to_bytes(short byte_pair) {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) (byte_pair & 0xff);
        bytes[1] = (byte) ((byte_pair >> 8) & 0xff);
        return bytes;
    }
}
