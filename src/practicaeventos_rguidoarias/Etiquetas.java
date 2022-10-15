/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaeventos_rguidoarias;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author rodri
 */
public class Etiquetas extends JLabel {

    public Etiquetas() {
        setHorizontalAlignment(CENTER);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.CYAN));
        setFont(new Font("Arial", Font.ITALIC, 15));
    }

    public Etiquetas(String texto) {
        setHorizontalAlignment(CENTER);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.CYAN));
        setFont(new Font("Arial", Font.ITALIC, 15));
        setText(texto);
    }

}
