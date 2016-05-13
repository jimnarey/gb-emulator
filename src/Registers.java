/**
 * Created by jamesnarey on 13/03/2016.
 */
public class Registers {

    // !! Consider writing 0's the the non-flag bits in F each cycle
    // !! or otherwise prevent them from being written with a 1

    public BetterByte A = new BetterByte();
    public FlagRegister F = new FlagRegister();
    public BetterByte B = new BetterByte();
    public BetterByte C = new BetterByte();
    public BetterByte D = new BetterByte();
    public BetterByte E = new BetterByte();
    public BetterByte H = new BetterByte();
    public BetterByte L = new BetterByte();

    public Short SP = new Short();
    public Short PC = new Short();
    public Short AF = new Short();
    public Short BC = new Short();
    public Short DE = new Short();
    public Short HL = new Short();

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
