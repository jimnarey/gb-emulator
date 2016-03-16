import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Change bytes to ints
 */
public class Cartridge {

    //ByteArrayOutputStream Data = new ByteArrayOutputStream;

    byte[] romData;

    public static void main(String args[]) throws IOException {

        //Cartridge testCartridge = new Cartridge("moo");

        String fileName = "";

        if (args.length > 1) {
            System.out.println("Too many arguments");
            System.exit(1);
        } else if (args.length == 0){
            //Check about instantiating objects/declaring variables in loop blocks
            fileName = "/Users/jamesnarey/Development/Projects/gb_emulator/roms/Tetris (World).gb";
        } else {
            fileName = args[0];
        }

        Cartridge testCartridge = new Cartridge(fileName);

        int count = 0;
        while (count < 5) {
            int thisByte = testCartridge.romData[count];
            System.out.println(thisByte);
            count++;
        }
        System.exit(0);
    }

    public Cartridge(String fileName) throws IOException {
        romData = readFile(fileName);
    }

    byte[] readFile(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        return Files.readAllBytes(path);
    }

}
