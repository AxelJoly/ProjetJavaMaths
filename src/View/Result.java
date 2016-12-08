package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by axel on 07/12/2016.
 */
public class Result implements ActionListener, Observer{

        private JFrame frame = null;
        private JPanel fPane = null;
        private JButton button = null;
        private NumberFormat format = null;
        private JSpinner spinner = null;
        private JComboBox powList = null;

    public Result(){
        buildFrame();
    }

    private void buildFrame() {
        frame = new JFrame();
        fPane = new JPanel();
        button = new JButton();
        JLabel label = new JLabel("Nombre d'échantillon par sec");
        fPane.add(label, BorderLayout.CENTER);


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
