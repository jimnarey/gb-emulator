import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Prototype Java GB Emulator");

        //Initialise cartridge
        Cartridge cartridge = new Cartridge("/Users/jamesnarey/Development/Projects/gb_emulator/roms/Tetris (World).gb");

        //Initialise memory
        Memory memory = new Memory();
        Processor p = new Processor();
//        Instructions i = new Instructions(p.r);

//        memory.simpleLoadCartridge(cartridge);

//        Registers registers = new Registers();

        BByte bByte0 = new BByte();
        BByte bByte1 = new BByte();


        bByte0.write(1);
        bByte1.write(1);

//        BytePair bytePair = new BytePair();
//        bytePair.populate();
//        bytePair.write(227);

//        Instructions.LD(bytePair, bByte0);
//
//        Instructions.LD(bytePair, bByte0);

//        Instructions.LD(new BytePair( memory.address(10), memory.address(11)), bytePair);

//        memory.address(10).write(200);
//
//        BytePair bytePair1 = new BytePair(memory.address(10), memory.address(11));
//
//        bytePair1.write(300);
//
//        System.out.println("MSB " + memory.address(11).read());
//        System.out.println("LSB " + memory.address(10).read());
//
//        System.out.println(memory.address(11).readString() + " " + memory.address(10).readString());

        BytePair bytePair2 = new BytePair(memory.address(200), memory.address(201));

        int test = new BytePair(memory.address(200 + 1), memory.address(200 + 2)).read();
        System.out.println(test);

//        i.LD(bytePair2, new BytePair(bByte0, bByte1));

        System.out.println("MSB " + memory.address(201).read());
        System.out.println("LSB " + memory.address(200).read());

        System.out.println(memory.address(201).readString() + " " + memory.address(200).readString());
        System.out.println();
        
    }
}
