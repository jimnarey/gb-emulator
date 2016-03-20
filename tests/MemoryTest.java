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
    public void testRWByte() throws Exception {
        Memory m = new Memory();
        m.writeByte(100, 50);
        assertEquals(100, m.readByte(50));

    }

    @Test
    public void testRWWord() throws Exception {
        Memory m = new Memory();
        m.writeWord(10000, 50);
        System.out.println("Read word: " + m.readWord(50));
        assertEquals(10000, m.readWord(50));

    }
}