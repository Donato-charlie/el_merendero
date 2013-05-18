/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Eddy, Manfredini, Bigliardi
 * @version 0.01
 */
public class Stampante implements Printable {

    private final int MARGINE = 150;
    private final int MARGINE_DESTRO = 500;
    private final int SPAZIATURA = 15;
    private LinkedList<String> merende;
    private LinkedList<Integer> numeri;
    private LinkedList<Float> prezzi;
    private Image image1;
    private Image image2;
    private String classe;
    private String aula;
    private Calendar data;
    private float soldiForniti;

    /**
     * Costruttore di default che istanzia le liste e carica il logo
     */
    public Stampante() {
        merende = new LinkedList<String>();
        numeri = new LinkedList<Integer>();
        prezzi = new LinkedList<Float>();
        image1 = new ImageIcon(this.getClass().getResource("Logo.jpg")).getImage();
    }

    /**
     * Metodo che genera il layout della pagina da stampare
     * @param g Layout della pagina
     * @param pf Formato della pagina
     * @param page Numero di pagine
     * @return una costante che indica alla stampante quando deve finire
     */
    @Override
    public int print(Graphics g, PageFormat pf, int page) {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        g.drawImage(image1, 50, 20, null);
        image2 = new ImageIcon(this.getClass().getResource("Logo2.jpg")).getImage();
        g.drawImage(image2, 215, 20, null);

        FontMetrics fm = g.getFontMetrics();
        String appoggio;
        appoggio = "Classe " + classe;
        g.drawString(appoggio, MARGINE_DESTRO - fm.stringWidth(appoggio), 50);
        appoggio = data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE) + " " + data.get(Calendar.DATE) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR);
        g.drawString(appoggio, MARGINE_DESTRO - fm.stringWidth(appoggio), 65);
        appoggio = "Aula " + aula;
        g.drawString(appoggio, MARGINE_DESTRO - fm.stringWidth(appoggio), 80);

        float totale = 0;
        int i;
        for (i = 0; i < merende.size(); i++) {
            appoggio = prezzi.get(i) + " €";
            g.drawString(appoggio, MARGINE_DESTRO - fm.stringWidth(appoggio), 120 + SPAZIATURA * i);
            int lungi = fm.stringWidth(appoggio);
            appoggio =  numeri.get(i)+" - "+merende.get(i);
            while ( MARGINE_DESTRO - MARGINE - fm.stringWidth(appoggio) - lungi > 10) {
                appoggio+=".";
            }
            g.drawString(appoggio, MARGINE, 120 + SPAZIATURA * i);
            totale += prezzi.get(i);
        }
        g.setFont(new Font("suns", Font.BOLD, 12));
        appoggio = "Totale: " + totale + " €";
        g.drawString(appoggio, MARGINE_DESTRO - fm.stringWidth(appoggio), 120 + SPAZIATURA * i);
        appoggio = "Soldi forniti: " + soldiForniti + " €";
        g.drawString(appoggio, MARGINE_DESTRO - fm.stringWidth(appoggio) - 5, 140 + SPAZIATURA * i);
        appoggio = "Resto: " + (soldiForniti - totale) + " €";
        g.drawString(appoggio, MARGINE_DESTRO - fm.stringWidth(appoggio), 160 + SPAZIATURA * i);

        return PAGE_EXISTS;
    }

    /**
     * Metodo che aggiunge una merenda all'ordine
     * @param merenda Nome della merenda
     * @param prezzo Prezzo della merenda
     */
    public void add(String merenda,int numero, float prezzo) {
        merende.add(merenda);
        numeri.add(numero);
        prezzi.add(prezzo);
    }

    /**
     * Metodo obbligatorio che aggiunge il nome della classe all'ordine
     * @param classe Nome della classe
     */
    public void addClasse(String classe) {
        this.classe = classe;
    }

    /**
     * Metodo obbligatorio che aggiunge il l'ora della consegna all'ordine
     * @param data Giorno e ora della consegna dell'ordine
     */
    public void addData(GregorianCalendar data) {
        this.data = data;
    }

    /**
     * Metodo obbligatorio che aggiunge l'aula della consegna all'ordine
     * @param aula Aula della consegna
     */
    public void addAula(String aula) {
        this.aula = aula;
    }

    /**
     * Metodo obbligatorio che aggiunge i soldi forniti all'ordine
     * @param soldiForniti valore float dei soldi forniti
     */
    public void addSoldiForniti(float soldiForniti) {
        this.soldiForniti = soldiForniti;
    }

    void print() throws PrinterException {
        if (classe == null) {
            JOptionPane.showMessageDialog(null, "Speficiare una classe prima della stampa", "Classe", 2);
            return;
        }
        if (data == null) {
            JOptionPane.showMessageDialog(null, "Speficiare una data prima della stampa", "Data", 2);
            return;
        }
        if (aula == null) {
            JOptionPane.showMessageDialog(null, "Speficiare un'aula prima della stampa", "Aula", 2);
            return;
        }
        if (soldiForniti == 0) {
            JOptionPane.showMessageDialog(null, "Speficiare i soldi forniti prima della stampa", "Soldi Forniti", 2);
            return;
        }
        if (merende.size() == 0) {
            JOptionPane.showMessageDialog(null, "Speficiare una merenda prima della stampa", "Merenda", 2);
            return;
        }
        // Creates and returns a PrinterJob which is initially associated with the default printer.
        PrinterJob pj = PrinterJob.getPrinterJob();
        // Sets the name of the document to be printed.
        pj.setJobName("TestStampa");
        // Presents a dialog to the user for changing the properties of the print job.
        pj.printDialog();
        // Calls painter to render the pages.
        pj.setPrintable(this);

        pj.print();

        classe = null;
        data = null;
        aula = null;
        soldiForniti = 0;
        merende.clear();
        prezzi.clear();
    }

    /**
     * Main di prova per la classe stampante
     * @param args the command line arguments
     * @throws PrinterException generata in caso di mancanza di stampante
     */
    public static void main(String[] args) throws PrinterException {
        Stampante st = new Stampante();
        GregorianCalendar d = new GregorianCalendar(2013, 11, 22, 23, 12);
        st.addData(d);
        st.addClasse("4B Info");
        st.addAula("216");
        st.addSoldiForniti(17.5f);
        st.add("Cotoletta",2, 5.80f);
        st.add("Hot-Dog",1, 1.20f);
        st.add("Forno",3, 3.00f);
        st.add("Piadina",4, 2.50f);
        st.print();
    }
}