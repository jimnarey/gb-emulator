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

    public byte read8(String source) {

        switch (source) {

            case "A":
                return this.A;

            case "F":
                return this.F;

            case "B":
                return this.B;

            case "C":
                return this.C;

            case "D":
                return this.D;

            case "E":
                return this.E;

            case "H":
                return this.H;

            case "L":
                return this.L;
                
        }
        return 0;
    }

    public void write8(byte input, String target) {

        switch (target) {

            case "A":
                this.A = input;
                break;
            case "F":
                this.F = input;
                break;
            case "B":
                this.B = input;
                break;
            case "C":
                this.C = input;
                break;
            case "D":
                this.D = input;
                break;
            case "E":
                this.E = input;
                break;
            case "H":
                this.F = input;
                break;
            case "L":
                this.L = input;
                break;
        }

    }

    //Check about returning multiple values from one method (i.e. two bytes)
    public byte[] read16(String source) {
        byte[] bytes;

        switch (source) {

            case "AF":
                return this.A;
            
            case "BC":
                return this.F;
            
            case "DE":
                return this.B;
            
            case "HL":
                return this.C;
            
            case "SP":
                bytes = short_to_bytes(this.SP);
                return bytes;

            case "PC":
                bytes = short_to_bytes(this.PC);
                return bytes;
            
        }
        bytes = new byte[2];
        bytes[0] = 0;
        bytes[1] = 1;
        return bytes;
    }

    // Methods for getting LSB/MSB from a 16bit register
    // Method for 16bit to short/vice-versa

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
