/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b11g12
 */
public class ListaMerendeAll extends Listamerende {

    private String prodotti[] /*= {"Bombolone", "Panino al salame"}*/;
    private float prezzi[] /*= {0.90f, 1.30f}*/;

    public ListaMerendeAll() throws FileNotFoundException {
        int i = 0;
        int j=0;
        int k=0;
        String s;
        prodotti = new String[8];
        prezzi = new float[8];
        BufferedReader reader = new BufferedReader(new FileReader("merende.txt"));
        try {
            while ((s = reader.readLine()) != null) {
                if (i % 2 != 0) {
                    prezzi[j] = Float.parseFloat(s);
                    j++;
                } else {
                    prodotti[k] = s;
                    k++;
                }
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(ListaMerendeAll.class.getName()).log(Level.SEVERE, null, ex);
        }
        Listamerende comodo = this;
        for (i = 0; i < prodotti.length; i++) {
            comodo = new Listamerende(new Merenda(prezzi[i], prodotti[i]));
            comodo = comodo.getNext();
        }
    }

    public float[] getPrezzi() {
        return prezzi;
    }

    public void setPrezzi(float[] prezzi) {
        this.prezzi = prezzi;
    }

    public String[] getProdotti() {
        return prodotti;
    }

    public void setProdotti(String[] prodotti) {
        this.prodotti = prodotti;
    }
}
