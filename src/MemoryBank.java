/**
 * Created by jamesnarey on 15/03/2016.
 */
public class MemoryBank extends GBByteArray {


    private String name;
    private String description;
    private int firstByte = 0;
    private int lastByte = 0;

    //Consider allowing intialisation using bank size as well as first/last byte
    public MemoryBank (String name, String description, int firstByte, int lastByte) {

        // +1 because both the first and last bytes are part of the memory bank
        super((lastByte - firstByte) + 1);

        this.name = name;
        this.description = description;
        this.firstByte = firstByte;
        this.lastByte = lastByte;
        this.populate();

        System.out.println(this.name + " - " + this.description + " - " + this.bytes.length);

    }

    public int getFirstByte() {
        return firstByte;
    }

    public int getLastByte() {
        return lastByte;
    }


}
