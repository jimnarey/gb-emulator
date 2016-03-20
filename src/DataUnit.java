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

        // Simplify this. What is the calculation to get the correct writeMask from
        // maxValue?

        //this.minValue = 0;
        //this.maxValue = 255;
        //this.writeMask = 0xFF;


        //double power = numBytes * 8;
        //double two = 2;

        this.numBytes = numBytes;
        this.numBits = numBytes * 8;
        this.numPermutations = (int) Math.pow(2, numBits);
        this.minValue = 0;
        this.maxValue = numPermutations - 1;
        this.writeMask = numPermutations - 1;


    }

    public void setMaxValue(int value) {
        maxValue = value;
    }

    public void write(int value) {

        data = value & writeMask;

    }

    public int read() {

        return data;

    }


    // Need to check overflow behaviour
    public void add(int value) {

        if (data + value > minValue + maxValue) {
            data = (data + value) - numPermutations;
        } else {
            data = data + value;
        }

    }

    // Need to check overflow behaviour
    public void sub(int value) {

        if (data - value < minValue) {
            data = minValue + numPermutations - (value - data);
        } else {
            data = data - value;
        }

    }

    // Need to check overflow behaviour
    // Need to add tests
    public void inc() {

        add(1);

    }

    // Need to check overflow behaviour
    // Need to add tests
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

        int flag;

        if ((data & 1) == 1) {

            flag = 1;

        } else  {

            flag = 0;

        }


        return true;
    }

    public boolean rotateRightThroughFlag (boolean flag) {
        return true;
    }

    public boolean rotateLeft () {
        return true;
    }

    public boolean rotateLeftThroughFlag (boolean flag) {
        return true;
    }

    public String readString() {

        String formatParameter = "%" + numBits + "s";

        return String.format(formatParameter, Integer.toBinaryString(data & writeMask)).replace(' ', '0');
    }

}
