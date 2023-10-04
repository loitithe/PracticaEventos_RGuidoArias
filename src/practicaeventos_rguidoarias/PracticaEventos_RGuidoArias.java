
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

        // Tabla tabla1 = new Tabla();
        //
        // tabla1.setVisible(true);
        // tabla1.setSize(400,500);
        // tabla1.setLocation(500,400);
        // tabla1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Manejador e = new Manejador();
        e.setVisible(true);
        e.setSize(500, 700);
        e.setLocationRelativeTo(null);
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
