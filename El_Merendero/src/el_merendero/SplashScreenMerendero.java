/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;

/**
 *
 * @author b11g7
 */
public class SplashScreenMerendero extends JWindow {

    JProgressBar pg = new JProgressBar(0,100);
    Timer timer;
    int times = 0;
    final int MAX = 100;
    
    public SplashScreenMerendero(final Frame f){
        pg.setBorderPainted(true);
        pg.setForeground(Color.green);
        
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                times++;
                pg.setValue(times);
                if ( pg.getValue() == MAX ) {
                    dispose();
                    timer.stop();
                    
                    f.setVisible(true);  
                }
            }
        });
        timer.start();
        
        setLayout(new BorderLayout());
        ImageIcon img = new ImageIcon("images/splash.jpg"); 
        
        JLabel label = new JLabel(img);
        //TODO: Setbackground
        add(label,BorderLayout.CENTER);
        add(pg,BorderLayout.SOUTH);
    }
}
