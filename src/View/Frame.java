package View;

import javax.swing.*;
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
    private JPanel contentPane = null;
    private JSpinner spinner = null;
    private SpinnerNumberModel spinnerModel = null;
    private JButton button = null;
    private NumberFormat format = null;

    public Frame(){
        buildFrame();
    }
    private void buildFrame() {
        frame = new JFrame();
        contentPane = new JPanel();
        format = NumberFormat.getNumberInstance();
        format.setParseIntegerOnly(true);
        format.setGroupingUsed(false);
        format.setMaximumFractionDigits(0);
        format.setMaximumIntegerDigits(3);
        spinnerModel =  new SpinnerNumberModel(
                new Integer(0),
                new Integer(0),
                new Integer(3),
                new Integer(1)
        );
        spinner = new JSpinner(spinnerModel);
        contentPane.add(spinner);
        button = new JButton("Mettre à jour");
        button.addActionListener(this);
        contentPane.add(button);
        frame.setContentPane(contentPane);
        frame.setTitle("Projet Java Maths");
        frame.pack();
    }
    public void close() {

        frame.dispose();
    }
    public void display() {

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
            System.out.println("[FieldVolumeView] : update");
        }
    }
}
