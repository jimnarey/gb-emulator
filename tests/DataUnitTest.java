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
        DataUnit d = new DataUnit(8);
        d.write(256);
        assertEquals(0, d.read());

        DataUnit p = new DataUnit(8);
        p.write(65536);
        assertEquals(0, p.read());
    }
}