/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import java.util.LinkedList;

/**
 *
 * @author b11g12
 */
public class Ordine extends LinkedList<Merenda>{

    private String NomeAcquirente;
    private float SoldiForniti;
    private float resto;
   
    public float getResto() {
        return resto;
    }

    public void setResto() {
        if (this.ControlloGiustoImporto()) {
            resto = (float) SoldiForniti - getTotale();
        }
    }

    public boolean ControlloGiustoImporto() {
        if (SoldiForniti < getTotale()) {
            return false;
        } else {
            return true;
        }
    }

    public Ordine(String NomeAcquirente) {
        this.NomeAcquirente = NomeAcquirente;
    }

    public String getNomeAcquirente() {
        return NomeAcquirente;
    }

    public void setNomeAcquirente(String NomeAcquirente) {
        this.NomeAcquirente = NomeAcquirente;
    }

    public float getSoldiForniti() {
        return SoldiForniti;
    }

    public void setSoldiForniti(float SoldiForniti) {
        this.SoldiForniti = SoldiForniti;
    }

    public float getTotale() {
        float tot = 0f;
        for (Merenda m : this) {
            tot += m.getPrezzo();
        }
        return tot;
    }

    @Override
    public String toString() {
        String s = NomeAcquirente + "\n";
        for (Merenda m : this) {
            s += m + "\n";
        }
        return s;
    }
}
