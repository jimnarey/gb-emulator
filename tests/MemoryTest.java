import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesnarey on 20/03/2016.
 */
public class MemoryTest {

    @Test
    public void testInit() throws Exception {
        Memory m = new Memory();
        assertEquals(65536, m.getMemorySize());

    }


    @Test
    public void testAddress() throws Exception {

        Memory m = new Memory();
        m.address(50).write(100);

        assertEquals(100, m.address(50).read());
        assertEquals(100, m.memoryBanks[0].bytes[50].data);
    }

}