import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Created by jamesnarey on 08/03/2016.
 */
public class HashMemory extends HashMap {

    /*private Bank restartInterruptVectors;
    private Bank cartridgeHeaderArea;
    private Bank cartridgeRom_1;
    private Bank cartridgeRom_2;
    private Bank characterRam;
    private Bank bGMapData_1;
    private Bank bGMapData_2;
    private Bank cartridgeRam;
    private Bank internalRam_0;
    private Bank internalRam_1_7;
    private Bank echoRam;
    private Bank oAM;
    private Bank unusableMemory;
    private Bank ioRegisters;
    private Bank highRam;
    private Bank interruptEnable;*/

    private HashMap memoryMap;

    public static void main(String args[]) {

        HashMemory testMemory = new HashMemory();

    }

    public HashMemory() {
        this.put ("restartInterruptVectors", new Bank("Restart and Interrupt Vectors", 0, 255));
        this.put ("cartridgeHeaderArea",  new Bank("Cartridge Header Area", 256, 335));
        this.put ("cartridgeRom_1", new Bank("Cartridge ROM - Bank 0 (fixed))", 336, 16383));
        this.put ("cartridgeRom_2", new Bank("Cartridge ROM - Switchable Banks 1-xx", 16384, 32767));
        this.put ("characterRam", new Bank("Character RAM", 32768, 38911));
        this.put ("bGMapData_1", new Bank("BG Map Data 1", 38912, 39935));
        this.put ("bGMapData_2", new Bank("BG Map Data 2", 39936, 40959));
        this.put ("cartridgeRam", new Bank("Cartridge RAM (If Available))", 40960, 49151));
        this.put ("internalRam_0", new Bank("Internal RAM - Bank 0 (fixed))", 49152, 53247));
        this.put ("internalRam_1_7", new Bank("Internal RAM - Bank 1-7 (switchable - CGB only))", 53248, 57343));
        this.put ("echoRam", new Bank("Echo RAM - Reserved, Do Not Use", 57344, 65023));
        this.put ("oAM", new Bank("OAM - Object Attribute Memory", 65024, 65183));
        this.put ("unusableMemory", new Bank("Unusable Memory", 65184, 65279));
        this.put ("ioRegisters", new Bank("Hardware I/O Registers",65280, 65407));
        this.put ("highRam", new Bank("Zero Page - 127 bytes/High Ram", 65408, 65534));
        this.put ("interruptEnable", new Bank("Interrupt Enable Flag", 65535, 65535));

        //Consider specifying initial size and load factor
        this.memoryMap = new HashMap();
    }


    class Bank {

        private String description = "";
        private int firstByte = 0;
        private int lastByte = 0;
        private byte[] contents;

        public Bank (String description, int firstByte, int lastByte) {
            this.description = description;
            this.firstByte = firstByte;
            this.lastByte = lastByte;
            this.contents = new byte[this.getSize()];
        }

        public int getFirstByte() {
            return firstByte;
        }

        public int getLastByte() {
            return lastByte;
        }

        public int getSize() {
            //Refelecting that the first and last bytes are part of the bank
            return (lastByte - firstByte) + 1;
        }

    }



}
