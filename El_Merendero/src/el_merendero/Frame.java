/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author Nizzoli,Cagrandi,Galanti,Bosi 
 * 
 * Classe contentente gli attributi del
 * form iniziale: inclusi barre menù,elementi del menù,Bottoni label e Combo
 * box.
 */
public class Frame extends JFrame {

    private JPanel ordine;
    private JPanel anteStampa;
    JMenuBar jmb = new JMenuBar();          //riguardo alla barra menu superiore;
    JMenu menuFile = new JMenu("File");
    JMenu menuEdit = new JMenu("Modifica");
    JMenu menuView = new JMenu("Visualizza");
    JMenu menuHelp = new JMenu("?");
    JMenuItem FileItemNew = new JMenuItem("Crea Nuovo Ordine");
    JMenuItem FileItemSave = new JMenuItem("Salva Ordine");
    JMenuItem FileItemSaveWName = new JMenuItem("Salva Ordine Con Nome");
    JMenuItem FileItemOpen = new JMenuItem("Apri Ordine");
    JMenuItem FileItemPrint = new JMenuItem("Stampa Ordine");
    JMenuItem FileItemExit = new JMenuItem("Esci");
    JMenuItem HelpItemAbout = new JMenuItem("About");
    JMenuItem HelpItemGuide = new JMenuItem("Guida");
    JMenuItem ViewItemPreview = new JMenuItem("Anteprima Di Stampa");
    Box LayoutMenu = Box.createHorizontalBox();
    private JButton ordineClasse = new JButton("Ordine di classe");
    private JButton ordineSingolo = new JButton("Ordine singolo");
    private JLabel lblStampa = new JLabel("Anteprima di stampa:");
    private JLabel lblStato;
    private JComboBox combo;

    /**
     * Metodo Costruttore del form iniziale. 
     * Contiene le varie definizioni delle proprietà specifiche degli elementi in esso contenuti (nel form), 
     * le varie indicazioni il loro posizionamento ed altre aggiunte prestazionali come le scelte rapide 
     * (macro di tasti esempio Ctrl - s permette di stampare senza dover cliccare sul menu)
     */
    public Frame() {
        super("El merendero");
        setLayout(new BorderLayout());
        String[] testo = {"Ciao", "pùw", "agagga"};
        combo = new JComboBox(testo);
        lblStato = new JLabel("Sposta il mouse su un componente per avere le sue caretteristiche");
        add(lblStato, BorderLayout.SOUTH);
        lblStato.setBorder(BorderFactory.createLineBorder(Color.black));
        Box horizontal = Box.createHorizontalBox();
        horizontal.add(Box.createHorizontalGlue());
        horizontal.add(ordineClasse);
        horizontal.add(Box.createRigidArea(new Dimension(100, 8)));
        horizontal.add(ordineSingolo);
        horizontal.add(Box.createRigidArea(new Dimension(100, 8)));
        horizontal.add(combo);
        ordine = new JPanel();
        anteStampa = new JPanel();
        ordine.add(horizontal);
        ordine.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        anteStampa.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        anteStampa.add(lblStampa);
        add(ordine, BorderLayout.CENTER);
        add(anteStampa, BorderLayout.EAST);
        anteStampa.setVisible(false);
        menuFile.setMnemonic('F');
        menuEdit.setMnemonic('M');
        menuView.setMnemonic('V');
        jmb.add(menuFile);
        menuFile.add(FileItemNew);
        FileItemNew.setMnemonic('N');
        FileItemNew.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
        FileItemNew.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(Frame.this, "Creazione nuovo ordine", "Crea Nuovo Ordine", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
        menuFile.add(FileItemSave);
        FileItemSave.setMnemonic('S');
        FileItemSave.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
        FileItemSave.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(Frame.this, "Salvataggio dell'ordine corrente", "Salva", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
        menuFile.add(FileItemSaveWName);
        FileItemSaveWName.setMnemonic('C');
        FileItemSaveWName.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));
        FileItemSaveWName.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(Frame.this, "Salvataggio dell'ordine corrente, specificando il nome", "Salva con nome", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
        menuFile.add(FileItemOpen);
        FileItemOpen.setMnemonic('A');
        FileItemOpen.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
        FileItemOpen.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(Frame.this, "Apertura ordine precedentemente salvato", "Apri", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
        menuFile.add(FileItemPrint);
        FileItemPrint.setMnemonic('P');
        FileItemPrint.setAccelerator(KeyStroke.getKeyStroke('P', InputEvent.CTRL_DOWN_MASK));
        FileItemPrint.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(Frame.this, "Stampa l'ordine corrente", "Stampa", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
        menuFile.add(FileItemExit);
        FileItemExit.setMnemonic('E');
        FileItemExit.setAccelerator(KeyStroke.getKeyStroke('E', InputEvent.CTRL_DOWN_MASK));
        FileItemExit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
        jmb.add(menuEdit);
        menuEdit.add(" ");
        jmb.add(menuView);
        menuView.add(ViewItemPreview);
        ViewItemPreview.setMnemonic('A');
        ViewItemPreview.setAccelerator(KeyStroke.getKeyStroke('A', InputEvent.CTRL_DOWN_MASK));
        ViewItemPreview.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (anteStampa.isVisible()) {
                            anteStampa.setVisible(false);
                        } else {
                            anteStampa.setVisible(true);
                        }
                    }
                });
        jmb.add(menuHelp);
        menuHelp.add(HelpItemGuide);
        HelpItemGuide.setMnemonic('G');
        HelpItemGuide.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(Frame.this, "Mostra una breve guida su come utilizzare il programma", "Guida", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
        menuHelp.add(HelpItemAbout);
        HelpItemAbout.setMnemonic('B');
        HelpItemAbout.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(Frame.this, "El Merendero si occupa della gestione e distribuzioni di un vasto assortimento di alimenti.\nTutto nasce per la necessita' comune di avere a disposizione un ordine real-time , delle merende , \nper quando si hanno verifiche e non si e' in grado di provvedere autonomamente all'acquisto di tali generi.", "About", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
        setJMenuBar(jmb);
        HoverListener ls = new HoverListener();
        ordineClasse.addMouseListener(ls);
        ordineSingolo.addMouseListener(ls);
    }
    //--------------Hover Effect-------------------------
/**
 * Classe implementante l'interfaccia di ascolto dei comandi Mouse ;
 * 
 */
    private class HoverListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            lblStato.setText(lblStato.getText());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            lblStato.setText(lblStato.getText());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            lblStato.setText(lblStato.getText());
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == ordineClasse) {
                lblStato.setText("Premi per creare un ordine di classe");
            }
            if (e.getSource() == ordineSingolo) {
                lblStato.setText("Premi per creare un ordine singolo");
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            lblStato.setText("Sposta il mouse su un componente per avere le sue caretteristiche");
        }
    }
    //-----------------End Hover Effect----------------------
}