/**
 * Created by jamesnarey on 17/03/2016.
 */
public class DataArray {

    protected int numUnits;
    protected BetterByte[] units;

    public DataArray(int numUnits) {

        //Set a maximum number of bytes
        this.numUnits = numUnits;
        this.units = new BetterByte[numUnits];

    }

    public int getNumUnits() {

        return numUnits;
    }

    public void populate() {
        for (int i = 0; i < this.getNumUnits(); i++) {
            this.units[i] = new BetterByte();
        }
    }

    public void setUnit(int position, BetterByte unit) {
        units[position] = unit;
    }


    public BetterByte unit(int position) {

        return units[position];
    }

}
