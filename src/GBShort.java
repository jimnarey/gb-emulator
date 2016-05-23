/**
 * Created by jamesnarey on 08/05/2016.
 */
public class GBShort extends GBByteArray implements GBDataInterface {


    public GBShort() {
        super(2);
    }

    public GBShort(GBByte lsb, GBByte msb) {
        super(2);
        setUnit(0, lsb);
        setUnit(1, msb);

    }

    public boolean isZero() {
        if (read() == 0) {return true;}
        return false;
    }

    public boolean getCarryFlag () {
        return bytes[1].carryFlag;
    }

    public boolean getHalfFlag () {
        return bytes[1].halfFlag;
    }

    public static int mergeBytes (GBByte lsb, GBByte msb) {

        return lsb.read() + (msb.read() << 8);

    }

    public static void splitToBytes (int value, GBByte lsb, GBByte msb) {

        lsb.write(value & 0xFF);
        msb.write( (value >>> 8) & 0xFF );

    }

    public int read() {

        return mergeBytes(bytes[0], bytes[1]);

    }

    public void write (int value) {

        splitToBytes(value, bytes[0], bytes[1]);

    }


    public void add(int value) {


        // Need to check the assumption that a sub of an r8 value doesn't ever set the
        // flags of the msb
        if (value < 0) {

            sub(value);

        }
        else {
            bytes[0].add(value & 0xFF);
            bytes[1].add(((value >>> 8) & 0xFF) + (bytes[0].getCarryFlag() ? 1 : 0));
        }
    }

//    public void addAsSigned(int value) {
//
//        if ((( value >>> 7) & 1) == 0) {
//            add(value & 0x7F);
//        }
//        else {
//            sub(value & 0x7F);
//        }
//
//    }

    public void sub(int value) {

        write(read() - value);

    }

    public void inc() {

        add(1);

    }

    public void dec() {

        sub(1);

    }



}
