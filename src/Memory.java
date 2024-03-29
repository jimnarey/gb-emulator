import java.io.IOException;

/**
 * Created by jamesnarey on 08/03/2016.
 */
public class Memory {
    
    protected GBByteArray[] memoryBanks;
    protected int[][] memoryMap;
    protected Bios bios;

    public Memory() throws IOException {

        this.memoryBanks = new GBByteArray[13];

//        this.memoryBanks[0] = new MemoryBank("restartInterruptVectors", "Restart and Interrupt Vectors", 0, 255);
//        this.memoryBanks[1] = new MemoryBank("cartridgeHeaderArea", "Cartridge Header Area", 256, 335);
//        this.memoryBanks[2] = new MemoryBank("cartridgeRom_1",  "Cartridge ROM - MemoryBank 0 (fixed)", 336, 16383);
//        this.memoryBanks[3] = new MemoryBank("cartridgeRom_2", "Cartridge ROM - Switchable MemoryBank 1-xx", 16384, 32767);
//        this.bios = new Bios();

        this.memoryBanks[0] = new Cartridge();
        this.memoryBanks[1] = new MemoryBank("characterRam", "Character RAM", 32768, 38911);
        this.memoryBanks[2] = new MemoryBank("bGMapData_1", "BG Map Data 1", 38912, 39935);
        this.memoryBanks[3] = new MemoryBank("bGMapData_2", "BG Map Data 2", 39936, 40959);
        this.memoryBanks[4] = new MemoryBank("cartridgeRam", "Cartridge RAM (If Available)", 40960, 49151);
        this.memoryBanks[5] = new MemoryBank("internalRam_0", "Internal RAM - MemoryBank 0 (fixed)", 49152, 53247);
        this.memoryBanks[6] = new MemoryBank("internalRam_1_7", "Internal RAM - MemoryBank 1-7 (switchable - CGB only)", 53248, 57343);
        this.memoryBanks[7] = new MemoryBank("echoRam", "Echo RAM - Reserved, Do Not Use", 57344, 65023);
        this.memoryBanks[8] = new MemoryBank("oAM", "OAM - Object Attribute Memory", 65024, 65183);
        this.memoryBanks[9] = new MemoryBank("unusableMemory", "Unusable Memory", 65184, 65279);
        this.memoryBanks[10] = new MemoryBank("ioRegisters", "Hardware I/O Registers",65280, 65407);
        this.memoryBanks[11] = new MemoryBank("highRam", "Zero Page - 127 bytes/High Ram", 65408, 65534);
        this.memoryBanks[12] = new MemoryBank("interruptEnable", "Interrupt Enable Flag", 65535, 65535);


        buildMemoryMap(this.getMemorySize());

    }

    public void activateBios() {

//        for (int i = 0; i < 256; i++) {
//
//            memoryMap[i][0] = 13;
//            memoryMap[i][1] = i;
//
//        }

    }

    public void deactivateBios () {

//        for (int i = 0; i < 256; i++) {
//
//            memoryMap[i][0] = 0;
//            memoryMap[i][1] = i;
//
//        }

    }

    // Consider using shorts from -32768, incrementing up to max 32767 as indexes
    public void buildMemoryMap(int memorySize) {

        int[][] mMap = new int[memorySize][2];

        //Consider putting an an array sort for safety
        int addressIncrement = 0;

        // Iterate up to the total no. of memory banks
        for (int i = 0; i < this.memoryBanks.length; i++) {

            // Within each memory bank, iterate up to the total no. of bytes in that bank
            for (int j = 0; j < this.memoryBanks[i].bytes.length; j++) {
                mMap[addressIncrement][0] = i;
                mMap[addressIncrement][1] = j;
                addressIncrement++;
            }
        }

        memoryMap = mMap;
    }


    public GBByte address (int address) {

        return memoryBanks[memoryMap[address][0]].unit(memoryMap[address][1]);

    }

    public GBByte LCDCStatusIS () {
        return address(0x0048);
    }

    public GBByte timerOverflowIS () {
        return address(0x0050);
    }

    public GBByte serialCompletionIS () {
        return address(0x0058);
    }

    public GBByte highToLowIS () {
        return address(0x0060);
    }

    public GBByte cartTypeAddress () {
        return address(0x0147);
    }

    public GBByte romSizeAddress () {
        return address(0x0148);
    }

    public GBByte ramSizeAddress () {
        return address(0x0149);
    }

    public GBByte compCheckAddress () {
        return address(0x014D);
    }

//    public void simpleLoadCartridge(Cartridge cartridge) {
//        int cartridgeSize = cartridge.romData.length;
//
//        if (cartridgeSize <= 0) {
//            System.out.println("No data in cartridge");
//
//        } else if (cartridgeSize > 32768){
//            System.out.println("Cartridge data too large");
//
//        } else {
//            for (int i = 0; i < 32767; i++) {
//                address(i).write(cartridge.romData[i]);
//            }
//            System.out.println("Cartridge loaded");
//        }
//    }

    public int getMemorySize() {

        int byteCount = 0;

        //Loop through declared memory MemoryBanks to calculate total number of bytes
        for (GBByteArray b : this.memoryBanks) {
            byteCount = byteCount + b.getNumBytes();
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
