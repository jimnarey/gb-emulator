import java.math.BigInteger;

/**
 * Created by jamesnarey on 17/03/2016.
 */
public class DataArray {

    protected int numUnits;
    protected BByte[] units;

    public DataArray(int numUnits) {

        //Set a maximum number of bytes
        this.numUnits = numUnits;
        this.units = new BByte[numUnits];

    }

    public int getNumUnits() {

        return numUnits;
    }

    public void populate() {
        for (int i = 0; i < this.getNumUnits(); i++) {
            this.units[i] = new BByte();
        }
    }

    public void setUnit(int position, BByte unit) {
        units[position] = unit;
    }


    public BByte unit(int position) {

        return units[position];
    }

}
