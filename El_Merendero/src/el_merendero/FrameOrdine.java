/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;

/**
 *
 * @author b11g8
 */
public class FrameOrdine extends JFrame{
         
    JPanel panel=new JPanel();
    JRadioButton rdbPanini[];
    JTextField txtPanini[];
    JButton cmdPaniniDone[];
    JButton cmdPaniniPiu[];
    JButton cmdPaniniMeno[];
    JCheckBox ckbPaniniMaio[];
    JCheckBox ckbPaniniKetchup[];
    OrdineDiClasse ordine;
    JLabel lblPanini[];
    String names[];
    float prezzi[];
    ButtonGroup group = new ButtonGroup();
    int x=20,y=0;
    
    public FrameOrdine(String classe,String studente) throws FileNotFoundException{
        
        super("Ordina la tua merenda");
        
        panel.setLayout(null);
        JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollBar);
        ordine=new OrdineDiClasse(classe);
        ordine.add(new Ordine(studente));
        ListaMerendeAll lma=new ListaMerendeAll();
        names=lma.getProdotti();
        prezzi=lma.getPrezzi();
        int n=names.length;
        rdbPanini= new JRadioButton[n];
        txtPanini=new JTextField[n];
        cmdPaniniDone=new JButton[n];
        cmdPaniniPiu=new JButton[n];
        cmdPaniniMeno=new JButton[n];
        ckbPaniniMaio=new JCheckBox[n];
        ckbPaniniKetchup=new JCheckBox[n];
        lblPanini=new JLabel[n];
        //Inizializzazione varie proprietà grafiche
        
        this.setFont(new Font("Segoe UI",Font.PLAIN,20));
        Gestore al=new Gestore();
        CambiaQuantita aq=new CambiaQuantita();
        OperazioneEseguita oe=new OperazioneEseguita();
        
        //Inserimento dei componenti per la gestione dell'ordine
        
        for(int i=0;i<rdbPanini.length;i++){
            
            rdbPanini[i]=new JRadioButton(names[i]);
            cmdPaniniPiu[i]=new JButton("+");
            cmdPaniniMeno[i]=new JButton("-");
            txtPanini[i]=new JTextField("1");
            lblPanini[i]=new JLabel("Prezzo : "+prezzi[i]);
            cmdPaniniDone[i]=new JButton("Fatto");
            ckbPaniniMaio[i]=new JCheckBox("Maio");
            ckbPaniniKetchup[i]=new JCheckBox("Ketchup");
            
            rdbPanini[i].setFont(new Font("Segoe UI",Font.PLAIN,15));
            txtPanini[i].setFont(new Font("Segoe UI",Font.PLAIN,15));
            lblPanini[i].setFont(new Font("Segoe UI",Font.PLAIN,15));
            cmdPaniniDone[i].setFont(new Font("Segoe UI",Font.PLAIN,15));
            ckbPaniniMaio[i].setFont(new Font("Segoe UI",Font.PLAIN,15));
            ckbPaniniKetchup[i].setFont(new Font("Segoe UI",Font.PLAIN,15));
            
            group.add(rdbPanini[i]);
            rdbPanini[i].addActionListener(al);
            cmdPaniniPiu[i].addActionListener(aq);
            cmdPaniniMeno[i].addActionListener(aq);
            cmdPaniniDone[i].addActionListener(oe);
            
            rdbPanini[i].setBounds(new Rectangle(new Point(1, 1), rdbPanini[i].getPreferredSize()));
            cmdPaniniPiu[i].setBounds(new Rectangle(new Point(1, 1), cmdPaniniPiu[i].getPreferredSize()));
            cmdPaniniMeno[i].setBounds(new Rectangle(new Point(1, 1), cmdPaniniMeno[i].getPreferredSize()));
            txtPanini[i].setBounds(new Rectangle(new Point(1, 1), txtPanini[i].getPreferredSize()));
            lblPanini[i].setBounds(new Rectangle(new Point(1, 1), lblPanini[i].getPreferredSize()));
            cmdPaniniDone[i].setBounds(new Rectangle(new Point(1, 1), cmdPaniniDone[i].getPreferredSize()));
            ckbPaniniMaio[i].setBounds(new Rectangle(new Point(1, 1), ckbPaniniMaio[i].getPreferredSize()));
            ckbPaniniKetchup[i].setBounds(new Rectangle(new Point(1, 1), ckbPaniniKetchup[i].getPreferredSize()));
            
            rdbPanini[i].setLocation(x,y+=60);
            cmdPaniniPiu[i].setLocation(rdbPanini[i].getX()+300, rdbPanini[i].getY()+3);
            cmdPaniniMeno[i].setLocation(cmdPaniniPiu[i].getX()+45, rdbPanini[i].getY()+3);
            txtPanini[i].setLocation(cmdPaniniMeno[i].getX()+100,rdbPanini[i].getY()+3);
            lblPanini[i].setLocation(txtPanini[i].getX()+50, rdbPanini[i].getY()+3);
            cmdPaniniDone[i].setLocation(lblPanini[i].getX()+100, rdbPanini[i].getY());
            ckbPaniniMaio[i].setLocation(rdbPanini[i].getX()+20,rdbPanini[i].getY()+30);
            ckbPaniniKetchup[i].setLocation(ckbPaniniMaio[i].getX()+100,ckbPaniniMaio[i].getY());
            
            cmdPaniniPiu[i].setSize(45, 25);
            cmdPaniniMeno[i].setSize(45, 25);
            txtPanini[i].setSize(30, 25);
            
            cmdPaniniPiu[i].setVisible(false);
            cmdPaniniMeno[i].setVisible(false);
            txtPanini[i].setVisible(false);
            lblPanini[i].setVisible(false);
            cmdPaniniDone[i].setVisible(false);
            ckbPaniniMaio[i].setVisible(false);
            ckbPaniniKetchup[i].setVisible(false);
            
            panel.add(rdbPanini[i]);
            panel.add(cmdPaniniPiu[i]);
            panel.add(cmdPaniniMeno[i]);
            panel.add(txtPanini[i]);
            panel.add(lblPanini[i]);
            panel.add(cmdPaniniDone[i]);
            panel.add(ckbPaniniMaio[i]);
            panel.add(ckbPaniniKetchup[i]);
        }
        
    }
    
    private class Gestore implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for(int k=0;k<rdbPanini.length;k++){
                if(rdbPanini[k].isSelected()){
                    cmdPaniniPiu[k].setVisible(true);
                    cmdPaniniMeno[k].setVisible(true);
                    txtPanini[k].setVisible(true);
                    lblPanini[k].setVisible(true);
                    cmdPaniniDone[k].setVisible(true);
                    ckbPaniniMaio[k].setVisible(true);
                    ckbPaniniKetchup[k].setVisible(true);
                }
                else{
                    cmdPaniniPiu[k].setVisible(false);
                    cmdPaniniMeno[k].setVisible(false);
                    txtPanini[k].setVisible(false);
                    lblPanini[k].setVisible(false);
                    cmdPaniniDone[k].setVisible(false);
                    ckbPaniniMaio[k].setVisible(false);
                    ckbPaniniKetchup[k].setVisible(false);
                    ckbPaniniMaio[k].setSelected(false);
                    ckbPaniniKetchup[k].setSelected(false);
                    txtPanini[k].setText("1");
                }
            }
        }
        
    }
    
    private class CambiaQuantita implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int i=0;
            for(int k=0;k<rdbPanini.length;k++){
                if(rdbPanini[k].isSelected())
                    i=k;
            }
            if(e.getActionCommand()=="+"){
                int val=Integer.parseInt(txtPanini[i].getText());
                val++;
                txtPanini[i].setText(""+val);
            }
            else{
                if(Integer.parseInt(txtPanini[i].getText())>1){
                    int val=Integer.parseInt(txtPanini[i].getText());
                    val--;
                    txtPanini[i].setText(""+val);
                }
            }
        }
        
    }
    
    private class OperazioneEseguita implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int k=0;
            for(int i=0;i<rdbPanini.length;i++){
                rdbPanini[i].setSelected(false);
                cmdPaniniPiu[i].setVisible(false);
                cmdPaniniMeno[i].setVisible(false);
                txtPanini[i].setVisible(false);
                lblPanini[i].setVisible(false);
                cmdPaniniDone[i].setVisible(false);
                ckbPaniniMaio[i].setVisible(false);
                ckbPaniniKetchup[i].setVisible(false);
                ckbPaniniMaio[i].setSelected(false);
                ckbPaniniKetchup[i].setSelected(false);
                txtPanini[i].setText("1");
            }
            for(int i=0;i<rdbPanini.length;i++){
                if(rdbPanini[i].isSelected())
                    k=i;
            }
            boolean cond[]={ckbPaniniMaio[k].isSelected(),ckbPaniniKetchup[k].isSelected()};
            Merenda m = new Merenda(names[k],prezzi[k],Integer.parseInt(txtPanini[k].getText()),cond);
            ordine.getFirst().add(m);
            System.out.println(m.getNome());
        }
        
    }
  
    
    
     public static void main(String[] args) throws FileNotFoundException {
        FrameOrdine fr=new FrameOrdine("5Binfo","Donato");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(1000, 600);
        //fr.setResizable(false);
        fr.setVisible(true);
    }
    
    
}