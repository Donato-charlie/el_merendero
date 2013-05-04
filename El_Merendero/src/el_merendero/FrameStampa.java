/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author piffy
 */
public class FrameStampa extends JFrame{

    JButton Aggiungi=new JButton("Aggiungi");
    JButton Elimina = new JButton("Rimuovi");
    //Image LogoBar =  new ImageIcon(this.getClass().getResource("Logo2.jpg")).getImage();
    
    public FrameStampa() {
     super("Stampa in corso...");
     setLayout(new FlowLayout());
     add(Aggiungi);
     add(Elimina);
     //add(LogoBar);
     
     
     
     
     
     
   
     
 } 
}
