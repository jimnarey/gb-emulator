import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by jamesnarey on 27/04/2016.
 */
public class DataArrayTest {

    @Test
    public void testGetNumUnits() throws Exception {
        DataArray dA = new DataArray(8);
        dA.populate(1);
        assertEquals(8, dA.getNumUnits());
    }


    @Test
    public void testPopulate() throws Exception {

    }

    @Test
    public void testSetUnit() throws Exception {
        DataArray dA = new DataArray(8);
        DataUnit dU = new DataUnit(1);
        dU.write(14);
        //d.populate(1);
        dA.setUnit(0, dU);
        assertEquals(14, dA.unit(0).read());
    }

    @Test
    public void testReadUnit() throws Exception {

    }

    @Test
    public void testUnit() throws Exception {

        DataArray dA = new DataArray(8);
        dA.populate(1);
        // Consider swapping for a type check
        // Try test before populate to see what happens (expect exception)
        assertEquals(8, dA.unit(0).getNumBits());

    }

    @Test
    public void testRead() throws Exception {

    }

    @Test
    public void testWrite() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testSub() throws Exception {

    }

    @Test
    public void testInc() throws Exception {

    }

    @Test
    public void testDec() throws Exception {

    }
}
