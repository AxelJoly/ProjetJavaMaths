package Main;

import Model.Complexe;
import Model.MusicThread;
import Model.Nombre;
import View.Frame;
import org.omg.CORBA.FREE_MEM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by axel on 05/12/2016.
 */


public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public Main() {
        LOGGER.info("mdr ca marche");

        LOGGER.info("vibouille est un enfant");
        LOGGER.info("Test");
        LOGGER.info("vibouille est un enfant ");
        LOGGER.info("vibouille est un enfant ");
        LOGGER.info("vibouille est un enfant ");
        LOGGER.info("vibouille est un enfant ");
        LOGGER.info("vibouille est un enfant ");
        // Complexe com=new Complexe(2,4);
        //LOGGER.info(com.cos().toString());
    }


    public static void main (String args[]){
        new Main();

        Complexe[] tab = {new Complexe(1, 0), new Complexe(1, 0), new Complexe(1, 0), new Complexe(1, 0)};
        Complexe[] result;
        Nombre re = new Nombre(2);
       result = re.calculFourierRapide(tab);

        int length = result.length;

        for (int i = 0; i < length; i++){
            LOGGER.info(result[i].toString());
        }
        Frame frame = new Frame();
        frame.display();

        Thread music = new Thread(new MusicThread());
        music.start();
    }
}