package Controller;

import Main.Main;
import Model.Complexe;
import Model.Nombre;
import View.Frame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by axel on 07/12/2016.
 */
public class FrameController {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public Frame frame = null;
    private Nombre nombre = null;

    public FrameController(Nombre nombre){
        this.nombre =nombre;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }


    public void init(Frame frame) {

        this.frame = frame;

    }

    public void displayViews() {

        frame.display();

    }

    public void notifyNombreChanged(Complexe[] tabComp, double taille) {

        this.nombre.setTaille(taille);
        System.out.println(taille);

    }
}
