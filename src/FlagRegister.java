/**
 * Created by jamesnarey on 13/05/2016.
 */
public class FlagRegister extends BByte {


    public FlagRegister () {

    }

    public void write(int value) {

        data = value & 0xF0; // To ensure that the lower 4 bits always = 0

    }

    public boolean getZ () {

        return checkBit(7);

    }

    public void setZ (boolean value) {

        setBit(7, value);

    }

    public boolean getN () {

        return checkBit(6);

    }

    public void setN (boolean value) {

        setBit(6, value);

    }

    public boolean getH () {

        return checkBit(5);

    }

    public void setH (boolean value) {

        setBit(5, value);

    }

    public boolean getC () {

        return checkBit(4);

    }

    public void setC (boolean value) {

        setBit(4, value);

    }

    public void setZNHC (boolean Z, boolean N, boolean H, boolean C) {

        setZ(Z);
        setN(N);
        setH(H);
        setC(C);

    }

}
