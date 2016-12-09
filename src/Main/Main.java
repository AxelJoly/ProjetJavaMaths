
package Main;

import Controller.FrameController;
import Model.Complexe;
import Model.MusicThread;
import Model.Nombre;
import Model.Echantillonage;
import Model.ReadFiles;
import View.Frame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;


/**
 * Created by axel on 05/12/2016.
 */


public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);


    public static void main (String args[]){

        /*
        Initialisation de la frame, de la musique et du controller
         */

        FrameController controller = new FrameController();
        Thread music = new Thread(new MusicThread());
       music.start();

        Frame frame = new Frame(controller);
        controller.init(frame);
        frame.display();

    }
}