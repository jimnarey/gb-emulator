/**
 * Created by jamesnarey on 13/03/2016.
 */
public class Registers {

    // !! Consider writing 0's the the non-flag bits in F each cycle
    // !! or otherwise prevent them from being written with a 1

    public BByte A = new BByte();
    public BByte F = new BByte();
    public BByte B = new BByte();
    public BByte C = new BByte();
    public BByte D = new BByte();
    public BByte E = new BByte();
    public BByte H = new BByte();
    public BByte L = new BByte();

    public BytePair SP = new BytePair();
    public BytePair PC = new BytePair();
    public BytePair AF = new BytePair();
    public BytePair BC = new BytePair();
    public BytePair DE = new BytePair();
    public BytePair HL = new BytePair();

    public Registers() {

        PC.populate();
        SP.populate();

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
