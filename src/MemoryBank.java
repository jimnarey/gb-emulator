/**
 * Created by jamesnarey on 15/03/2016.
 */
public class MemoryBank {


    private String name;
    private String description;
    private int firstByte = 0;
    private int lastByte = 0;
    //public int[] bytes;
    public DataUnit[] units;

    //Consider allowing intialisation using bank size as well as first/last byte
    public MemoryBank (String name, String description, int firstByte, int lastByte) {
        this.name = name;
        this.description = description;
        this.firstByte = firstByte;
        this.lastByte = lastByte;
        //this.bytes = new int[this.getSize()];
        this.units = new DataUnit[this.getSize()];

        for (int i = 0; i < this.getSize(); i++) {
            //System.out.println(i);
            this.units[i] = new DataUnit(1);
        }

        System.out.println(this.name + " " + this.units.length);

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
