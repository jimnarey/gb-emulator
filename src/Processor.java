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

    // Need to add tests for all the methods' flag setting/resetting
    public boolean calcCarryFlag(int maxValue, int writeValue) {

        if (writeValue > maxValue || writeValue < 0) {
            return true;
        }
        else {
            return false;
        }

    }

    // This isn't write - it assumes an add!!!!!!
    public boolean calcHalfFlag (int currentValue, int writeValue) {
        //((a&0xf) + (value&0xf))&0x10
        if ( (((currentValue & 0xF) + (writeValue & 0xF)) & 0x10) == 0x10) {
            return true;
        }
        else {
            return false;
        }
    }

    public void ld(ByteInterface dest, ByteInterface source) {

        dest.write( source.read() );

    }

    public void add(ByteInterface dest, ByteInterface source) {

        int writeValue = dest.read() + source.read();
        r.F.setC(calcCarryFlag(dest.getMaxValue(), writeValue));
        //r.F.setH(calcHalfFlag(dest.read(), writeValue));
        dest.write(writeValue);


    }

    public void adc(BByte source) {

        int writeValue = r.A.read() + (source.read() + (r.F.getC() ? 1 : 0));
        r.F.setC(calcCarryFlag(255, writeValue));

        r.A.write( writeValue );

    }

    public void sub(ByteInterface source) {

        int writeValue = r.A.read() - source.read();
        r.F.setC(calcCarryFlag(255, writeValue ));

        r.A.write( writeValue );

    }

    public void sbc(BByte source) {

        int writeValue = r.A.read() - (source.read() + (r.F.getC() ? 1 : 0));
        r.F.setC(calcCarryFlag(255, writeValue ));

        r.A.write( writeValue );

    }

    public void inc(ByteInterface dest) {

        int writeValue = dest.read() + 1;
        r.F.setC(calcCarryFlag(dest.getMaxValue(), writeValue ));

        dest.write( writeValue);

    }

    public void dec(ByteInterface dest) {

        int writeValue = dest.read() - 1;
        r.F.setC(calcCarryFlag(dest.getMaxValue(), writeValue ));

        dest.write( dest.read() - 1);

    }

    public void rrc(BByte dest) {

        boolean lsb = dest.checkBit(0);
        r.F.setC(lsb);

        dest.write(dest.read() >>> 1);

        dest.setBit(7, lsb);


    }

    public void rr(BByte dest) {

        boolean lsb = dest.checkBit(0);
        r.F.setC(lsb);

        dest.write(dest.data >>> 1);

        dest.setBit(7, r.F.getC());



    }

    public void rlc(BByte dest) {

        boolean msb = dest.checkBit(7);
        r.F.setC(msb);

        dest.write(dest.data << 1);

        dest.setBit(0, msb);



    }

    public void rl(BByte dest) {

        boolean msb = dest.checkBit(7);
        r.F.setC(msb);

        dest.write(dest.read() << 1);

        dest.setBit(0, r.F.getC());


    }

    public void sra(BByte dest) {

        boolean msb = dest.checkBit(7);
        boolean lsb = dest.checkBit(0);
        r.F.setC(lsb);

        dest.write(dest.read() >>> 1);

        dest.setBit(7, msb);

        // To carry flag


    }

    public void srl(BByte dest) {

        boolean lsb = dest.checkBit(0);
        r.F.setC(lsb);

        dest.write(dest.read() >>> 1);

        dest.setBit(7, false);

        // To carry flag


    }

    public void sla(BByte dest) {

        boolean msb = dest.checkBit(7);
        r.F.setC(msb);

        dest.write(dest.read() << 1);

        // Is this needed? Presumably will always pull zero from the right?
        dest.setBit(0, false);

        // To carry flag


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
        push( r.PC );
        r.PC.write( addressByte.read() );

    }

    //Test that if a short is pushed, the same short is returned from a pop
    //Double check these are supposed to be LSB first
    public void push(BShort addressShort) {
        pushByte(addressShort.unit(0));
        pushByte(addressShort.unit(1));
    }

    public BShort pop() {
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
