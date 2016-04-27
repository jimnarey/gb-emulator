/**
 * Created by jamesnarey on 13/03/2016.
 */
public class Registers {

    //8bit registers
    //A is accumulator, F for flags, others general purpose
    //How to neatly join when needed?
    //private int A, F, B, C, D, E, H, L;

    public DataUnit A, F, B, C, D, E, H, L = new DataUnit(1);

    public DataUnit SP, PC = new DataUnit(2);

    //16bit registers, stack pointer and program counter
    //How to split up if needed?
    //private int SP, PC;
    public DataArray AF, BC, DE, HL = new DataArray(2);

    public Registers() {

        AF.setUnit(0, F);
        AF.setUnit(1, A);

        BC.setUnit(0, C);
        BC.setUnit(1, D);

        DE.setUnit(0, E);
        DE.setUnit(1, D);

        HL.setUnit(0, L);
        HL.setUnit(1, H);


    }

    public boolean getZF () {

        return F.checkBit(7);

    }

    public void setZF (boolean value) {

        F.setBit(7, value);

    }

    public boolean getNF () {

        return F.checkBit(6);

    }

    public void setNF (boolean value) {

        F.setBit(6, value);

    }

    public boolean getHF () {

        return F.checkBit(5);

    }

    public void setHF (boolean value) {

        F.setBit(5, value);

    }

    public boolean getCF () {

        return F.checkBit(4);

    }

    public void setCF (boolean value) {

        F.setBit(4, value);

    }


}
