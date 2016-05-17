import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jamesnarey on 27/04/2016.
 */
public class GBByteArrayTest {

    @Test
    public void testGetNumUnits() throws Exception {
        GBByteArray dA = new GBByteArray(8);
        dA.populate();
        assertEquals(8, dA.getNumUnits());
    }

    @Test
    public void testPopulate() throws Exception {

        GBByteArray dA = new GBByteArray(8);
        dA.populate();

        for (GBByte unit : dA.bytes) {
            unit.write(200);

        }

        for (GBByte unit : dA.bytes) {
            assertEquals(200, unit.read());

        }

    }

    @Test
    public void testSetUnit() throws Exception {
        GBByteArray dA = new GBByteArray(8);
        GBByte dU = new GBByte();
        dU.write(14);
        dA.setUnit(0, dU);
        assertEquals(14, dA.unit(0).read());
    }


    @Test
    public void testUnit() throws Exception {

        GBByteArray dA = new GBByteArray(8);
        dA.populate();
        dA.unit(0).write(255);
        assertEquals(255, dA.unit(0).read());


    }


}
