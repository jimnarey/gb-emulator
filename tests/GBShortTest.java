
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by jamesnarey on 27/04/2016.
 */
public class GBShortTest {

    GBShort s;

    @Before
    public void setUp() {
        s = new GBShort();
        s.populate();
    }

    @Test
    public void testRead() throws Exception {

        s.bytes[0].data = 14;
        s.bytes[1].data = 240;
        assertEquals(61454, s.read());

    }

    @Test
    public void testWrite() throws Exception {

        s.write(61454);
        assertEquals(14, s.unit(0).read());
        assertEquals(240, s.unit(1).read());

        // Check behaviour when too large a value is written
        s.write(98303);
        assertEquals(32767, s.read());

    }

    @Test
    public void testAdd() throws Exception {

        s.write(8191);
        s.add(5);
        assertEquals(8196, s.read());

        s.write(200);
        s.add(100);
        assertEquals(300, s.read());

    }

    @Test
    public void testSub() throws Exception {

        s.write(8191);
        s.sub(5);
        assertEquals(8186, s.read());

    }

    @Test
    public void testInc() throws Exception {

        s.write(700);
        s.inc();
        assertEquals(701, s.read());

        s.write(65535);
        s.inc();
        assertEquals(0, s.read());

    }

    @Test
    public void testDec() throws Exception {

        s.write(700);
        s.dec();
        assertEquals(699, s.read());

        s.write(0);
        s.dec();
        assertEquals(65535, s.read());

    }

    @Test
    public void testIsZero() throws Exception {
        s.write(0);
        assertEquals(true, s.isZero());

        s.write(1);
        assertEquals(false, s.isZero());
    }

    @Test
    public void testGetCarryFlag() throws Exception {
        s.bytes[1].carryFlag = true;
        assertEquals(true, s.getCarryFlag());

        s.bytes[1].carryFlag = false;
        assertEquals(false, s.getCarryFlag());
    }

    @Test
    public void testGetHalfFlag() throws Exception {
        s.bytes[1].halfFlag = true;
        assertEquals(true, s.getHalfFlag());

        s.bytes[1].halfFlag = false;
        assertEquals(false, s.getHalfFlag());
    }

    @Test
    public void testMergeBytes() throws Exception {
        // Tested by read()
    }

    @Test
    public void testSplitToBytes() throws Exception {
        // Tested by write()
    }
}
 