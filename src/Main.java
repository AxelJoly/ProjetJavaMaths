
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javazoom.jl.player.*;
import java.io.FileInputStream;



/**
 * Created by axel on 05/12/2016.
 */


public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public Main(){
        LOGGER.info("mdr ca marche");

        LOGGER.info("vibouille est un enfant");
        LOGGER.info("Test");
        LOGGER.info("vibouille est un enfant ");
        LOGGER.info("vibouille est un enfant ");
        LOGGER.info("vibouille est un enfant ");
        LOGGER.info("vibouille est un enfant ");
        Complexe com=new Complexe(2,4);

        LOGGER.info(com.cos().toString());

        try{

            FileInputStream fis = new FileInputStream("noel.mp3");
            Player playMP3 = new Player(fis);


            playMP3.play();

        }catch(Exception e){
            System.out.println(e);
        }

    }
    public static void main (String args[]){
        new Main();
    }
}