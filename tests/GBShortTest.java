
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by jamesnarey on 27/04/2016.
 */
public class GBShortTest {


    @Test
    public void testRead() throws Exception {

        GBShort bP1 = new GBShort();
        bP1.populate();
        bP1.bytes[0].data = 14;
        bP1.bytes[1].data = 240;
        assertEquals(61454, bP1.read());

    }

    @Test
    public void testWrite() throws Exception {


        GBShort bP1 = new GBShort();
        bP1.populate();
        bP1.write(61454);
        assertEquals(14, bP1.unit(0).read());
        assertEquals(240, bP1.unit(1).read());

        // Check behaviour when too large a value is written
        GBShort bP2 = new GBShort();
        bP2.populate();
        bP2.write(98303);
        assertEquals(32767, bP2.read());



    }

    @Test
    public void testAdd() throws Exception {

        GBShort bP = new GBShort();
        bP.populate();
        bP.write(8191);
        bP.add(5);
        assertEquals(8196, bP.read());

        GBShort bP2 = new GBShort();
        bP2.populate();
        bP2.write(200);
        bP2.add(100);
        assertEquals(300, bP2.read());

    }

    @Test
    public void testSub() throws Exception {

        GBShort bP = new GBShort();
        bP.populate();
        bP.write(8191);
        bP.sub(5);
        assertEquals(8186, bP.read());

    }

    @Test
    public void testInc() throws Exception {

        GBShort bP = new GBShort();
        bP.populate();
        bP.write(700);
        bP.inc();
        assertEquals(701, bP.read());

        GBShort bP2 = new GBShort();
        bP2.populate();
        bP2.write(65535);
        bP2.inc();
        assertEquals(0, bP2.read());

    }

    @Test
    public void testDec() throws Exception {

        GBShort bP = new GBShort();
        bP.populate();
        bP.write(700);
        bP.dec();
        assertEquals(699, bP.read());

        GBShort bP2 = new GBShort();
        bP2.populate();
        bP2.write(0);
        bP2.dec();
        assertEquals(65535, bP2.read());

    }
}
 