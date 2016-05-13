import org.junit.Test;

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

        for (BetterByte unit : dA.units) {
            unit.write(200);

        }

        for (BetterByte unit : dA.units) {
            assertEquals(200, unit.read());

        }

    }

    @Test
    public void testSetUnit() throws Exception {
        DataArray dA = new DataArray(8);
        BetterByte dU = new BetterByte();
        dU.write(14);
        dA.setUnit(0, dU);
        assertEquals(14, dA.unit(0).read());
    }


    @Test
    public void testUnit() throws Exception {

        DataArray dA = new DataArray(8);
        dA.populate();
        dA.unit(0).write(255);
        assertEquals(255, dA.unit(0).read());


    }


}
