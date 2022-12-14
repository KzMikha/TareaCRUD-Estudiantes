package Model;

/**
 *
 * @author Erick
 */

import View.Pantalla;


public class Ventana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });
    }
    
}