/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaeventos_rguidoarias;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author rodri
 */
public class Tabla extends JFrame implements ItemListener {

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    final static JLabel jLabelEQUALS = new JLabel(" = ");

    Container pane1 = this.getContentPane();
    JTextField jTextNumber, jTextProducto[] = new JTextField[10];

    JLabel jLabelTitulo;
    JComboBox jComboBox1;
    GridLayout gl;
    GridBagConstraints c;
    int multiplicador = 0, numSeleccionado = 0, producto = 0;

    // Action listener
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
        c = new GridBagConstraints();
        if (shouldFill) {
            c.fill = GridBagConstraints.HORIZONTAL;
        }
// JLabel principal
        jLabelTitulo = new JLabel("Tabla de multiplicar");
        jLabelTitulo.setHorizontalAlignment((int) CENTER_ALIGNMENT);

        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 3;
        c.weighty = 2;
        c.gridx = 0;
        c.gridy = 0;
        pane1.add(jLabelTitulo, c);

        // JComboBox 
        jComboBox1 = new JComboBox();
        jComboBox1.addItemListener(this);
        for (int i = 0; i < 10; i++) {
            jComboBox1.addItem("" + i);
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;

        pane1.add(jComboBox1, c);
        // Bucle for anidado : i columnas, j filas
        for (int i = 0; i < 3; i++) {
            if (shouldWeightX) {
                c.weightx = 0.5;
            }
            for (int j = 0; j < 13; j++) {
                jTextNumber = new JTextField();
                if (j < 10) {

                    switch (i) {
                        // primera columna
                        case 0:
                            jTextNumber.setText(Integer.toString(j));
                            jTextNumber.setName("" + i);
                            jTextNumber.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                            break;
                        //segunda columna
                        case 1:
                            jTextNumber.setText(" = ");
                            c.fill = GridBagConstraints.BOTH;
                            c.anchor = GridBagConstraints.WEST;
                            c.ipady = 10;
                            c.ipadx = 50;
                            c.weightx = 1.0;
                            c.gridwidth = 1;
                            c.gridx = i;
                            c.gridy = j + 1;
                            jTextNumber.setEditable(false);
                            pane1.add(jTextNumber, c);
                            break;
                        //tercera columna
                        case 2:
                            jTextNumber = new JTextField();
                            c.fill = GridBagConstraints.NONE;
                            c.anchor = GridBagConstraints.WEST;
                            c.ipady = 10;
                            c.ipadx = 50;
                            c.weightx = 1.0;
                            c.gridwidth = 1;
                            c.gridx = i;
                            c.gridy = j + 1;
                            jTextNumber.setEditable(false);
                            pane1.add(jTextNumber, c);
                            System.out.println("JTextproducto :" + jTextNumber.getText());
                            break;
                        default:
                            throw new AssertionError();
                    }

                    //    jTextNumber.setName("" + j);
                    c.fill = GridBagConstraints.BOTH;
                    c.ipady = 10;
                    c.weightx = 0.3;
                    c.gridwidth = 1;
                    c.gridx = i;
                    c.gridy = 3 + j;
                    jTextNumber.setEditable(false);
                    pane1.add(jTextNumber, c);
                    c.fill = GridBagConstraints.HORIZONTAL;
                    c.ipady = 10;
                    c.weightx = 0.3;
                    c.gridwidth = 1;
                    c.gridx = 1;
                    c.gridy = 3 + i;
                }
            }
        }

    }

    public int producto(int multiplicador, int multiplicando) {
        return multiplicador * multiplicando;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            numSeleccionado = jComboBox1.getSelectedIndex();
            System.out.println("seleccionado ; " + numSeleccionado);
        }
    }
}
