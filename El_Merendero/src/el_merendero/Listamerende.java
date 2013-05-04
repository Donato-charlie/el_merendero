/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

/**
 *
 * @author b11g12
 */
public class Listamerende {

    protected Merenda prodotto;
    protected Listamerende next;

    public Listamerende(Merenda prodotto) {
        this.prodotto = null;
        this.next = new Listamerende();
        this.next.prodotto = prodotto;
    }

    public Listamerende() {
        next=null;
    }

    public void add(Merenda m) {
        Listamerende comodo = this;
        while (comodo.getNext() != null) {
            comodo = comodo.getNext();
        }
        comodo.setNext(new Listamerende());
        comodo.getNext().setProdotto(m);
    }

    public Listamerende getNext() {
        return next;
    }

    public Merenda getProdotto() {
        return prodotto;
    }

    public void setProdotto(Merenda prodotto) {
        this.prodotto = prodotto;
    }

    public void setNext(Listamerende next) {
        this.next = next;
    }

    public void remove(String s) {
        Listamerende indice = this;
        
        for (indice = this; !indice.getNext().getProdotto().getNome().equals(s); indice = indice.getNext()) {
            if (indice.getNext() == null) {
                return;
            }
        }
        indice.setNext(indice.getNext().getNext());
    }

    public float getTotale() {
        Listamerende comodo = this.next;
        float tot = 0f;
        while (comodo != null) {
            tot += comodo.getProdotto().getPrezzo();
            comodo = comodo.getNext();
        }
        return tot;
    }

    @Override
    public String toString() {
        String s = "";
        Listamerende comodo = this.next;
        while (comodo != null) {
            s += "Nome = " + comodo.prodotto.getNome() + "  Prezzo = " + comodo.prodotto.getPrezzo() + "\n";
            comodo = comodo.next;
        }
        return s;
    }
}
