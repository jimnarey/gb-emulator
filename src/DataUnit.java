/**
 * Created by jamesnarey on 17/03/2016.
 */
public class DataUnit {

    public int data = 0;
    private int numPermutations;
    private int numBytes;
    private int numBits;
    private int minValue;
    private int maxValue ;
    private int writeMask;

    public DataUnit(int numBytes) {

        this.numBytes = numBytes;
        this.numBits = numBytes * 8;
        this.numPermutations = (int) Math.pow(2, numBits);
        this.minValue = 0;
        this.maxValue = numPermutations - 1;
        this.writeMask = numPermutations - 1;

    }

    public int getNumBits() {
        return numBits;
    }

    public void write(int value) {

        data = value & writeMask;

    }

    public int read() {

        return data;

    }

//    public int readLower() {
//        int i = 0;
//        return i;
//    }
//
//    public void writeLower(int value) {
//
//    }
//
//    public int readByte(int byteNum) {
//        int i = 0;
//
//        if (byteNum < numBytes) {
//            int offset = byteNum * 8;
//            i = data >>> offset;
//            i = i & 0xFF;
//
//        }
//
//        return i;
//
//    }
//
//    public void writeByte(int byteNum, int value) {
//
//        //Consider different approach based on flipping bits
//
//        // Calculate a bitmask covering all bytes 'below' the target bytes
//        // Use a left bit shift in lieu of a Java exponential operator
//        int targetAndLowerBytesMask = (2 << (byteNum * 8)) - 1;
//        int lowerBytesMask = (2 << ((byteNum - 1) * 8)) - 1;
//        int lowerBytes = data & lowerBytesMask;
//        int anyHigherBytes = data - (data & targetAndLowerBytesMask);
//        value = value << ((byteNum - 1) * 8);
//        data = value + lowerBytes + anyHigherBytes;
//
//    }

    public void add(int value) {

        if (data + value > minValue + maxValue) {
            data = (data + value) - numPermutations;
        } else {
            data = data + value;
        }

    }

    public void sub(int value) {

        if (data - value < minValue) {
            data = minValue + numPermutations - (value - data);
        } else {
            data = data - value;
        }

    }

    public void inc() {

        add(1);

    }

    public void dec() {

        sub(1);

    }

    // Refactor to lose an if statement
    public boolean checkBit (int position) {

        if (position <= numPermutations) {

            if (((data >>> position) & 1) != 0) {

                return true;

            }

        }

        return false;

    }

    // Refactor to lose an if statement
    public void  setBit (int position, boolean value) {

        if (position < numPermutations) {


            if (value == true) {

                data = data | (1 << position);

            } else if (value == false) {

                data = ( data & ~(1 << position) );

            }
        }

    }

    public boolean rotateRight () {

        boolean lsb = checkBit(0);

        data = (data >>> 1);

        setBit(numBits - 1, lsb);

        return lsb;
    }

    public boolean rotateLeft () {

        boolean msb = checkBit(numBits - 1);

        data = (data << 1) & maxValue;

        setBit(0, msb);

        return msb;

    }

    public boolean rotateRightThroughFlag (boolean flag) {

        boolean lsb = checkBit(0);

        data = (data >>> 1);

        setBit(numBits - 1, flag);

        return lsb;

    }

    public boolean rotateLeftThroughFlag (boolean flag) {

        boolean msb = checkBit(numBits - 1);

        data = (data << 1) & maxValue;

        setBit(0, flag);

        return msb;
    }

    public String readString() {

        String formatParameter = "%" + numBits + "s";

        return String.format(formatParameter, Integer.toBinaryString(data & writeMask)).replace(' ', '0');
    }

    public void AND (int value) {

        data = data & value;

    }

    public void OR (int value) {

        data =  data | value;

    }

    public void XOR (int value) {

        data =  data ^ value;

    }

    public void complement () {

        data = ~ data & writeMask;

    }

    public void swap () {

        int halfWriteMask = (int) Math.pow (2, (numBits / 2) ) -1;

        int lowerHalf = data & halfWriteMask;
        int upperHalf = (data >>> (numBits / 2) ) & halfWriteMask;

        // System.out.println("halfMask: " + halfWriteMask);
        // System.out.println("lowerHalf: " + lowerHalf);
        // System.out.println("upperHalf: " + upperHalf);
        // System.out.println("result: " + ( (lowerHalf << 4) | (upperHalf) ) );

        data = ((lowerHalf << 4) | (upperHalf));

    }

    public int readSigned () {

        int valueMask = ~ (1 << (numBits - 1)) & writeMask;
        int value = data & valueMask;
        boolean sign = checkBit(numBits);

        if (!sign) {
            value = 0 - value;
        }

        return value;

    }

//    public int offSetRead(int offset, int bits) {
//        int i = 0;
//        return i;
//    }
//
//    public void offSetWrite(int offset, int value) {
//        int temp = value << offset;
//    }

}
