/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

/**
 *
 * @author b11g12
 */
public class Merenda {

    private String nome;
    private float prezzo;
    private int numero;
    private boolean condimenti[];

    public Merenda(String nome, float prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
        numero=1;
    }

    public Merenda(String nome, float prezzo, int numero) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.numero = numero;
    }

    public Merenda(String nome, float prezzo, int numero, boolean[] condimenti) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.numero = numero;
        this.condimenti = condimenti;
    }

    public boolean[] getCondimenti() {
        return condimenti;
    }

    public void setCondimenti(boolean[] condimenti) {
        this.condimenti = condimenti;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
