/**
 * Created by jamesnarey on 08/05/2016.
 */
public class BShort extends BByteArray implements ByteInterface {

    protected final int maxValue = 0xFFFF;

    public BShort() {
        super(2);
    }

    public BShort(BByte lsb, BByte msb) {
        super(2);
        setUnit(0, lsb);
        setUnit(1, msb);

    }

    public int getMaxValue () {
        return maxValue;
    }

    public static int mergeBytes (BByte lsb, BByte msb) {

        return lsb.read() + (msb.read() << 8);

    }

    public static void splitToBytes (int value, BByte lsb, BByte msb) {

        lsb.write(value & 0xFF);
        msb.write( (value >>> 8) & 0xFF );

    }

    public int read() {

        return mergeBytes(bytes[0], bytes[1]);

    }

    public void write (int value) {

        splitToBytes(value, bytes[0], bytes[1]);

    }


    public void add(int value) {

        write(read() + value);

    }

    public void sub(int value) {

        write(read() - value);

    }

    public void inc() {

        add(1);

    }

    public void dec() {

        sub(1);

    }

}
