/**
 * Created by jamesnarey on 17/03/2016.
 */
public class BByte implements ByteInterface {

    protected int data = 0;

    public BByte() {


    }


    public void write(int value) {

        data = value & 0xFF;

    }

    public int read() {

        return data;

    }


    public void add(int value) {

        data = (data + value) & 0xFF;

    }

    public void sub(int value) {

        data = (data - value) & 0xFF;


    }

    public void inc() {

        add(1);

    }

    public void dec() {

        sub(1);

    }

    // Refactor to lose an if statement
    // position is zero indexed (i.e. 0 - 7)
    public boolean checkBit (int position) {

        if (position < 8) {

            if (((data >>> position) & 1) != 0) {

                return true;

            }

        }

        return false;

    }

    // Refactor to lose an if statement
    // position is zero indexed (i.e. 0 - 7)
    public void  setBit (int position, boolean value) {

        if (position < 8) {


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

        setBit(7, lsb);

        return lsb;
    }

    public boolean rotateLeft () {

        boolean msb = checkBit(7);

        data = (data << 1) & 0xFF;

        setBit(0, msb);

        return msb;

    }

    public boolean rotateRightThroughFlag (boolean flag) {

        boolean lsb = checkBit(0);

        data = (data >>> 1);

        setBit(7, flag);

        return lsb;

    }

    public boolean rotateLeftThroughFlag (boolean flag) {

        boolean msb = checkBit(7);

        data = (data << 1) & 0xFF;

        setBit(0, flag);

        return msb;
    }

    public String readString() {

        String formatParameter = "%" + 8 + "s";

        return String.format(formatParameter, Integer.toBinaryString(data & 0xFF)).replace(' ', '0');
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

        data = ~ data & 0xFF;

    }

    public void swap () {

        int lowerHalf = data & 0xF;
        int upperHalf = (data >>> 4 ) & 0xF;

        data = ((lowerHalf << 4) | (upperHalf));

    }

    public int readSigned () {

        int value;

        if (data > 127) {
            value = data - 256;
        }
        else {
            value = data;
        }

        return value;

    }


}
