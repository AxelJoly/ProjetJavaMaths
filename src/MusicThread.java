/**
 * Created by axel on 06/12/2016.
 */

import javazoom.jl.player.*;
import java.io.FileInputStream;

public class MusicThread implements Runnable{

    public void run() {
        try {
            FileInputStream fis = new FileInputStream("bip.mp3");
            Player playMP3 = new Player(fis);
            playMP3.play();

        } catch (Exception e) {
        }

    }

}
