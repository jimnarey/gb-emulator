/**
 * Created by jamesnarey on 08/05/2016.
 */
public class BytePair extends DataArray {

    public BytePair() {
        super(2);

    }


    public int read() {

        int value = 0;
        for (int i = 0; i < 2; i++) {
            value = value + (units[i].read() << (i * 8));
        }
        return value;

    }

    public void write (int value) {

        for (int i = 0; i < 2; i++) {

            int byteValue = value >>> (i * 8);
            units[i].write(byteValue & 0xFF);
        }

    }


    public void add(int value) {

//        int currentValue = read();
//        currentValue = currentValue + value;
//        write(currentValue);

        write(read() + value);

    }

    public void sub(int value) {

//        int currentValue = read();
//        currentValue = currentValue - value;
//        write(currentValue);

        write(read() - value);

    }

    public void inc() {

        add(1);

    }

    public void dec() {

        sub(1);

    }

}
