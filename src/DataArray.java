/**
 * Created by jamesnarey on 17/03/2016.
 */
public class DataArray {

    int numUnits;
    DataUnit[] units;

    public DataArray(int numUnits) {

        this.numUnits = numUnits;
        this.units = new DataUnit[numUnits];
        // What happens if a DataArray object calls methods on a member of units if no
        // *real instance* of DataUnit has been assigned?

    }

    public void setUnit (int position, DataUnit unit) {
        units[position] = unit;
    }

    public int readUnit (int position) {
        return units[position].read();
    }

    public DataUnit accessUnit(int position) {

        return units[position];
    }

    public int read() {

        int value = 0;
        for (int i = 0; i < numUnits; i++) {
            value = value + (units[i].read() << (i * units[i].getNumBits()));
        }
        return value;

    }

    public void write (int value) {

        for (int i = 0; i < numUnits; i++) {

            int byteValue = value >>> (i * units[i].getNumBits());
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
