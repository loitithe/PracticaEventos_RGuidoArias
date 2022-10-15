/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaeventos_rguidoarias;

import java.awt.GridBagConstraints;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author rodri
 */
public class Manejador extends JFrame implements ItemListener, ActionListener {

    GridBagLayout gl;
    GridBagConstraints c;
    Container pane1 = this.getContentPane();

    Etiquetas labelTitulo = new Etiquetas("Tabla de multiplicar");
    JComboBox jComboBox;

    CajaTexto jTextFieldNumero[] = new CajaTexto[10];
    CajaTexto jTextEquals;
    CajaTexto jTextResultado[] = new CajaTexto[10];

    Etiquetas lblNumero1 = new Etiquetas("Numero1");
    Etiquetas lblNumero2 = new Etiquetas("Numero2");
    Etiquetas lblResultado = new Etiquetas("Resultado");
    CajaTexto jTextNum1 = new CajaTexto();
    CajaTexto jTextNum2 = new CajaTexto();
    CajaTexto jTextResult = new CajaTexto();

    Boton jButtonSumar = new Boton("Sumar");
    final Color colorBotonDefecto = jButtonSumar.getBackground();
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
        jComboBox.setFocusTraversalPolicy(new ContainerOrderFocusTraversalPolicy());
        for (int i = 0; i < 13; i++) {
            if (i < 10) {
                jTextFieldNumero[i] = new CajaTexto(String.valueOf(i));
                jTextFieldNumero[i].setFocusable(false);
                jTextEquals = new CajaTexto(" = ");
                jTextEquals.setFocusable(false);
                jTextResultado[i] = new CajaTexto();
                jTextResultado[i].setFocusable(false);
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
        jButtonSumar.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jButtonSumar.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent e) {
                jButtonSumar.setBackground(colorBotonDefecto);
            }
        });
        /**
         * Gestionamos la pulsacion de teclado en nuestro boton
         */
        jButtonSumar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
                    jButtonSumar.doClick();
                }
            }
        });
        
        jComboBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode()==KeyEvent.VK_ENTER) {
                    
              numeroSeleccionado();
                }
            }
        
        });

        jTextResult.setFocusable(false);
        jTextNum1.setFocusable(true);
        jTextNum2.setFocusable(true);
        jButtonSumar.setFocusable(true);

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
//        int numSeleccionado = 0;
//        if (e.getStateChange() == ItemEvent.SELECTED) {
//            numSeleccionado = jComboBox.getSelectedIndex();
//            for (int i = 0; i < 10; i++) {
//                try {
//                    jTextResultado[i].setText("" + m.multiplicacion(numSeleccionado, i));
//                } catch (Exception ee) {
//                    //  System.err.println(ee.getMessage());
//                }
//            }
//        }
                 numeroSeleccionado();
    }

    /**
     * Gestion del jButton
     *
     * @param e variable del evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonSumar) {
            try {
                num1 = Integer.parseInt(jTextNum1.getText());
                num2 = Integer.parseInt(jTextNum2.getText());
            } catch (NumberFormatException exp) {
                System.err.println("Formato numérico erroneo ." + exp.getMessage());
            }

            jTextResult.setText("" + m.suma(num1, num2));

        }
    }
    
    public void numeroSeleccionado(){
        int numSeleccionado=jComboBox.getSelectedIndex();
        for (int i = 0; i < 10; i++) {
             try {
                    jTextResultado[i].setText("" + m.multiplicacion(numSeleccionado, i));
                } catch (Exception ee) {
                    //  System.err.println(ee.getMessage());
                }
        }
        
    }
}
