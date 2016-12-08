package Controller;

import Main.Main;
import Model.Complexe;
import Model.Echantillonage;
import Model.Nombre;
import View.Frame;
import org.apache.log4j.pattern.IntegerPatternConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by axel on 07/12/2016.
 */
public class FrameController {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public Frame frame = null;
    private Echantillonage echantillonage = null;
    private Complexe tab[] = null;


    public FrameController(Complexe tab[]){
       this.tab =tab;
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

    public Echantillonage getEchantillonage() {
        return echantillonage;
    }

    public void setEchantillonage(Echantillonage echantillonage) {
        this.echantillonage = echantillonage;
    }

    public void notifyNombreChanged(Complexe tabComp[], Integer nbValeur, Integer nbEchantillonage ) {

        echantillonage = new Echantillonage(nbEchantillonage, 4, tabComp);
        echantillonage.rempliTab0();
        echantillonage.calculColonneAj();
        echantillonage.selectioneAj();
        echantillonage.moduleAj();
        System.out.println(nbValeur + " " + nbEchantillonage);

    }
}
