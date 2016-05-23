/**
 * Created by jamesnarey on 17/03/2016.
 */
public class GBByteArray {

    protected int numBytes;
    protected GBByte[] bytes;

    public GBByteArray(int numBytes) {

        //Set a maximum number of bytes
        this.numBytes = numBytes;
        this.bytes = new GBByte[numBytes];

    }

    public int getNumBytes() {

        return numBytes;
    }

    public void populate() {
        for (int i = 0; i < this.getNumBytes(); i++) {
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
