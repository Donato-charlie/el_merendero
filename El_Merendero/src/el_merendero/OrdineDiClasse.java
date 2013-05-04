/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import java.util.Calendar;

/**
 *
 * @author b11g12
 */
public class OrdineDiClasse {

    private Calendar data;
    private String classe;
    private Ordine ordine;
    private OrdineDiClasse next;

    public OrdineDiClasse(String nomeclasse){
        classe = nomeclasse;
    }
    /**
     * Costruttore che definisce le variabili della classe OrdineDiClasse
     * 
     * @param ordine 
     */
    public OrdineDiClasse(Ordine ordine) {
        this.ordine = null;
        this.next = new OrdineDiClasse();
        this.next.ordine = ordine;
    }

    public OrdineDiClasse() {
        next=null;
    }
/**
     * Metodo per aggiungere un Ordine a un'OrdineDiClasse
     * 
     * @param o 
     */
    public void add(Ordine o) {
        OrdineDiClasse comodo = this;
        while (comodo.getNext() != null) {
            comodo = comodo.getNext();
        }
        comodo.setNext(new OrdineDiClasse());
        comodo.getNext().setOrdine(o);
    }
/**
     * Getter di default della variabile next
     * 
     * @return next
     */
    public OrdineDiClasse getNext() {
        return next;
    }
/**
     * Getter di default della variabile ordine
     * 
     * @return ordine
     */
    public Ordine getOrdine() {
        return ordine;
    }
/**
     * Setter di default
     * 
     * @param o 
     */
    public void setOrdine(Ordine o) {
        this.ordine = o;
    }
/**
     * Setter di default
     * 
     * @param next 
     */
    public void setNext(OrdineDiClasse next) {
        this.next = next;
    }

    /*
     * Getter della data dell'ordine
     * 
     */
    public Calendar getData() {
        return data;
    }
    
    /*
     * Setter della data dell'ordine
     * @param data
     */
    public void setData(Calendar data) {
        this.data = data;
    }
    
/**
     * Getter di default
     * 
     * @return tot
     */
    public float getTotale() {
        OrdineDiClasse comodo = this.next;
        float tot = 0f;
        while (comodo != null) {
            tot += comodo.getOrdine().getMerendeOrdinate().getTotale();
            comodo = comodo.getNext();
        }
        return tot;
    }
/**
     * Metodo che restituisce una stringa che contiene l'ordine
     * 
     * @return 
     */
    @Override
    public String toString() {
        String s = data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE) + " " + data.get(Calendar.DATE) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR)+"\n";
        OrdineDiClasse comodo = this.next;
        while (comodo != null) {
            s += " Ordine: " + comodo.ordine + "\n";
            comodo = comodo.next;
        }
        return s;
    }
}