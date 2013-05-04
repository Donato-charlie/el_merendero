/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import el_merendero.Listamerende;
import el_merendero.Merenda;
import el_merendero.Ordine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author piffy
 */
public class MerendaTest {
    
  @Test
    public void testAdd() {
        Listamerende prova = new Listamerende();
        prova.add(new Merenda(2.5f, "panino"));
        assertEquals("panino", prova.getNext().getProdotto().getNome());
        assertEquals(2.5f, 0.1, prova.getNext().getProdotto().getPrezzo());
    }

    @Test
    public void testRemove() {
        Listamerende prova = new Listamerende();
        prova.add(new Merenda(2.5f, "panino"));
        prova.add(new Merenda(1.5f, "focaccia"));
        prova.remove("panino");
        assertEquals("focaccia", prova.getNext().getProdotto().getNome());
        assertEquals(1.5f, 0.1, prova.getNext().getProdotto().getPrezzo());
    }

    @Test
    public void testGetTotale() {
        Listamerende prova = new Listamerende();
        prova.add(new Merenda(2.5f, "panino"));
        prova.add(new Merenda(1.5f, "focaccia"));
        assertEquals(4f, 0.1, prova.getTotale());
    }

    @Test
    public void testSetResto() {
        Ordine prova = new Ordine("Paolo");
        prova.getMerendeOrdinate().add(new Merenda(2.5f, "panino"));
        prova.getMerendeOrdinate().add(new Merenda(1.5f, "focaccia"));
        prova.setSoldiForniti(10f);
        prova.setResto();
        assertEquals(6f, 0.1, prova.getResto());
    }

    @Test
    public void ControlloGiustoImporto() {
        Ordine prova = new Ordine("Simone");
        prova.getMerendeOrdinate().add(new Merenda(2.5f, "panino"));
        prova.getMerendeOrdinate().add(new Merenda(1.5f, "focaccia"));
        prova.setSoldiForniti(10f);
        assertEquals(true,prova.ControlloGiustoImporto());
    }
}
