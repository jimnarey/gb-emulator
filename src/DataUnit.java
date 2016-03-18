/**
 * Created by jamesnarey on 17/03/2016.
 */
public class DataUnit {

    private int data = 0;
    private int minValue = 0;
    private int maxValue = 0;
    private int writeMask = 0xFF;

    public DataUnit(int size) {

        // this.data = 0;

        // Simplify this. What is the calculation to get the correct writeMask from
        // maxValue?

        // Do no. of bytes as the constructor parameter, multiply by 255 to get the byte mask?
        if (size == 8) {
            this.minValue = 0;
            this.maxValue = 255;
            this.writeMask = 0xFF;

        } else if (size == 16){
            this.minValue = 0;
            this.maxValue = 65535;
            this.writeMask = 0xFFFF;
        }

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
