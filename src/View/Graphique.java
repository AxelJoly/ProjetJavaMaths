package View;

import Model.Complexe;
import Model.Echantillonage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by axel on 08/12/2016.
 */
public class Graphique implements ActionListener{

    private JFrame frame = null;
    private JPanel fPane = null;
    private JButton button = null;
    private Echantillonage echantillonage = null;
    private Integer taille = null;


    public Graphique(Echantillonage echantillonage, Integer taille){
        this.echantillonage = echantillonage;
        this.taille = taille;
        buildFrame();
    }

    private void buildFrame() {
        frame = new JFrame();
        fPane = new JPanel();
        button = new JButton();
        JLabel label = new JLabel("Graphique");
        fPane.add(label, BorderLayout.CENTER);

        button = new JButton("Quitter");
        fPane.add(button, BorderLayout.SOUTH);
        Complexe[][] tabComplexe = echantillonage.getMatrice();
        String[] tab = null;
        for(int i = 0; i< echantillonage.getNbPoints()/echantillonage.getEchantillonage(); i++)
        {
            for(int j = 0; j < Math.pow(2, taille); j++){
                tab[i] = tab[i] + tabComplexe[i][j];
            }
        }

        DefaultPieDataset data=new DefaultPieDataset();
        data.setValue("Category1",43.2);
        data.setValue("Category2",27.9);
        data.setValue("Category3",79.5);

        JFreeChart chart = ChartFactory.createPieChart( "SamplePieChart", data, false, false, false);

        //create and display a frame...
        ChartFrame frame=new ChartFrame("First",chart);

        button.addActionListener(this);
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
        close();
    }
}
