import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Prototype Java GB Emulator");

        //Initialise cartridge
        Cartridge cartridge = new Cartridge("/Users/jamesnarey/Development/Projects/gb_emulator/roms/Tetris (World).gb");

        //Initialise memory
        Memory memory = new Memory();

        //Load <=32Kb cartridge
        //memory.simpleLoadCartridge(cartridge);
        //memory.printAllBytes();

        MemoryBank bank = new MemoryBank("test", "test bank", 0, 255);

        DataUnit unit = new DataUnit(1);

        unit.write(2);

        bank.units[1].write(4);

        memory.writeByte(3, 50);

        memory.writeByte(258, 0);

        System.out.println("write mask test " + memory.readByte(0));

        System.out.println("bank.units[1]: " + bank.units[1]);

        System.out.println("Get size: " + bank.getSize());

        System.out.println("Memory read: " + memory.readByte(50));

        System.out.println("Bank read: " + bank.units[1].read());

        System.out.println("Unit read: " + unit.read());

        memory.simpleLoadCartridge(cartridge);


    }
}
