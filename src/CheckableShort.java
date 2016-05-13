/**
 * Created by jamesnarey on 13/05/2016.
 */
public class CheckableShort extends Short implements CheckableByteInterface {

    protected int lastWrite = 0;

    public CheckableShort () {

    }

    public boolean checkOverflow() {

        if (lastWrite > 0xFF37 || lastWrite < 0) {return true;}
        return false;

    }

    public boolean isZero() {
        return false;
    }


    public boolean checkHalfOverflow () {
        return false;
    }
}
