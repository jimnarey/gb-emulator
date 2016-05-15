import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesnarey on 17/03/2016.
 */
public class BByteTest {

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

        BByte p = new BByte();
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
    public void testReadSigned() throws Exception {

        BByte d = new BByte();
        d.write(129);
        assertEquals(-127, d.readSigned());

        BByte p = new BByte();
        p.write(130);
        assertEquals(-126, p.readSigned());

    }

}