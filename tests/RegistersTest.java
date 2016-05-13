import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesnarey on 07/05/2016.
 */
public class RegistersTest {

    // Move all of these to FlagRegisters test class
    @Test
    public void testGetZ() throws Exception {
        Registers reg = new Registers();
        assertEquals(false, reg.F.getZ());
        reg.F.write(128);
        assertEquals(true, reg.F.getZ());
    }

    @Test
    public void testSetZ() throws Exception {
        Registers reg = new Registers();
        reg.F.setZ(true);
        assertEquals(128, reg.F.read());

    }

    @Test
    public void testGetN() throws Exception {
        Registers reg = new Registers();
        assertEquals(false, reg.F.getN());
        reg.F.write(64);
        assertEquals(true, reg.F.getN());
    }

    @Test
    public void testSetN() throws Exception {
        Registers reg = new Registers();
        reg.F.setN(true);
        assertEquals(64, reg.F.read());
    }

    @Test
    public void testGetH() throws Exception {
        Registers reg = new Registers();
        assertEquals(false, reg.F.getH());
        reg.F.write(32);
        assertEquals(true, reg.F.getH());
    }

    @Test
    public void testSetH() throws Exception {
        Registers reg = new Registers();
        reg.F.setH(true);
        assertEquals(32, reg.F.read());
    }

    @Test
    public void testGetC() throws Exception {
        Registers reg = new Registers();
        assertEquals(false, reg.F.getC());
        reg.F.write(16);
        assertEquals(true, reg.F.getC());
    }

    @Test
    public void testSetC() throws Exception {
        Registers reg = new Registers();
        reg.F.setC(true);
        assertEquals(16, reg.F.read());
    }
}
