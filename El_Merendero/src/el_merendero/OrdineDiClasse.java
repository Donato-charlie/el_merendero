/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author b11g12
 */
public class OrdineDiClasse extends LinkedList<Ordine> {

    private String classe;
    private String aula;
    private Calendar data;

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        String s = classe + "\n";
        for (Ordine o : this) {
            s += "Ordine: " + o ;
            s += "--------------------\n";
        }
        return s;
    }
}
