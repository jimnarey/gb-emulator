/**
 * Created by jamesnarey on 17/03/2016.
 */
public class BByteArray {

    protected int numUnits;
    protected BByte[] bytes;

    public BByteArray(int numUnits) {

        //Set a maximum number of bytes
        this.numUnits = numUnits;
        this.bytes = new BByte[numUnits];

    }

    public int getNumUnits() {

        return numUnits;
    }

    public void populate() {
        for (int i = 0; i < this.getNumUnits(); i++) {
            this.bytes[i] = new BByte();
        }
    }

    public void setUnit(int position, BByte unit) {
        bytes[position] = unit;
    }


    public BByte unit(int position) {

        return bytes[position];
    }

}
