/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;
import javax.swing.*;

/**
 *
 * @author b11g8
 */
public class El_Merendero {

    /**
     * Applicazione creata da Cagrandi,Bosi,Nizzoli,Galanti;
     * Applicazione riguardante la grafica del progetto.
     * Contiene un form iniziale con il concept della pagina iniziale con selezione ordine e classe.
     * 
     */
    public static void main(String[] args) {
        Frame fr=new Frame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(800, 600);
        fr.setLocationRelativeTo(null);
        
        SplashScreenMerendero splash = new SplashScreenMerendero(fr);
        splash.setSize(700,438);
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);
    }
}