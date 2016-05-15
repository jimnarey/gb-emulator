import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesnarey on 10/05/2016.
 */
public class InstructionsTest {

    Memory m;
    Processor p;


//    @Before
//    public void setUp() {
//        this.m = new Memory();
//        this.p = new Processor(this.m);
//
//    }
//
//    @Test
//    public void testLD() throws Exception {
//
//        BShort bP0 = new BShort();
//        bP0.populate();
//        bP0.write(257);
//        Instructions.LD(new BShort(m.address(0), m.address(1)), bP0);
//        assertEquals(1, m.address(0).read());
//        assertEquals(1, m.address(1).read());
//
//        // 335 & 336 chosen to test everything works when the BShort spans two
//        // memory banks.
//        BShort bP1 = new BShort();
//        bP1.populate();
//        bP1.write(7001);
//        Instructions.LD(new BShort(m.address(335), m.address(336)), bP1);
//        assertEquals(89, m.address(335).read());
//        assertEquals(27, m.address(336).read());
//
//        //Need test to check when using a newly instantiated BShort/Byte
//        //as source
//
//
//
//    }
}
