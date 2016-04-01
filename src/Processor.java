import java.util.HashMap;
import java.util.Map;

/**
 * Created by jamesnarey on 11/03/2016.
 */
public class Processor {

    //8bit registers
    //16bit registers, stack pointer and program counter
    //A is accumulator, F for flags, others general purpose
    //How to neatly join when needed?
    private DataUnit A, F, B, C, D, E, H, L, SP, PC;

    //private Instructions inst;

    final int zF = 7;
    final int nF = 6;
    final int hF = 5;
    final int cF = 4;

    public Processor() {

        // Check if SP needs to decrement before first operation GBCPUMan 63

        //inst = new Instructions(this);
        A = new DataUnit(1);
        F = new DataUnit(1);
        B = new DataUnit(1);
        C = new DataUnit(1);
        D = new DataUnit(1);
        E = new DataUnit(1);
        H = new DataUnit(1);
        L = new DataUnit(1);
        SP = new DataUnit(2);
        PC = new DataUnit(2);

        A.write(0);
        F.write(0);
        B.write(0);
        C.write(0);
        D.write(0);
        E.write(0);
        H.write(0);
        L.write(0);
        SP.write(0);
        PC.write(0);

    }


    public void interpreter (byte instruction) {



    }



}
