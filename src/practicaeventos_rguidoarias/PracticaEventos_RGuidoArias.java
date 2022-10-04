/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicaeventos_rguidoarias;

import javax.swing.JFrame;

/**
 *
 * @author rodri
 */
public class PracticaEventos_RGuidoArias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TablaMultiplicar tabla = new TablaMultiplicar();
        
        Tabla tabla1 = new Tabla();
        tabla1.setVisible(true);
        tabla1.setSize(400,500);
        tabla1.setLocation(500,400);
        tabla1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // tabla.setVisible(true);
       // tabla.setLocation(500,300);
    }
    
}
