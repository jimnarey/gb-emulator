import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesnarey on 17/03/2016.
 */
public class DataUnitTest {

    @Test
    public void testSub() throws Exception {
        // System.out.println("Test sub() 8bit, rollover");
        DataUnit d = new DataUnit(1);
        d.write(10);
        d.sub(20);
        assertEquals(246, d.read());

        // System.out.println("Test sub() 16bit, no rollover");
        DataUnit q = new DataUnit(2);
        q.write(100);
        q.sub(20);
        assertEquals(80, q.read());

        // System.out.println("Test sub() 8bit, rollover");
        DataUnit p = new DataUnit(2);
        p.write(10);
        p.sub(20);
        assertEquals(65526, p.read());

        // System.out.println("Test sub(1) 16bit, rollover");
        DataUnit r = new DataUnit(2);
        r.write(0);
        r.sub(1);
        assertEquals(65535, r.read());
    }

    @Test
    public void testAdd() throws Exception {

        // System.out.println("Test add() 8bit, rollover");
        DataUnit d = new DataUnit(1);
        d.write(245);
        d.add(20);
        assertEquals(9, d.read());

        // System.out.println("Test add() 8bit, rollover");
        DataUnit r = new DataUnit(1);
        r.write(50);
        r.add(20);
        assertEquals(70, r.read());

        // System.out.println("Test add() 16bit, rollover");
        DataUnit p = new DataUnit(2);
        p.write(65530);
        p.add(20);
        assertEquals(14, p.read());

        // System.out.println("Test add(1) 16bit, rollover");
        p.write(65535);
        p.add(1);
        assertEquals(0, p.read());
    }

    @Test
    public void testWrite() throws Exception {
        DataUnit d = new DataUnit(1);
        d.write(256);
        assertEquals(0, d.read());

        DataUnit p = new DataUnit(2);
        p.write(65536);
        assertEquals(0, p.read());
    }

    @Test
    public void testCheckBit() throws Exception {
        DataUnit d = new DataUnit(1);
        d.write(9);

        assertEquals(true, d.checkBit(0));
        assertEquals(false, d.checkBit(1));
        assertEquals(false, d.checkBit(2));
        assertEquals(true, d.checkBit(3));

        assertEquals(false, d.checkBit(4));
        assertEquals(false, d.checkBit(5));
        assertEquals(false, d.checkBit(6));
        assertEquals(false, d.checkBit(7));

        // System.out.println(d.byteToString());
        // System.out.println(d.read());

        DataUnit p = new DataUnit(2);
        p.write(9280);


        assertEquals(false, p.checkBit(0));
        assertEquals(false, p.checkBit(1));
        assertEquals(false, p.checkBit(2));
        assertEquals(false, p.checkBit(3));

        assertEquals(false, p.checkBit(4));
        assertEquals(false, p.checkBit(5));
        assertEquals(true, p.checkBit(6));
        assertEquals(false, p.checkBit(7));

        assertEquals(false, p.checkBit(8));
        assertEquals(false, p.checkBit(9));
        assertEquals(true, p.checkBit(10));
        assertEquals(false, p.checkBit(11));

        assertEquals(false, p.checkBit(12));
        assertEquals(true, p.checkBit(13));
        assertEquals(false, p.checkBit(14));
        assertEquals(false, p.checkBit(15));

        // System.out.println(p.read());

    }

    @Test
    public void testSetBit() throws Exception {
        DataUnit d = new DataUnit(1);
        d.write(0);

        d.setBit(0, true);
        d.setBit(3, true);

        assertEquals(9, d.read());
        //System.out.println(d.data);

        d.write(255);

        d.setBit(0, false);
        d.setBit(6, false);

        assertEquals(190, d.read());
        //System.out.println(d.read());

        DataUnit p = new DataUnit(2);
        p.write(0);

        p.setBit(7, true);
        p.setBit(8, true);
        p.setBit(14, true);

        assertEquals(16768, p.read());
        // System.out.println(p.read());

        p.write(65535);

        p.setBit(4, false);
        p.setBit(11, false);
        p.setBit(12, false);

    }

    @Test
    public void testRotateLeftThroughFlag() throws Exception {

    }

    @Test
    public void testReadString() throws Exception {

        DataUnit d = new DataUnit(1);
        d.write(170);
        // System.out.println(d.readString());
        assertEquals("10101010", d.readString());

        DataUnit p = new DataUnit(2);
        p.write(43690);
        // System.out.println(p.readString());
        assertEquals("1010101010101010", p.readString());


    }

    @Test
    public void testInc() throws Exception {

        DataUnit d = new DataUnit(1);
        d.write(1);
        d.inc();
        // System.out.println(d.read());
        assertEquals(2, d.read());

        DataUnit p = new DataUnit(2);
        p.write(65535);
        p.inc();
        // System.out.println(p.read());
        // System.out.println(p.readString());
        assertEquals(0, p.read());

        p.write(400);
        p.inc();
        // System.out.println(p.read());
        // System.out.println(p.readString());
        assertEquals(401, p.read());

    }

    @Test
    public void testDec() throws Exception {

        DataUnit d = new DataUnit(1);
        d.write(1);
        d.dec();
        // System.out.println(d.read());
        assertEquals(0, d.read());

        DataUnit p = new DataUnit(2);
        p.write(3000);
        p.dec();
        // System.out.println(p.read());
        // System.out.println(p.readString());
        assertEquals(2999, p.read());

        p.write(0);
        p.dec();
        // System.out.println(p.read());
        // System.out.println(p.readString());
        assertEquals(65535, p.read());

    }

    @Test
    public void testRead() throws Exception {
        DataUnit d = new DataUnit(1);
        d.write(200);
        assertEquals(200, d.data);
    }

    @Test
    public void testRotateRight() throws Exception {
        DataUnit d = new DataUnit(1);
        d.write(8);
        d.rotateRight();
        assertEquals(4, d.read());

        System.out.println("Test Rotate Right:");
        DataUnit p = new DataUnit(2);
        p.write(24582);
        System.out.println(p.readString());
        System.out.println(p.read());
        p.rotateRight();
        System.out.println(p.readString());
        System.out.println(p.read());
        p.rotateRight();
        System.out.println(p.readString());
        System.out.println(p.read());
        p.rotateRight();
        System.out.println(p.readString());
        System.out.println(p.read());
        p.rotateRight();
        System.out.println(p.readString());
        System.out.println(p.read());
        assertEquals(26112, p.read());

    }

    @Test
    public void testRotateLeft() throws Exception {
        
        DataUnit d = new DataUnit(1);
        d.write(32);
        d.rotateLeft();
        assertEquals(64, d.read());

        System.out.println("Test Rotate Left:");
        DataUnit p = new DataUnit(2);
        p.write(24582);
        System.out.println(p.readString());
        System.out.println(p.read());
        p.rotateLeft();
        System.out.println(p.readString());
        System.out.println(p.read());
        p.rotateLeft();
        System.out.println(p.readString());
        System.out.println(p.read());
        p.rotateLeft();
        System.out.println(p.readString());
        System.out.println(p.read());
        p.rotateLeft();
        System.out.println(p.readString());
        System.out.println(p.read());
        assertEquals(102, p.read());
    }
}