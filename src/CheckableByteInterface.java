/**
 * Created by jamesnarey on 13/05/2016.
 */
public interface CheckableByteInterface extends ByteInterface {

    boolean checkOverflow ();

    boolean isZero();

    boolean checkHalfOverflow();

}
