/**
 * Created by jamesnarey on 08/05/2016.
 */
public class BytePair extends DataArray implements ByteInterface {

    public BytePair() {
        super(2);
    }

    public BytePair(BByte lsb, BByte msb) {
        super(2);
        setUnit(0, lsb);
        setUnit(1, msb);

    }


    public int read() {
        //Simplify this
        int value = 0;
        for (int i = 0; i < 2; i++) {
            value = value + (units[i].read() << (i * 8));
        }
        return value;

    }

    public void write (int value) {
        //Simplify this
        for (int i = 0; i < 2; i++) {

            int byteValue = value >>> (i * 8);
            units[i].write(byteValue & 0xFF);
        }

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
