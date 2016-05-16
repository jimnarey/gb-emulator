/**
 * Created by jamesnarey on 17/03/2016.
 */
public class BByte implements ByteInterface {

    protected int data = 0;
    protected final int maxValue = 0xFF;

    public BByte() {


    }

    public int getMaxValue () {
        return maxValue;
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

    public String readString() {

        String formatParameter = "%" + 8 + "s";

        return String.format(formatParameter, Integer.toBinaryString(data & 0xFF)).replace(' ', '0');
    }




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


    public boolean isZero() {

        if (data == 0) {return true;}
        return false;

    }


}
