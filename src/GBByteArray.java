/**
 * Created by jamesnarey on 17/03/2016.
 */
public class GBByteArray {

    protected int numUnits;
    protected GBByte[] bytes;

    public GBByteArray(int numUnits) {

        //Set a maximum number of bytes
        this.numUnits = numUnits;
        this.bytes = new GBByte[numUnits];

    }

    public int getNumUnits() {

        return numUnits;
    }

    public void populate() {
        for (int i = 0; i < this.getNumUnits(); i++) {
            this.bytes[i] = new GBByte();
        }
    }

    public void setUnit(int position, GBByte unit) {
        bytes[position] = unit;
    }


    public GBByte unit(int position) {

        return bytes[position];
    }

}
