/**
 * Created by jamesnarey on 17/03/2016.
 */
public class GBByte implements GBDataInterface {

    protected int data = 0;
    protected boolean carryFlag = false;
    protected boolean halfFlag = false;

    public GBByte() {


    }

    private void setAddCarryFlag (int newValue) {
        if ( (newValue + data) > 255) {
            carryFlag = true;
        }
        else {
            carryFlag = false;
        }
    }

    private void setSubCarryFlag (int newValue) {
        if ( (data - newValue) < 0) {
            carryFlag = true;
        }
        else {
            carryFlag = false;
        }
    }

    private void setAddHalfFlag (int newValue) {

        if ( ((data & 0xF) + (newValue & 0xF)) > 0xF ) {
            halfFlag = true;
        }
        else {
            halfFlag = false;
        }

    }

    private void setSubHalfFlag (int newValue) {

        if ( ( ((data >>> 4) & 0xF) - ((newValue >>> 4) & 0xF) ) < 0 ) {
            halfFlag = true;
        }
        else {
            halfFlag = false;
        }

    }

    public boolean isZero() {
        if (data == 0) {return true;}
        return false;
    }

    public boolean getCarryFlag () {
        return carryFlag;
    }

    public boolean getHalfFlag () {
        return halfFlag;
    }

    // Could speed this up by just switching between two data ints each time a write
    // is made and changing an 'active' flag which determines which is being used
    // though this would involve an array lookup each time the value is read
    public void write(int value) {

        data = value & 0xFF;

    }

    public int read() {

        return data;

    }

    public void add(int value) {

        if (value < 0) {

            sub(value);
        }
        else {

            setAddCarryFlag(value);
            setAddHalfFlag(value);

            write(data + value);
        }

    }

    public void cp(int value) {
        setSubCarryFlag(value);
        setSubHalfFlag(value);
    }

    public void sub(int value) {

        setSubCarryFlag(value);
        setSubHalfFlag(value);

        write(data - value);

    }

    public void inc() {
        setAddHalfFlag(data + 1);
        write(data + 1);
    }

    public void dec() {
        setSubHalfFlag(data + 1);
        write(data - 1);
    }

//    public void add

    // This and checkBit can be recombined. It doesn't matter if the value of 'position' is
    // greater than the number of used bits, it will correctly return zero
    private boolean checkAnyBit (int value, int position) {

        if (((value >>> position) & 1) != 0) {return true;}
        return false;
    }

    // Refactor to lose an if statement
    // position is zero indexed (i.e. 0 - 7)
    public boolean checkBit (int position) {

        if (position < 8) {return checkAnyBit(data, position);}
        return false;

    }

    // Refactor to lose an if statement
    // position is zero indexed (i.e. 0 - 7)
    public void  setBit (int position, boolean value) {

        if (position < 8) {


            if (value) {

                write(data | (1 << position));

            } else {

                write( data & ~(1 << position) );

            }
        }

    }

    public void rotateRight () {

        boolean lsb = checkBit(0);

        write(data >>> 1);

        setBit(7, lsb);

        carryFlag = lsb;
    }

    public void rotateRightThroughFlag (boolean flag) {

        boolean lsb = checkBit(0);

        write(data >>> 1);

        setBit(7, flag);

        carryFlag =  lsb;

    }

    public void rotateLeft () {

        boolean msb = checkBit(7);

        write(data << 1);

        setBit(0, msb);

        carryFlag =  msb;

    }

    public void rotateLeftThroughFlag (boolean flag) {

        boolean msb = checkBit(7);

        write(data << 1);

        setBit(0, flag);

        carryFlag =  msb;
    }

    public String readString() {

        String formatParameter = "%" + 8 + "s";

        return String.format(formatParameter, Integer.toBinaryString(data & 0xFF)).replace(' ', '0');
    }

    public void and(int value) {

        write(data & value);

    }

    public void or(int value) {

        write(data | value);

    }

    public void xor(int value) {

        write(data ^ value);

    }

    public void complement () {

        write(~ data);

    }

    public void swap () {

        int lowerHalf = data & 0xF;
        int upperHalf = (data >>> 4 ) & 0xF;

        write((lowerHalf << 4) | (upperHalf));

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
