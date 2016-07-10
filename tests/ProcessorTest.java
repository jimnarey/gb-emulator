import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jamesnarey on 15/05/2016.
 */
public class ProcessorTest {

    Memory m;
    Processor p;

    @Before
    public void setUp () {
        m = new Memory();
        p = new Processor(m);
    }

//    @Test
//    public void testSub() throws Exception {
//        BByte d = new BByte();
//        d.write(10);
//        BByte c = new BByte();
//        c.write(20);
//        p.sub(d, c);
//        assertEquals(246, d.read());
//
//        BByte r = new BByte();
//        r.write(50);
//        BByte q = new BByte();
//        q.write(20);
//        p.sub(r, q);
//        assertEquals(30, r.read());
//
//    }


    @Test
    public void testAdd() throws Exception {

        // System.out.println("Test add() 8bit, rollover");
        BByte d = new BByte();
        d.write(245);
        BByte c = new BByte();
        c.write(20);
        p.add(d, c);
        assertEquals(9, d.read());

        // System.out.println("Test add() 8bit, rollover");
        BByte r = new BByte();
        r.write(50);
        BByte q = new BByte();
        q.write(20);
        p.add(r, q);
        assertEquals(70, r.read());

    }

    @Test
    public void testInc() throws Exception {

        BByte d = new BByte();
        d.write(1);
        p.inc(d);
        assertEquals(2, d.read());

    }

    @Test
    public void testDec() throws Exception {

        BByte d = new BByte();
        d.write(1);
        p.dec(d);
        assertEquals(0, d.read());

    }

    @Test
    public void testRotateRight() throws Exception {
        BByte d = new BByte();
        d.write(8);
        p.rrc(d);
        assertEquals(4, d.read());


    }

    @Test
    public void testRotateLeft() throws Exception {

        BByte d = new BByte();
        d.write(32);
        p.rlc(d);
        assertEquals(64, d.read());

    }

    @Test
    public void testRotateRightThroughFlag() throws Exception {

        BByte d = new BByte();
        d.write(12);
        p.r.F.setC(true);
        p.rr(d);
        assertEquals(134, d.read());

        BByte q = new BByte();
        q.write(12);
        p.r.F.setC(false);
        p.rr(q);
        assertEquals(6, q.read());

    }

    @Test
    public void testRotateLeftThroughFlag() throws Exception {

        BByte d = new BByte();
        d.write(12);
        p.r.F.setC(true);
        p.rl(d);
        assertEquals(25, d.read());

        BByte q = new BByte();
        q.write(12);
        p.r.F.setC(false);
        p.rl(q);
        assertEquals(24, q.read());


    }

//    @Test
//    public void testAND() throws Exception {
//
//        BByte d = new BByte();
//        d.write(80);
//        BByte c = new BByte();
//        c.write(54);
//        p.and(d, c);
//        assertEquals(16, d.read());
//
//
//    }
//
//    @Test
//    public void testOR() throws Exception {
//
//        BByte d = new BByte();
//        d.write(48);
//        BByte c = new BByte();
//        c.write(12);
//        p.or(d, c);
//        assertEquals(60, d.read());
//
//
//    }
//
//    @Test
//    public void testXOR() throws Exception {
//
//        BByte d = new BByte();
//        d.write(240);
//        BByte c = new BByte();
//        c.write(60);
//        p.xor(d, c);
//        assertEquals(204, d.read());
//
//    }

    @Test
    public void testComplement() throws Exception {

        BByte d = new BByte();
        d.write(170);
        p.cpl(d);
        assertEquals(85, d.read());

    }

    @Test
    public void testSwap() throws Exception {

        BByte d = new BByte();
        d.write(240);
        p.swap(d);
        System.out.println(d.read());
        assertEquals(15, d.read());

        BByte q = new BByte();
        q.write(192);
        p.swap(q);
        assertEquals(12, q.read());

    }



}
