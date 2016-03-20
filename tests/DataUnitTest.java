import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesnarey on 17/03/2016.
 */
public class DataUnitTest {

    @Test
    public void testSub() throws Exception {
        DataUnit d = new DataUnit(1);
        d.write(10);
        d.sub(20);
        assertEquals(245, d.read());

        DataUnit p = new DataUnit(2);
        p.write(10);
        p.sub(20);
        assertEquals(65525, p.read());
    }

    @Test
    public void testAdd() throws Exception {
        DataUnit d = new DataUnit(1);
        d.write(245);
        d.add(20);
        assertEquals(10, d.read());

        DataUnit p = new DataUnit(2);
        p.write(65530);
        p.add(20);
        assertEquals(10, d.read());
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

        System.out.println(p.read());

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
        System.out.println(p.read());

        p.write(65535);

        p.setBit(4, false);
        p.setBit(11, false);
        p.setBit(12, false);

    }

    @Test
    public void testRotateLeftThroughFlag() throws Exception {

    }
}