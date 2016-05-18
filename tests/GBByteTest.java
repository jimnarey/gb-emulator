import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesnarey on 17/03/2016.
 */
public class GBByteTest {

    GBByte d, r, q, p;

    @Before
    public void setUp() {

        d = new GBByte();
        r = new GBByte();
        q = new GBByte();
        p = new GBByte();
    }

    @Test
    public void testSub() throws Exception {

        d.write(10);
        d.sub(20);
        assertEquals(246, d.read());

        r.write(50);
        r.sub(20);
        assertEquals(30, r.read());

        // Test half-carry behaviour
        d.write(144);
        d.halfFlag = false;
        d.sub(160);
        assertEquals(240, d.read());
        assertEquals(true, d.getHalfFlag());

        d.write(128);
        d.halfFlag = true;
        d.sub(20);
        assertEquals(108, d.read());
        assertEquals(false, d.getHalfFlag());

        // Test carry flag behaviour
        d.write(144);
        d.carryFlag = false;
        d.sub(160);
        assertEquals(240, d.read());
        assertEquals(true, d.getCarryFlag());

        d.write(128);
        d.carryFlag = true;
        d.sub(20);
        assertEquals(108, d.read());
        assertEquals(false, d.getCarryFlag());

        // Consider tests for both half & full carry

    }

    @Test
    public void testAdd() throws Exception {

        // System.out.println("Test add() 8bit, rollover");
        d.write(245);
        d.add(20);
        assertEquals(9, d.read());

        // System.out.println("Test add() 8bit, rollover");
        r.write(50);
        r.add(20);
        assertEquals(70, r.read());

        //To test carry flag behaviour

    }

    @Test
    public void testRead() throws Exception {

        d.data = 200;
        assertEquals(d.data, d.read());
    }

    @Test
    public void testWrite() throws Exception {

        d.write(256);
        assertEquals(0, d.data);


        q.write(15);
        assertEquals(15, q.data);
    }

    @Test
    public void testCheckBit() throws Exception {

        d.write(9);

        assertEquals(true, d.checkBit(0));
        assertEquals(false, d.checkBit(1));
        assertEquals(false, d.checkBit(2));
        assertEquals(true, d.checkBit(3));

        assertEquals(false, d.checkBit(4));
        assertEquals(false, d.checkBit(5));
        assertEquals(false, d.checkBit(6));
        assertEquals(false, d.checkBit(7));


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


        d.write(170);
        assertEquals("10101010", d.readString());


    }

    @Test
    public void testInc() throws Exception {

        d.write(1);
        d.inc();
        assertEquals(2, d.read());

    }

    @Test
    public void testDec() throws Exception {

        d.write(1);
        d.dec();
        assertEquals(0, d.read());

    }

    @Test
    public void testRotateRight() throws Exception {


        d.write(8);
        d.rotateRight();
        assertEquals(4, d.read());


    }

    @Test
    public void testRotateLeft() throws Exception {

        d.write(32);
        d.rotateLeft();
        assertEquals(64, d.read());

    }

    @Test
    public void testRotateRightThroughFlag() throws Exception {

        d.write(12);
        d.rotateRightThroughFlag(true);
        assertEquals(134, d.read());

    }

    @Test
    public void testRotateLeftThroughFlag() throws Exception {

        d.write(12);
        d.rotateLeftThroughFlag(true);
        assertEquals(25, d.read());


    }

    @Test
    public void testAnd() throws Exception {

        d.write(80);
        d.and(54);
        assertEquals(16, d.read());


    }

    @Test
    public void testOr() throws Exception {

        d.write(48);
        d.or(12);
        assertEquals(60, d.read());

    }

    @Test
    public void testXor() throws Exception {

        d.write(240);
        d.xor(60);
        assertEquals(204, d.read());

    }

    @Test
    public void testComplement() throws Exception {

        d.write(170);
        d.complement();
        assertEquals(85, d.read());

    }

    @Test
    public void testSwap() throws Exception {

        d.write(240);
        d.swap();
        assertEquals(15, d.read());

        q.write(192);
        q.swap();
        assertEquals(12, q.read());

    }


    @Test
    public void testReadSigned() throws Exception {

        d.write(129);
        assertEquals(-127, d.readSigned());

        p.write(130);
        assertEquals(-126, p.readSigned());

    }

    @Test
    public void testIsZero() throws Exception {
        d.write(0);
        assertEquals(true, d.isZero());

        d.write(1);
        assertEquals(false, d.isZero());
    }

    @Test
    public void testGetCarryFlag() throws Exception {
        d.carryFlag = false;
        assertEquals(false, d.getCarryFlag());

        d.carryFlag = true;
        assertEquals(true, d.getCarryFlag());

    }

    @Test
    public void testGetHalfFlag() throws Exception {
        d.halfFlag = false;
        assertEquals(false, d.getHalfFlag());

        d.halfFlag = true;
        assertEquals(true, d.getHalfFlag());
    }


}