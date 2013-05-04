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
   private float prezzo;
    private String nome;

    public Merenda(float prezzo, String nome) {
        this.prezzo = prezzo;
        this.nome = nome;
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
