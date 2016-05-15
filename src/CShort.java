/**
 * Created by jamesnarey on 13/05/2016.
 */
public class CShort extends BShort implements CheckableByteInterface {

    protected BByte[] lastBytes;
    protected int lastWrite = 0;


    public CShort() {
        super();
        lastBytes = new BByte[2];

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
