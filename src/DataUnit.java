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

    public void write(int value) {

        data = value & writeMask;

    }

    public int read() {

        return data;

    }

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



}
