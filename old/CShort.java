/**
 * Created by jamesnarey on 13/05/2016.
 */
public class CShort extends BShort implements CByteInterface {

    protected BByte[] lastBytes;
    protected int lastWrite = 0;


    public CShort() {
        super();
        lastBytes = new BByte[2];

    }

}
