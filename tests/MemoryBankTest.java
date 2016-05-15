import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesnarey on 18/03/2016.
 */
public class MemoryBankTest {

    @Test
    public void testGetSize() throws Exception {
        MemoryBank m = new MemoryBank("test", "test bank", 0, 1024);
        m.bytes[2].write(100);
        assertEquals(100, m.bytes[2].read());
    }
}