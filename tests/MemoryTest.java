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
    public void testWriteByte() throws Exception {
        Memory m = new Memory();
        m.writeByte(3, 50);


    }

    @Test
    public void testReadByte() throws Exception {
        Memory m = new Memory();
        m.readByte(50);
    }
}