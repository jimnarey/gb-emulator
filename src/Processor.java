/**
 * Created by jamesnarey on 11/03/2016.
 */
public class Processor {

    protected Registers r;
    protected Memory m;

    public Processor(Memory memory) {

        this.r = new Registers();
        this.m = memory;

    }

//    public void runInstruction() {
//
//        if (m.address(r.PC.read()).read() == 0xCB) {
//            r.PC.inc();
//            cBTable();
//        }
//        else {
//            mainTable();
//        }
//
//    }

    public void add(ByteInterface dest, ByteInterface source) {

        dest.write( dest.read() + source.read() );

    }

    public void sub(ByteInterface dest, ByteInterface source) {

        dest.write( dest.read() - source.read() );

    }

    public void inc(ByteInterface dest) {
        dest.write( dest.read() + 1);
    }

    public void dec(ByteInterface dest) {
        dest.write( dest.read() - 1);
    }

    public boolean rotateRight (BByte dest) {

        boolean lsb = dest.checkBit(0);

        dest.write(dest.read() >>> 1);

        dest.setBit(7, lsb);

        return lsb;
    }

    public boolean rotateRightThroughFlag (BByte dest, boolean flag) {

        boolean lsb = dest.checkBit(0);

        dest.write(dest.data >>> 1);

        dest.setBit(7, flag);

        return lsb;

    }

    public boolean rotateLeft (BByte dest) {

        boolean msb = dest.checkBit(7);

        dest.write(dest.data << 1);

        dest.setBit(0, msb);

        return msb;

    }

    public boolean rotateLeftThroughFlag (BByte dest, boolean flag) {

        boolean msb = dest.checkBit(7);

        dest.write(dest.read() << 1);

        dest.setBit(0, flag);

        return msb;
    }

    public void and(BByte dest, BByte source) {

        dest.write(dest.read() & source.read());

    }

    public void or(BByte dest, BByte source) {

        dest.write(dest.read() | source.read());

    }

    public void xor(BByte dest, BByte source) {

        dest.write(dest.read() ^ source.read());

    }

    public void complement (BByte dest) {

        dest.write( ~ dest.read());

    }

    public void nibbleSwap(BByte dest) {

        //Consider removing these temporary variables
        int lowerHalf = dest.read() & 0xF;
        int upperHalf = (dest.read() >>> 4 ) & 0xF;

        dest.write((lowerHalf << 4) | (upperHalf));

    }

    public void rst (BByte addressByte) {
        pushShort( r.PC );
        r.PC.write( addressByte.read() );

    }

    //Test that if a short is pushed, the same short is returned from a pop
    //Double check these are supposed to be LSB first
    public void pushShort (BShort addressShort) {
        pushByte(addressShort.unit(0));
        pushByte(addressShort.unit(1));
    }

    public BShort popShort () {
        BShort addressShort = new BShort();
        addressShort.setUnit(1, popByte());
        addressShort.setUnit(0, popByte());
        return addressShort;

    }

    public void pushByte (BByte addressByte) {
        m.address( r.SP.read() ).write( addressByte.read() );
        r.SP.dec();
    }

    public BByte popByte () {
        r.SP.inc();
        return m.address( r.SP.read() - 1 );
    }

}
