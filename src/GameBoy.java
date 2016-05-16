/**
 * Created by jamesnarey on 13/05/2016.
 */
public class GameBoy {

    protected Memory memory;
    protected Processor processor;
    // Graphics, sound, joypad...

    public GameBoy () {
        this.memory = new Memory();
        this.processor = new Processor(this.memory);
    }



}
