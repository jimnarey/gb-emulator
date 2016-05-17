import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesnarey on 17/03/2016.
 */
public class GBByteTest {

    @Test
    public void testSub() throws Exception {
        GBByte d = new GBByte();
        d.write(10);
        d.sub(20);
        assertEquals(246, d.read());

        GBByte r = new GBByte();
        r.write(50);
        r.sub(20);
        assertEquals(30, r.read());

    }

    @Test
    public void testAdd() throws Exception {

        // System.out.println("Test add() 8bit, rollover");
        GBByte d = new GBByte();
        d.write(245);
        d.add(20);
        assertEquals(9, d.read());

        // System.out.println("Test add() 8bit, rollover");
        GBByte r = new GBByte();
        r.write(50);
        r.add(20);
        assertEquals(70, r.read());

    }

    @Test
    public void testRead() throws Exception {
        GBByte d = new GBByte();
        d.data = 200;
        assertEquals(d.data, d.read());
    }

    @Test
    public void testWrite() throws Exception {
        GBByte d = new GBByte();
        d.write(256);
        assertEquals(0, d.data);

        GBByte q = new GBByte();
        q.write(15);
        assertEquals(15, q.data);
    }

    @Test
    public void testCheckBit() throws Exception {
        GBByte d = new GBByte();
        d.write(9);

        assertEquals(true, d.checkBit(0));
        assertEquals(false, d.checkBit(1));
        assertEquals(false, d.checkBit(2));
        assertEquals(true, d.checkBit(3));

        assertEquals(false, d.checkBit(4));
        assertEquals(false, d.checkBit(5));
        assertEquals(false, d.checkBit(6));
        assertEquals(false, d.checkBit(7));

        GBByte p = new GBByte();
        p.write(170);

        assertEquals(false, p.checkBit(0));
        assertEquals(true, p.checkBit(1));
        assertEquals(false, p.checkBit(2));
        assertEquals(true, p.checkBit(3));

        assertEquals(false, p.checkBit(4));
        assertEquals(true, p.checkBit(5));
        assertEquals(false, p.checkBit(6));
        assertEquals(true, p.checkBit(7));

    }

    @Test
    public void testSetBit() throws Exception {
        GBByte d = new GBByte();
        d.write(0);
        d.setBit(0, true);
        d.setBit(3, true);
        assertEquals(9, d.read());


        d.write(255);
        d.setBit(0, false);
        d.setBit(6, false);
        assertEquals(190, d.read());

    }

    @Test
    public void testReadString() throws Exception {

        GBByte d = new GBByte();
        d.write(170);
        assertEquals("10101010", d.readString());


    }

    @Test
    public void testInc() throws Exception {

        GBByte d = new GBByte();
        d.write(1);
        d.inc();
        assertEquals(2, d.read());

    }

    @Test
    public void testDec() throws Exception {

        GBByte d = new GBByte();
        d.write(1);
        d.dec();
        assertEquals(0, d.read());

    }

    @Test
    public void testRotateRight() throws Exception {
        GBByte d = new GBByte();
        d.write(8);
        d.rotateRight();
        assertEquals(4, d.read());


    }

    @Test
    public void testRotateLeft() throws Exception {

        GBByte d = new GBByte();
        d.write(32);
        d.rotateLeft();
        assertEquals(64, d.read());

    }

    @Test
    public void testRotateRightThroughFlag() throws Exception {

        GBByte d = new GBByte();
        d.write(12);
        d.rotateRightThroughFlag(true);
        assertEquals(134, d.read());

    }

    @Test
    public void testRotateLeftThroughFlag() throws Exception {

        GBByte d = new GBByte();
        d.write(12);
        d.rotateLeftThroughFlag(true);
        assertEquals(25, d.read());


    }

    @Test
    public void testAND() throws Exception {

        GBByte d = new GBByte();
        d.write(80);
        d.and(54);
        assertEquals(16, d.read());


    }

    @Test
    public void testOR() throws Exception {

        GBByte d = new GBByte();
        d.write(48);
        d.or(12);
        assertEquals(60, d.read());


    }

    @Test
    public void testXOR() throws Exception {

        GBByte d = new GBByte();
        d.write(240);
        d.xor(60);
        assertEquals(204, d.read());

    }

    @Test
    public void testComplement() throws Exception {

        GBByte d = new GBByte();
        d.write(170);
        d.complement();
        assertEquals(85, d.read());

    }

    @Test
    public void testSwap() throws Exception {

        GBByte d = new GBByte();
        d.write(240);
        d.swap();
        System.out.println(d.read());
        assertEquals(15, d.read());

        GBByte q = new GBByte();
        q.write(192);
        q.swap();
        assertEquals(12, q.read());

    }


    @Test
    public void testReadSigned() throws Exception {

        GBByte d = new GBByte();
        d.write(129);
        assertEquals(-127, d.readSigned());

        GBByte p = new GBByte();
        p.write(130);
        assertEquals(-126, p.readSigned());

    }
}