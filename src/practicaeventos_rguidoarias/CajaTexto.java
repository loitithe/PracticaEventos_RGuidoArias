/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaeventos_rguidoarias;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;

/**
 *
 * @author a22rodrigodga
 */
public class CajaTexto extends javax.swing.JTextField {

    public CajaTexto() {
      //  setEditable(false);
        setHorizontalAlignment(CENTER);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setFont(new Font("Arial", Font.ITALIC, 15));

    }

    public CajaTexto(String texto) {
        setEditable(false);
        setHorizontalAlignment(CENTER);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setFont(new Font("Arial", Font.ITALIC, 15));
        setText(texto);
    }

}
