/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaeventos_rguidoarias;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

/**
 *
 * @author a22rodrigodga
 */
public class Interfaz extends JFrame {

    GridBagLayout gl;
    GridBagConstraints c;
    Container panel = this.getContentPane();

    public Interfaz() {
        this.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        
    }

    public Interfaz(GridBagLayout gl, GridBagConstraints c) {
        this.gl = gl;
        this.c = c;
    }
    
    

}
