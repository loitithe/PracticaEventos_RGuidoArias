/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaeventos_rguidoarias;

import java.awt.GridBagConstraints;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author rodri
 */
public class Manejador extends JFrame implements ItemListener, ActionListener {

    GridBagLayout gl;
    GridBagConstraints c;
    Container pane1 = this.getContentPane();

    JLabel labelTitulo = new JLabel("Tabla de multiplicar");
    JComboBox jComboBox;

    CajaTexto jTextFieldNumero[] = new CajaTexto[10];
    CajaTexto jTextEquals;
    CajaTexto jTextResultado[] = new CajaTexto[10];

    JLabel lblNumero1 = new JLabel("Numero1");
    JLabel lblNumero2 = new JLabel("Numero2");
    JLabel lblResultado = new JLabel("Resultado");
    JTextField jTextNum1 = new JTextField();
    JTextField jTextNum2 = new JTextField();
    CajaTexto jTextResult = new CajaTexto();

    JButton jButtonSumar = new JButton("Sumar");
    private int num1, num2;
    private int resultado;
    Matematica m;

    /**
     * Constructor principal
     */
    public Manejador() {
        initComp();
    }

    /**
     * Funcion que inicializa los componentes
     */
    void initComp() {
        m = new Matematica();
        jButtonSumar.addActionListener(this);
        GridBagLayout gb = new GridBagLayout();
        gl = new GridBagLayout();
        pane1.setLayout(gb);
        c = new GridBagConstraints();
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        pane1.add(labelTitulo, createConstraints(0, 0, 3, 1, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
        
        jComboBox = new JComboBox();
        jComboBox.addItemListener(this);
        for (int i = 0; i < 10; i++) {
            jComboBox.addItem(i);
        }
        pane1.add(jComboBox, createConstraints(0, 1, 3, 1, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));

        for (int i = 0; i < 13; i++) {
            if (i < 10) {
                jTextFieldNumero[i] = new CajaTexto(String.valueOf(i));
                jTextEquals = new CajaTexto(" = ");
                jTextResultado[i] = new CajaTexto();
                pane1.add(jTextFieldNumero[i], createConstraints(0, i + 2, 1, 1, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
                pane1.add(jTextEquals, createConstraints(1, i + 2, 1, 1, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
                pane1.add(jTextResultado[i], createConstraints(2, i + 2, 1, 1, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));

            } else {
                pane1.add(lblNumero1, createConstraints(0, i + 2, 1, 1, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
                pane1.add(jTextNum1, createConstraints(1, i + 2, 1, 1, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
                pane1.add(lblNumero2, createConstraints(0, i + 3, 1, 1, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
                pane1.add(jTextNum2, createConstraints(1, i + 3, 1, 1, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
                pane1.add(lblResultado, createConstraints(0, i + 4, 1, 2, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
                pane1.add(jTextResult, createConstraints(1, i + 4, 1, 2, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));

                pane1.add(jButtonSumar, createConstraints(2, i + 2, 1, 4, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));

            }

        }

    }

    /**
     *
     * @param gridx specify the row
     * @param gridy specify the column
     * @param gridwidth specify number of columns
     * @param gridheight specify number of rows
     * @param weightx space among columns
     * @param weighty space among rows
     * @param fill specify how to resize
     * @param anchor specify where to place
     * @param insets specify external padding
     * @return
     */
    private static GridBagConstraints createConstraints(int gridx, int gridy, int gridwidth, int gridheight,
            double weightx,
            double weighty, int fill, int anchor, Insets insets) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.fill = fill;
        constraints.anchor = anchor;
        constraints.insets = insets;
        return constraints;

    }

    /**
     * Gestión del JComboBox
     *
     * @param e variable del evento
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        int numSeleccionado = 0;
        if (e.getStateChange() == ItemEvent.SELECTED) {
            numSeleccionado = jComboBox.getSelectedIndex();
            System.out.println("seleccionado ; " + numSeleccionado);
            for (int i = 0; i < 10; i++) {
                try {
                    jTextResultado[i].setText("" + (numSeleccionado * i));
                } catch (Exception ee) {
                    System.err.println(ee.getMessage());
                }
            }
        }
    }

    /**
     * Gestion del jButton
     *
     * @param e variable del evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonSumar) {
            num1 = Integer.parseInt(jTextNum1.getText());
            num2 = Integer.parseInt(jTextNum2.getText());
            //   jTextResult.setText("" + suma());
            jTextResult.setText("" + m.suma(num1, num2));
//            jTextNum1.setText("");
//            jTextNum2.setText("");
        }
    }

    /**
     * Función que recoge los y devuelve la suma como Integer
     *
     * @return integer con la suma
     */
    int suma() {
        try {
            num1 = Integer.parseInt(jTextNum1.getText());
            num2 = Integer.parseInt(jTextNum2.getText());
            resultado = num1 + num2;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return resultado;
    }
}
