package View;

import Controller.FrameController;
import Model.Complexe;
import Model.Nombre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by axel on 06/12/2016.
 */
public class Frame implements ActionListener, Observer {
    private FrameController controller = null;
    private JFrame frame = null;
    private JPanel fPane = null;
    private JButton button = null;
    private NumberFormat format = null;
    private JSpinner spinner = null;
    private JComboBox powList = null;
    private JLabel labelAChanger = null;
    private Complexe[] tab = {new Complexe(1, 0), new Complexe(1, 0), new Complexe(1, 0), new Complexe(1, 0)};
    private Nombre nombre = null;

    public Frame(Nombre nombre, FrameController controller){
        this.nombre = nombre;
        this.nombre.addObserver(this);
        this.controller = controller;
        buildFrame();
    }

    private void buildFrame() {
        frame = new JFrame();
        fPane = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar m=new JMenuBar();
        JMenu menu1=new JMenu ("Fichier");
        JMenu menu2=new JMenu ("Edition");
        // separe d'un trait

        JMenu nouveau= new JMenu ("Nouveau");
        JMenuItem nouveauSon= new JMenuItem("A partir d'un fichier son");
        nouveau.add(nouveauSon);
        JMenuItem nouveauUsuel= new JMenuItem("A partir d'une fonction usuelle");
        nouveau.add(nouveauUsuel);
        JMenuItem nouvelleFonction= new JMenuItem("A partir d'une fonction non définie");
        nouveau.add(nouvelleFonction);
        menu1.add(nouveau);
        JMenuItem annuler= new JMenuItem("Annuler");
        menu2.add(annuler);
        JMenuItem load= new JMenuItem("Charger le .txt");
        menu1.add(load);
        menu1.addSeparator();
        JMenuItem quitter = new JMenuItem("Quitter");
        menu1.add(quitter);
        m.add(menu1);
        m.add(menu2);
        frame.setJMenuBar(m);


        fPane.setLayout(new GridLayout(2,1));
       JPanel tPane = new JPanel();
        tPane.setLayout(new GridLayout(2,2));

       JPanel bPane = new JPanel();
        bPane.setLayout(new GridLayout(3,3));

       JLabel label = new JLabel("Nombre d'échantillon par sec");
        tPane.add(label, BorderLayout.CENTER);

        format = NumberFormat.getNumberInstance();
        format.setParseIntegerOnly(true);
        format.setGroupingUsed(false);
        format.setMaximumFractionDigits(0);
        format.setMaximumIntegerDigits(3);

         SpinnerNumberModel spinnerModel =  new SpinnerNumberModel(
                new Integer(0),
                new Integer(0),
                new Integer(100),
                new Integer(5)
        );
        spinner = new JSpinner(spinnerModel);
        tPane.add(spinner, BorderLayout.CENTER);

        JLabel label2 = new JLabel("Nombre d'échantillon");
        tPane.add(label2, BorderLayout.CENTER);

        Integer[] pow = { 2, 4, 8, 16, 32, 64, 128, 256, 512 };
        powList = new JComboBox(pow);
        tPane.add(powList, BorderLayout.CENTER);


        button = new JButton("Mettre à jour");
        bPane.add(button);
        button.addActionListener(this);

        labelAChanger = new JLabel("Valeur a changer");
        bPane.add(labelAChanger, BorderLayout.CENTER);
        fPane.add(tPane);
        fPane.add(bPane);
        frame.setContentPane(fPane);
        frame.setTitle("Projet Java Maths");
        frame.pack();
    }
    public void close() {

        frame.dispose();
    }
    public void display() {
        frame.setSize(600, 400);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Integer nb = (Integer) powList.getSelectedItem();
       this.controller.notifyNombreChanged(this.tab, nb);
    }

    @Override
    public void update(Observable o, Object arg) {
     //  if (arg instanceof Double) {
            labelAChanger.setText(arg.toString()); // juste pour essayer

            System.out.println("[Frame] : update");
      //  }
    }

}
