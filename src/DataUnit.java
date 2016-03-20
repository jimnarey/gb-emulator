/**
 * Created by jamesnarey on 17/03/2016.
 */
public class DataUnit {

    private int data = 0;
    private int minValue;
    private int maxValue ;
    private int writeMask = 0xFF;

    public DataUnit(int numBytes) {

        // Simplify this. What is the calculation to get the correct writeMask from
        // maxValue?

        //this.minValue = 0;
        //this.maxValue = 255;
        //this.writeMask = 0xFF;

        int numBits = 2 ^ (8 * numBytes);
        minValue = 0;
        maxValue = numBits - 1;
        writeMask = maxValue;


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

        if (data + value > maxValue) {
            data = (data + value) - maxValue;
        } else {
            data = data + value;
        }

    }

    // Need to check overflow behaviour
    public void sub(int value) {

        if (data - value < minValue) {
            data = maxValue - (value - data);
        } else {
            data = value;
        }

    }

}
