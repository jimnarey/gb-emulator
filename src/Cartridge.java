import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Change bytes to ints
 */
public class Cartridge extends GBByteArray {

    protected String fileName;

    public Cartridge() throws IOException {
        super(32768);
        fileName = "/Users/jamesnarey/Development/Projects/gb_emulator/roms/Tetris (World).gb";
        readFile(fileName);

    }

    public void readFile(String fileName) throws IOException {
        byte[] cartBytes;

        Path path = Paths.get(fileName);
        cartBytes = Files.readAllBytes(path);
        
        for (int i = 0; i < numBytes; i++ ) {
            bytes[i].write( cartBytes[i] & 0xFF );
        }

    }

}
