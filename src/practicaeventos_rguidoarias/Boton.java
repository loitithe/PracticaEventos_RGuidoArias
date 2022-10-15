/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaeventos_rguidoarias;

import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author rodri
 */
public class Boton extends JButton   {

    String texto;

    public Boton() {
    }

    public Boton(String texto) {
        this.texto = texto;
        setFont(new Font("Italic",Font.ITALIC,15));
        setHorizontalAlignment(CENTER);
        setText(texto);
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

  

}
