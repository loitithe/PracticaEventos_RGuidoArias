/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaeventos_rguidoarias;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author rodri
 */
public class Tabla extends JFrame {

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    final static JLabel jLabelEQUALS = new JLabel(" = ");
    
    Container pane1 = this.getContentPane();
    JTextField jTextNumber;
    JLabel jLabelTitulo;
    GridLayout gl;

    public Tabla() {
        super("Practica Eventos");
        initComponents();
    }

    void initComponents() {
        if (RIGHT_TO_LEFT) {
            pane1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        GridBagLayout gb = new GridBagLayout();
        gl = new GridLayout(10, 3);
        pane1.setLayout(gb);
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            c.fill = GridBagConstraints.HORIZONTAL;
        }

// JLabel principal
        jLabelTitulo = new JLabel("Tabla de multiplicar");

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        pane1.add(jLabelTitulo, c);

        // JComboBox 
        JComboBox jComboBox1 = new JComboBox();
        for (int i = 0; i < 10; i++) {
            jComboBox1.addItem("" + i);
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        pane1.add(jComboBox1, c);
        //JTextField 
        for (int i = 0; i < 10; i++) {
            if (shouldWeightX) {
                c.weightx = 0.5;
            }
            jTextNumber = new JTextField("" + i);
            jTextNumber.setName("" + i);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.ipady = 10;
            c.weightx = 0.3;
            c.gridwidth = 1;
            c.gridx = 0;
            c.gridy = 3 + i;
            jTextNumber.setEditable(false);
            pane1.add(jTextNumber, c);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.ipady = 10;
            c.weightx = 0.3;
            c.gridwidth = 1;
            c.gridx = 1;
            c.gridy = 3 + i;
            pane1.add(jLabelEQUALS);
        }

    }

}
