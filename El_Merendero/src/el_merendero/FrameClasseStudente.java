/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author charlie
 */
public class FrameClasseStudente extends JFrame {

    private JComboBox boxClassi;
    private JComboBox boxStudenti;
    private String nomiClassi[];
    private String nomiStudenti[];
    private final String Aule[] = {"Aula 121","Aula 214","Aula 123","Aula 244","Aula 221","Aula 414","Aula 231","Aula 214","Aula 121","Aula 214","Aula 121","Aula 214"};
    private JButton cmdFatto;
    private JButton cmdIndietro;
    private ListaClassiHardwired list;
    private JPanel Classi = new JPanel();
    private JPanel Studenti = new JPanel();
    private String Classe;
    private String Studente;
    private String Aula;
    private JComboBox AulaN;

    public FrameClasseStudente() {
        super("El_Merendero");

        setLayout(new BorderLayout());

        cmdFatto = new JButton("Fatto");
        cmdIndietro = new JButton("Indietro");

        list = new ListaClassiHardwired();

        nomiClassi = list.getNomiClassi();
        nomiStudenti = list.ListaStudentiXClasseData(nomiClassi[0]);
        Classe = nomiClassi[0];
        Aula = Aule[0];
        Studente = nomiStudenti[0];
        AulaN = new JComboBox(Aule);
        boxStudenti = new JComboBox(nomiStudenti); //set up JComboBox
        boxClassi = new JComboBox(nomiClassi); // set up JComboBox
        boxClassi.setMaximumRowCount(10);
        boxStudenti.setMaximumRowCount(15);
        Classi.add(boxClassi);
        Box vertical = Box.createVerticalBox();
        vertical.add(Classi);
        vertical.add(Box.createVerticalGlue());
        vertical.add(AulaN);
        add(vertical, BorderLayout.NORTH);
        Studenti.add(boxStudenti);
        add(Studenti, BorderLayout.CENTER);
        boxClassi.addItemListener(new ItemListener() {
            // handle JComboBox event
            @Override
            public void itemStateChanged(ItemEvent e) {
                // determine whether checkbox selected
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    nomiStudenti = list.ListaStudentiXClasseData(e.getItem().toString());
                    Classe = e.getItem().toString();
                    boxStudenti.removeAllItems();
                    for (int i = 0; i < nomiStudenti.length; i++) {
                        boxStudenti.addItem(nomiStudenti[i]);
                    }
                }
            } // end method itemStateChanged
        } // end anonymous inner class
                ); // end call to addItemListener
        boxStudenti.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Studente = e.getItem().toString();
                }
            }
        });
        AulaN.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Aula = e.getItem().toString();
                }
            }
        });
        Box horizontal = Box.createHorizontalBox();
        horizontal.add(cmdIndietro);
        horizontal.add(Box.createHorizontalGlue());
        horizontal.add(Box.createRigidArea(new Dimension(115, 8)));
        horizontal.add(cmdFatto);
        add(horizontal, BorderLayout.SOUTH);
        cmdIndietro.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        FrameClasseStudente.this.setVisible(false);
                        Frame fb = new Frame();
                        fb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        fb.setSize(800, 600); // set frame size
                        fb.setLocationRelativeTo(null); //center fr
                        fb.setVisible(true); // display frame	
                    }
                });
        cmdFatto.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            FrameClasseStudente.this.setVisible(false);
                            OrdineDiClasse odc = new OrdineDiClasse(Classe);
                            odc.add(new Ordine(Studente));
                            odc.setAula(Aula.substring(5));
                            FrameOrdineSingolo fb = new FrameOrdineSingolo(odc);
                            fb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            fb.setSize(800, 600); // set frame size
                            fb.setLocationRelativeTo(null); // display frame	
                            fb.setVisible(true); // display frame
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(FrameClasseStudente.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
    }
}
