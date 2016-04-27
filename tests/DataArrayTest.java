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

        DataArray dA = new DataArray(8);
        dA.populate(1);

        for (DataUnit unit: dA.units)
        {
            assertEquals(8, unit.getNumBits());

        }

    }

    @Test
    public void testSetUnit() throws Exception {
        DataArray dA = new DataArray(8);
        DataUnit dU = new DataUnit(1);
        dU.write(14);
        dA.setUnit(0, dU);
        assertEquals(14, dA.unit(0).read());
    }

    @Test
    public void testReadUnit() throws Exception {

        DataArray dA = new DataArray(8);
        DataUnit dU = new DataUnit(1);
        dU.data = 14;
        dA.setUnit(0, dU);
        dA.unit(0).read();

    }

    @Test
    public void testUnit() throws Exception {

        DataArray dA = new DataArray(8);
        dA.populate(1);
        // Check can call method on returned object and that object has right
        // number of bits
        assertEquals(8, dA.unit(0).getNumBits());


    }

    @Test
    public void testRead() throws Exception {

        DataArray dA = new DataArray(4);
        dA.populate(1);
        dA.unit(0).write(60);
        dA.unit(1).write(192);
        dA.unit(2).write(68);
        dA.unit(3).write(6);
        assertEquals(105168956, dA.read());

        DataArray dA1 = new DataArray(2);
        dA1.populate(1);
        dA1.unit(0).write(14);
        dA1.unit(1).write(240);
        assertEquals(61454, dA1.read());

    }

    @Test
    public void testWrite() throws Exception {

        DataArray dA = new DataArray(4);
        dA.populate(1);
        dA.write(105168956);
        assertEquals(60, dA.unit(0).read());
        assertEquals(192, dA.unit(1).read());
        assertEquals(68, dA.unit(2).read());
        assertEquals(6, dA.unit(3).read());

        DataArray dA1 = new DataArray(2);
        dA1.populate(1);
        dA1.write(61454);
        assertEquals(14, dA1.unit(0).read());
        assertEquals(240, dA1.unit(1).read());

        // Check behaviour when too large a value is written
        // Check I did this in DataUnit?
        DataArray dA2 = new DataArray(2);
        dA2.populate(1);
        dA2.write(98303);
        assertEquals(32767, dA2.read());



    }

    @Test
    public void testAdd() throws Exception {

        DataArray dA = new DataArray(2);
        dA.populate(1);
        dA.write(8191);
        dA.add(5);
        assertEquals(8196, dA.read());


    }

    @Test
    public void testSub() throws Exception {

        DataArray dA = new DataArray(2);
        dA.populate(1);
        dA.write(8191);
        dA.sub(5);
        assertEquals(8186, dA.read());

    }

    @Test
    public void testInc() throws Exception {

        DataArray dA = new DataArray(2);
        dA.populate(1);
        dA.write(700);
        dA.inc();
        assertEquals(701, dA.read());

        DataArray dA2 = new DataArray(2);
        dA2.populate(1);
        dA2.write(65535);
        dA2.inc();
        assertEquals(0, dA2.read());

    }

    @Test
    public void testDec() throws Exception {

        DataArray dA = new DataArray(2);
        dA.populate(1);
        dA.write(700);
        dA.dec();
        assertEquals(699, dA.read());

        DataArray dA2 = new DataArray(2);
        dA2.populate(1);
        dA2.write(0);
        dA2.dec();
        assertEquals(65535, dA2.read());

    }
}
