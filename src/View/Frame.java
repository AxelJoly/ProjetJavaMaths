package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by axel on 06/12/2016.
 */
public class Frame implements ActionListener, Observer {

    private JFrame frame = null;
    private JPanel fPane = null;
    private JButton button = null;
    private NumberFormat format = null;
    private JSpinner spinner = null;
    private JComboBox powList = null;

    public Frame(){
        buildFrame();
    }

    private void buildFrame() {
        frame = new JFrame();
        fPane = new JPanel();

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

      //  this.controller.notifyVolumeChanged(Integer.parseInt(this.spinner.getValue().toString()));
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Integer) {
            spinner.setValue((Integer) arg);
            powList.setSelectedIndex((Integer) arg);
            System.out.println("[Frame] : update");
        }
    }

}
