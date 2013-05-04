/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

/**
 *
 * @author b11g12
 */
public class Ordine {

    private String NomeAcquirente;
    private float SoldiForniti;
    private Listamerende MerendeOrdinate;
    private float resto;

    public float getResto() {
        return resto;
    }

    public void setResto() {
        if (this.ControlloGiustoImporto()) {
            resto = (float) SoldiForniti - MerendeOrdinate.getTotale();
        }
    }

    public boolean ControlloGiustoImporto() {
        if (SoldiForniti < MerendeOrdinate.getTotale()) {
            return false;
        } else {
            return true;
        }
    }

    public Ordine(String NomeAcquirente) {
        this.NomeAcquirente = NomeAcquirente;
        MerendeOrdinate = new Listamerende();
    }

    public Listamerende getMerendeOrdinate() {
        return MerendeOrdinate;
    }

    public void setMerendeOrdinate(Listamerende MerendeOrdinate) {
        this.MerendeOrdinate = MerendeOrdinate;
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

    @Override
    public String toString() {
        return NomeAcquirente + "\n" + MerendeOrdinate;
    }
    
}
