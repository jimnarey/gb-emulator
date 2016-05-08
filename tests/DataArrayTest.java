import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;
/**
 * Created by jamesnarey on 27/04/2016.
 */
public class DataArrayTest {

    @Test
    public void testGetNumUnits() throws Exception {
        DataArray dA = new DataArray(8);
        dA.populate();
        assertEquals(8, dA.getNumUnits());
    }

    @Test
    public void testPopulate() throws Exception {

        DataArray dA = new DataArray(8);
        dA.populate();

        for (BByte unit: dA.units)
        {
            assertEquals(8, unit.getNumBits());

        }

    }

    @Test
    public void testSetUnit() throws Exception {
        DataArray dA = new DataArray(8);
        BByte dU = new BByte();
        dU.write(14);
        dA.setUnit(0, dU);
        assertEquals(14, dA.unit(0).read());
    }


    @Test
    public void testUnit() throws Exception {

        DataArray dA = new DataArray(8);
        dA.populate();
        // Check can call method on returned object and that object has right
        // number of bits
        assertEquals(8, dA.unit(0).getNumBits());


    }




}
