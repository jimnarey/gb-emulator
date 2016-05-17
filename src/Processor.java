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

    public void rst (GBByte addressByte) {
        pushShort( r.PC );
        r.PC.write( addressByte.read() );

    }

    //Test that if a short is pushed, the same short is returned from a pop
    //Double check these are supposed to be LSB first
    public void pushShort (GBShort addressShort) {
        pushByte(addressShort.unit(0));
        pushByte(addressShort.unit(1));
    }

    public GBShort popShort () {
        GBShort addressShort = new GBShort();
        addressShort.setUnit(1, popByte());
        addressShort.setUnit(0, popByte());
        return addressShort;

    }

    public void pushByte (GBByte addressByte) {
        m.address( r.SP.read() ).write( addressByte.read() );
        r.SP.dec();
    }

    public GBByte popByte () {
        r.SP.inc();
        return m.address( r.SP.read() - 1 );
    }

}
