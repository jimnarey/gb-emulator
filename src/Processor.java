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

    public void ld(ByteInterface dest, ByteInterface source) {

        dest.write( source.read() );

    }

    public void add(ByteInterface source) {

        r.A.write( r.A.read() + source.read() );

    }

    public void adc(BByte source) {
        r.A.write( r.A.read() + (source.read() + (r.F.getC() ? 1 : 0)) );
    }

    public void sub(ByteInterface source) {

        r.A.write( r.A.read() - source.read() );

    }

    public void sbc(BByte source) {

        r.A.write( r.A.read() - (source.read() + (r.F.getC() ? 1 : 0)) );

    }

    public void inc(ByteInterface dest) {
        dest.write( dest.read() + 1);
    }

    public void dec(ByteInterface dest) {
        dest.write( dest.read() - 1);
    }

    // Add tests for the return values, where they exist
    public boolean rrc(BByte dest) {

        boolean lsb = dest.checkBit(0);

        dest.write(dest.read() >>> 1);

        dest.setBit(7, lsb);

        return lsb;
    }

    public boolean rr(BByte dest) {

        boolean lsb = dest.checkBit(0);

        dest.write(dest.data >>> 1);

        dest.setBit(7, r.F.getC());

        return lsb;

    }

    public boolean rlc(BByte dest) {

        boolean msb = dest.checkBit(7);

        dest.write(dest.data << 1);

        dest.setBit(0, msb);

        return msb;

    }

    public boolean rl(BByte dest) {

        boolean msb = dest.checkBit(7);

        dest.write(dest.read() << 1);

        dest.setBit(0, r.F.getC());

        return msb;
    }

    public boolean sra(BByte dest) {

        boolean msb = dest.checkBit(7);
        boolean lsb = dest.checkBit(0);

        dest.write(dest.read() >>> 1);

        dest.setBit(7, msb);

        // To carry flag
        return lsb;

    }

    public boolean srl(BByte dest) {

        boolean lsb = dest.checkBit(0);

        dest.write(dest.read() >>> 1);

        dest.setBit(7, false);

        // To carry flag
        return lsb;

    }

    public boolean sla(BByte dest) {

        boolean msb = dest.checkBit(7);

        dest.write(dest.read() << 1);

        // Is this needed? Presumably will always pull zero from the right?
        dest.setBit(0, false);

        // To carry flag
        return msb;

    }

    public boolean bit(BByte dest, int position) {
        return dest.checkBit(position);
    }

    public void set(BByte dest, int position) {
        dest.setBit(position, true);
    }

    public void res(BByte dest, int position) {
        dest.setBit(position, false);
    }

    public void and(BByte source) {

        r.A.write( r.A.read() & source.read());

    }

    public void or(BByte source) {

        r.A.write( r.A.read() | source.read());

    }

    public void xor(BByte source) {

        r.A.write( r.A.read() ^ source.read());

    }

    public void cpl(BByte dest) {

        dest.write( ~ dest.read());

    }

    public void swap(BByte dest) {

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
