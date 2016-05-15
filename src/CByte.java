/**
 * Created by jamesnarey on 13/05/2016.
 */
public class CByte extends BByte implements CByteInterface {

    protected int lastWrite = 0;
    protected int lastData = 0;


    public CByte() {

    }

    public void write(int value) {

        lastData = data;
        lastWrite = value;
        data = value & 0xFF;

    }

    public boolean isZero() {
        if (data == 0) {return true;}
        return false;
    }

    public boolean checkOverflow() {

        if (lastWrite > 0xFF || lastWrite < 0) {return true;}
        return false;

    }

    // http://stackoverflow.com/questions/8034566/overflow-and-carry-flags-on-z80
    // Half carry flag may be set by 255 + 1
    // Check there are not more conditions where this is true (e.g. half-underflow?)
    public boolean checkHalfOverflow () {

        if (lastData < 16 && data >= 16) {return true;}
        return false;
    }

}
