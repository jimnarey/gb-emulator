/**
 * Created by jamesnarey on 13/03/2016.
 */
public class Registers {

    // !! Consider writing 0's the the non-flag bits in F each cycle
    // !! or otherwise prevent them from being written with a 1

    public GBByte A = new GBByte();
    public FlagRegister F = new FlagRegister();
    public GBByte B = new GBByte();
    public GBByte C = new GBByte();
    public GBByte D = new GBByte();
    public GBByte E = new GBByte();
    public GBByte H = new GBByte();
    public GBByte L = new GBByte();

    public GBShort SP = new GBShort();
    public GBShort PC = new GBShort();
    public GBShort AF = new GBShort();
    public GBShort BC = new GBShort();
    public GBShort DE = new GBShort();
    public GBShort HL = new GBShort();

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


}
