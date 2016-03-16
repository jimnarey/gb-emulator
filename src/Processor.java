import java.util.HashMap;
import java.util.Map;

/**
 * Created by jamesnarey on 11/03/2016.
 */
public class Processor {

    //8bit registers
    //A is accumulator, F for flags, others general purpose
    //How to neatly join when needed?
    private int A, F, B, C, D, E, H, L;

    //16bit registers, stack pointer and program counter
    //How to split up if needed?
    private int SP, PC;

    public Processor() {



    }


    public void interpreter (byte instruction) {


        switch (instruction) {
            case 0x00:

            case 2:

        }

    }



}
