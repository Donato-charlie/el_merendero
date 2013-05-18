/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author piffy
 */
public class MerendaTest {

    @Test
    public void testGetTotale() {
        Ordine prova = new Ordine("Brunelli");
        prova.add(new Merenda("panino", 2.5f));
        prova.add(new Merenda("focaccia", 1.5f));
        assertEquals(4f, 0.1f, prova.getTotale());
    }

    @Test
    public void testSetResto() {
        Ordine prova = new Ordine("Paolo");
        prova.add(new Merenda("panino", 2.5f));
        prova.add(new Merenda("focaccia", 1.5f));
        prova.setSoldiForniti(10f);
        prova.setResto();
        assertEquals(6f, 0.1, prova.getResto());
    }

    @Test
    public void ControlloGiustoImporto() {
        Ordine prova = new Ordine("Simone");
        prova.add(new Merenda("panino", 2.5f));
        prova.add(new Merenda("focaccia", 1.5f));
        prova.setSoldiForniti(10f);
        assertEquals(true, prova.ControlloGiustoImporto());
    }
}
