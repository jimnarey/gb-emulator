/**
 * Created by jamesnarey on 15/05/2016.
 */
public class CByteArray extends BByteArray {

    protected CByte[] lastBytes;
    protected CByte[] bytes;
    protected int lastWrite = 0;

    public CByteArray

    public void populate() {
        for (int i = 0; i < this.getNumUnits(); i++) {
            this.bytes[i] = new BByte();
        }
    }

    public void write (int value) {

        lastBytes[0] = bytes[0];
        lastBytes[1] = bytes[1];
        lastWrite = value;
        splitToBytes(value, bytes[0], bytes[1]);


    }

    public boolean checkOverflow() {

        if (lastWrite > 0xFF37 || lastWrite < 0) {return true;}
        return false;

    }

    public boolean isZero() {

        if (read() == 0) {return true;}
        return false;
    }

    // Need to test this thoroughly
    public boolean checkHalfOverflow () {
        if (lastBytes[1].data == 0 && bytes[1].data > 0) {return true;}
        return false;
    }


}
