/**
 * Created by jamesnarey on 08/03/2016.
 */
public class Memory {
    
    public MemoryBank[] memoryBanks;
    private int[][] memoryMap;

    public static void main(String args[]) {
        Memory testMemory = new Memory();
        System.out.println(testMemory.memoryBanks[0].getSize());
        //testMemory.printMemoryMap();

    }

    public Memory() {

        //Consider importing a JSON/CSV memory specification
        this.memoryBanks = new MemoryBank[16];

        this.memoryBanks[0] = new MemoryBank("restartInterruptVectors", "Restart and Interrupt Vectors", 0, 255);
        this.memoryBanks[1] = new MemoryBank("cartridgeHeaderArea", "Cartridge Header Area", 256, 335);
        this.memoryBanks[2] = new MemoryBank("cartridgeRom_1",  "Cartridge ROM - MemoryBank 0 (fixed)", 336, 16383);
        this.memoryBanks[3] = new MemoryBank("cartridgeRom_2", "Cartridge ROM - Switchable MemoryBank 1-xx", 16384, 32767);
        this.memoryBanks[4] = new MemoryBank("characterRam", "Character RAM", 32768, 38911);
        this.memoryBanks[5] = new MemoryBank("bGMapData_1", "BG Map Data 1", 38912, 39935);
        this.memoryBanks[6] = new MemoryBank("bGMapData_2", "BG Map Data 2", 39936, 40959);
        this.memoryBanks[7] = new MemoryBank("cartridgeRam", "Cartridge RAM (If Available)", 40960, 49151);
        this.memoryBanks[8] = new MemoryBank("internalRam_0", "Internal RAM - MemoryBank 0 (fixed)", 49152, 53247);
        this.memoryBanks[9] = new MemoryBank("internalRam_1_7", "Internal RAM - MemoryBank 1-7 (switchable - CGB only)", 53248, 57343);
        this.memoryBanks[10] = new MemoryBank("echoRam", "Echo RAM - Reserved, Do Not Use", 57344, 65023);
        this.memoryBanks[11] = new MemoryBank("oAM", "OAM - Object Attribute Memory", 65024, 65183);
        this.memoryBanks[12] = new MemoryBank("unusableMemory", "Unusable Memory", 65184, 65279);
        this.memoryBanks[13] = new MemoryBank("ioRegisters", "Hardware I/O Registers",65280, 65407);
        this.memoryBanks[14] = new MemoryBank("highRam", "Zero Page - 127 bytes/High Ram", 65408, 65534);
        this.memoryBanks[15] = new MemoryBank("interruptEnable", "Interrupt Enable Flag", 65535, 65535);

        //Consider specifying initial size and load factor
        //this.memoryMap = new HashMap();

        this.memoryMap = new int[getMemorySize()][2];
        memoryMap = this.buildMemoryMap();

    }

    // Consider using shorts from -32768, incrementing up to max 32767 as indexes
    public int[][] buildMemoryMap() {

        int[][] memoryMap = new int[this.getMemorySize()][2];

        //Consider putting an an array sort for safety
        int addressIncrement = 0;

        // Iterate up to the total no. of memory banks
        for (int i = 0; i < this.memoryBanks.length; i++) {

            // Within each memory bank, iterate up to the total no. of bytes in that bank
            for (int j = 0; j < this.memoryBanks[i].units.length; j++) {
                memoryMap[addressIncrement][0] = i;
                memoryMap[addressIncrement][1] = j;
                addressIncrement++;
            }
        }

        return memoryMap;
    }


    public DataUnit address (int address) {

        return memoryBanks[memoryMap[address][0]].units[memoryMap[address][1]];

    }

//    private int[] getMemoryBankAddress(int address) {
//
//        int[] MemoryBanksAddress = new int[2];
//        MemoryBanksAddress[0] = memoryMap[address][0]; //Bank
//        MemoryBanksAddress[1] = memoryMap[address][1]; //Location in bank
//        return MemoryBanksAddress;
//
//    }
//    // Need to convert addresses into unsigned ints !!!!!!!!!!!!!!!!
//    public void writeByte(int byteToWrite, int address) {
//
//        // address[0] contains bank no, address[1] contains the byte no. within that bank
//        // System.out.println(byteToWrite + " " + memoryMap[address][0] + " " + memoryMap[address][1]);
//        // memoryBanks[memoryMap[address][0]].units[memoryMap[address][1]].write(byteToWrite);
//
//        // memoryMap[address[0] identifies the correct bank
//        // memoryMap[address[1] identifies the address within the bank
//
//        memoryBanks[memoryMap[address][0]].units[memoryMap[address][1]].write(byteToWrite);
//
//    }
//
//    public int readByte(int address) {
//
//        return memoryBanks[memoryMap[address][0]].units[memoryMap[address][1]].read();
//
//    }

    // Split number into two bytes
    // Write MSB and LSB
//    public void writeWord(int wordToWrite, int address) {
//
//        // Test bitwise ops to create two units
//        // memoryBanks[memoryMap[address][0]].units[memoryMap[address][1]].write(wordToWrite);
//
//        // Check this writes the bytes in the correct order.
//        memoryBanks[memoryMap[address][0]].units[memoryMap[address][1]].write((wordToWrite & 0xFF));
//        memoryBanks[memoryMap[address + 1][0]].units[memoryMap[address + 1][1]].write((wordToWrite >> 8) & 0xFF);
//
//    }
//
//    // Read MSB and LSB
//    // Merge into int and return
//    public int readWord(int address) {
//
//        // Test bitwise ops as above
//        //return memoryBanks[memoryMap[address][0]].units[memoryMap[address][1]].read();
//        int msb = memoryBanks[memoryMap[address][0]].units[memoryMap[address][1]].read();
//        int lsb = memoryBanks[memoryMap[address + 1][0]].units[memoryMap[address + 1][1]].read();
//
//        // Check these are the right way round!!!
////        // Should this be (msb >> 8) & 0xFF)?
////        return ((lsb << 8) | (msb & 0xFF));
////
////    }
//
//    public void printAllBytes() {
//
//        for (int i = 0 ; i < 65535; i++) {
//
//            System.out.println(readByte(i));
//
//        }
//
//    }

    public static int[] oldWordToBytes(int word) {
        int[] bytes = new int[2];
        // Get MSB
        bytes[0] = ((word >> 8) & 0xFF);
        // Get LSB
        bytes[1] = (word & 0xFF);
        return bytes;
    }

    public void simpleLoadCartridge(Cartridge cartridge) {
        int cartridgeSize = cartridge.romData.length;

        if (cartridgeSize <= 0) {
            System.out.println("No data in cartridge");

        } else if (cartridgeSize > 32768){
            System.out.println("Cartridge data too large");

        } else {
            for (int i = 0; i < 32767; i++) {
                address(i).write(cartridge.romData[i]);
            }
            System.out.println("Cartridge loaded");
        }
    }

    //Information methods
    public int getMemorySize() {

        int byteCount = 0;

        //Loop through declared memory MemoryBanks to calculate total number of bytes
        for (MemoryBank b : this.memoryBanks) {
            byteCount = byteCount + b.getSize();
        }

        //Print total number of bytes
        System.out.println("Total memory in declared MemoryBanks = " + byteCount + " bytes");

        return byteCount;

    }

    public void printMemoryMap() {

        for (int i[]: this.memoryMap) {

            System.out.print(i[0]);
            System.out.print(" ");
            System.out.println(i[1]);
        }
    }


}
