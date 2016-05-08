import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesnarey on 17/03/2016.
 */
public class BByteTest {

    @Test
    public void testSub() throws Exception {
        BByte d = new BByte();
        d.write(10);
        d.sub(20);
        assertEquals(246, d.read());

        BByte r = new BByte();
        r.write(50);
        r.sub(20);
        assertEquals(30, r.read());

    }

    @Test
    public void testAdd() throws Exception {

        // System.out.println("Test add() 8bit, rollover");
        BByte d = new BByte();
        d.write(245);
        d.add(20);
        assertEquals(9, d.read());

        // System.out.println("Test add() 8bit, rollover");
        BByte r = new BByte();
        r.write(50);
        r.add(20);
        assertEquals(70, r.read());

    }

    @Test
    public void testRead() throws Exception {
        BByte d = new BByte();
        d.data = 200;
        assertEquals(d.data, d.read());
    }

    @Test
    public void testWrite() throws Exception {
        BByte d = new BByte();
        d.write(256);
        assertEquals(0, d.data);

        BByte q = new BByte();
        q.write(15);
        assertEquals(15, q.data);
    }

    @Test
    public void testCheckBit() throws Exception {
        BByte d = new BByte();
        d.write(9);

        assertEquals(true, d.checkBit(0));
        assertEquals(false, d.checkBit(1));
        assertEquals(false, d.checkBit(2));
        assertEquals(true, d.checkBit(3));

        assertEquals(false, d.checkBit(4));
        assertEquals(false, d.checkBit(5));
        assertEquals(false, d.checkBit(6));
        assertEquals(false, d.checkBit(7));

    }

    @Test
    public void testSetBit() throws Exception {
        BByte d = new BByte();
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

        BByte d = new BByte();
        d.write(170);
        assertEquals("10101010", d.readString());


    }

    @Test
    public void testInc() throws Exception {

        BByte d = new BByte();
        d.write(1);
        d.inc();
        assertEquals(2, d.read());

    }

    @Test
    public void testDec() throws Exception {

        BByte d = new BByte();
        d.write(1);
        d.dec();
        assertEquals(0, d.read());

    }

    @Test
    public void testRotateRight() throws Exception {
        BByte d = new BByte();
        d.write(8);
        d.rotateRight();
        assertEquals(4, d.read());


    }

    @Test
    public void testRotateLeft() throws Exception {

        BByte d = new BByte();
        d.write(32);
        d.rotateLeft();
        assertEquals(64, d.read());

    }

    @Test
    public void testRotateRightThroughFlag() throws Exception {

        BByte d = new BByte();
        d.write(12);
        d.rotateRightThroughFlag(true);
        assertEquals(134, d.read());

    }

    @Test
    public void testRotateLeftThroughFlag() throws Exception {

        BByte d = new BByte();
        d.write(12);
        d.rotateLeftThroughFlag(true);
        assertEquals(25, d.read());


    }

    @Test
    public void testAND() throws Exception {

        BByte d = new BByte();
        d.write(80);
        d.AND(54);
        assertEquals(16, d.read());


    }

    @Test
    public void testOR() throws Exception {

        BByte d = new BByte();
        d.write(48);
        d.OR(12);
        assertEquals(60, d.read());


    }

    @Test
    public void testXOR() throws Exception {

        BByte d = new BByte();
        d.write(240);
        d.XOR(60);
        assertEquals(204, d.read());

    }

    @Test
    public void testComplement() throws Exception {

        BByte d = new BByte();
        d.write(170);
        d.complement();
        assertEquals(85, d.read());

    }

    @Test
    public void testSwap() throws Exception {

        BByte d = new BByte();
        d.write(240);
        d.swap();
        System.out.println(d.read());
        assertEquals(15, d.read());

        BByte q = new BByte();
        q.write(192);
        q.swap();
        assertEquals(12, q.read());

    }


    @Test
    public void testReadSigned() throws Exception {

        BByte d = new BByte();
        d.write(129);
        assertEquals(-127, d.readSigned());

        BByte p = new BByte();
        p.write(130);
        assertEquals(-126, p.readSigned());

    }
}