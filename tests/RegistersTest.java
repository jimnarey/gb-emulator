import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesnarey on 07/05/2016.
 */
public class RegistersTest {


    @Test
    public void testGetZF() throws Exception {
        Registers reg = new Registers();
        assertEquals(false, reg.getZF());
        reg.F.write(128);
        assertEquals(true, reg.getZF());
    }

    @Test
    public void testSetZF() throws Exception {
        Registers reg = new Registers();
        reg.setZF(true);
        assertEquals(128, reg.F.read());

    }

    @Test
    public void testGetNF() throws Exception {
        Registers reg = new Registers();
        assertEquals(false, reg.getNF());
        reg.F.write(64);
        assertEquals(true, reg.getNF());
    }

    @Test
    public void testSetNF() throws Exception {
        Registers reg = new Registers();
        reg.setNF(true);
        assertEquals(64, reg.F.read());
    }

    @Test
    public void testGetHF() throws Exception {
        Registers reg = new Registers();
        assertEquals(false, reg.getHF());
        reg.F.write(32);
        assertEquals(true, reg.getHF());
    }

    @Test
    public void testSetHF() throws Exception {
        Registers reg = new Registers();
        reg.setHF(true);
        assertEquals(32, reg.F.read());
    }

    @Test
    public void testGetCF() throws Exception {
        Registers reg = new Registers();
        assertEquals(false, reg.getCF());
        reg.F.write(16);
        assertEquals(true, reg.getCF());
    }

    @Test
    public void testSetCF() throws Exception {
        Registers reg = new Registers();
        reg.setCF(true);
        assertEquals(16, reg.F.read());
    }
}
