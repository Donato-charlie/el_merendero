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
public class OrdineDiClasse extends LinkedList<Ordine> {

    private String classe;

    public OrdineDiClasse() throws Exception {
        throw new Exception("L'ordine deve contenere il nome della classe.");
    }

    public OrdineDiClasse(String nomeclasse) {
        classe = nomeclasse;
    }

    public float getTotale() {
        float tot = 0f;
        for (Ordine o : this) {
            tot += o.getTotale();
        }
        return tot;
    }

    @Override
    public String toString() {
        String s = classe + "\n";
        for (Ordine o : this) {
            s += "Ordine: " + o + "\n";
        }
        return s;
    }
}
