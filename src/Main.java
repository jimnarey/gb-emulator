import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Prototype Java GB Emulator");

        //Initialise cartridge
        Cartridge cartridge = new Cartridge("/Users/jamesnarey/Development/Projects/gb_emulator/roms/Tetris (World).gb");

        //Initialise memory
        Memory memory = new Memory();

        MemoryBank bank = new MemoryBank("test", "test bank", 0, 255);

        BByte unit = new BByte();

        unit.write(65536);

        System.out.println("Unit value: " + unit.read());

        memory.simpleLoadCartridge(cartridge);


    }
}
