
package Main;

import Controller.FrameController;
import Model.Complexe;
import Model.MusicThread;
import Model.Nombre;
import Model.Echantillonage;

import View.Frame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by axel on 05/12/2016.
 */


public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public Main() {

    }



    public static void main (String args[]){


        Complexe[] tab = {new Complexe(1, 0), new Complexe(1, 0), new Complexe(1, 0), new Complexe(1, 0)};
        Complexe[] result;
        Complexe[] tab2 = new Complexe[1000];
        for(int i=0;i<16;i++) {
            tab2[i] = new Complexe(i, 0);
        }
        Echantillonage ech=new Echantillonage(4,16,tab2);
        ech.rempliTab0();
        ech.calculColonneAj();
        for(int j=0;j<(ech.getNbPoints()/ech.getEchantillonage()); j++) {
            for (int i = 0; i < ech.getEchantillonage(); i++) {
                LOGGER.info(ech.getMatrice()[j][i].toString());
            }
        }
        ech.selectioneAj();

        Nombre re = new Nombre(2);
       result = re.calculFourierRapide(tab);

        int length = result.length;

        for (int i = 0; i < length; i++){
            LOGGER.info(result[i].toString());
        }
        FrameController controller = new FrameController(re);
        Thread music = new Thread(new MusicThread());
       // music.start();

        Frame frame = new Frame(re, controller);
        controller.init(frame);
        frame.display();

    }
}