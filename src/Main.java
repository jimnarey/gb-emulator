import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Prototype Java GB Emulator");

        //Initialise cartridge
        Cartridge cartridge = new Cartridge("/Users/jamesnarey/Development/Projects/gb_emulator/roms/Tetris (World).gb");

        //Initialise memory
        Memory memory = new Memory();

        //Load <=32Kb cartridge
        memory.simpleLoadCartridge(cartridge);
        memory.printAllBytes();

    }
}
