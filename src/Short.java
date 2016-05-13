/**
 * Created by jamesnarey on 08/05/2016.
 */
public class Short extends DataArray implements ByteInterface {


    public Short() {
        super(2);
    }

    public Short(BetterByte lsb, BetterByte msb) {
        super(2);
        setUnit(0, lsb);
        setUnit(1, msb);

    }


    public static int mergeBytes (BetterByte lsb, BetterByte msb) {

        return lsb.read() + (msb.read() << 8);

    }

    public static void splitToBytes (int value, BetterByte lsb, BetterByte msb) {

        lsb.write(value & 0xFF);
        msb.write( (value >>> 8) & 0xFF );

    }

    public int read() {

        return mergeBytes(units[0], units[1]);

    }

    public void write (int value) {

        splitToBytes(value, units[0], units[1]);

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
