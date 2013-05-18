/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Eddy
 */
public class OrdineDiClasseTest {

    /**
     * Test of constructor, of class OrdineDiClasse.
     */
    @Test
    public void testCostructor() {
        try {
            OrdineDiClasse odc = new OrdineDiClasse();
        } catch (Exception e) {
            assertEquals("Test per il costruttore.", "L'ordine deve contenere il nome della classe.", e.getMessage());
        }
    }

    /**
     * Test of getTotale method, of class OrdineDiClasse.
     */
    @Test
    public void testGetTotale() {
        OrdineDiClasse odc = new OrdineDiClasse("4B Info");
        Merenda m = new Merenda("Panino 1", 4.3f);
        Ordine o = new Ordine("Manfredini");
        o.add(m);
        odc.add(o);
        o = new Ordine("Eddy");
        o.add(new Merenda("Panino 2", 5.6f));
        odc.add(o);
        Float expected = 9.9f;
        assertEquals("Test per il totale dell'ordine", expected, odc.getTotale(), 0.001);
    }

    /**
     * Test of toString method, of class OrdineDiClasse.
     */
    @Test
    public void testToString() {
        OrdineDiClasse odc = new OrdineDiClasse("4B Info");
        Merenda m = new Merenda("Panino 1", 4.3f);
        Ordine o = new Ordine("Manfredini");
        o.add(m);
        odc.add(o);
        o = new Ordine("Eddy");
        m = new Merenda("Panino 2", 5.6f);
        o.add(m);
        odc.add(o);
        System.out.println(odc.toString());
        String expected = "4B Info\nOrdine: Manfredini\n1x Panino 1 - 4.3€\n\nOrdine: Eddy\n1x Panino 2 - 5.6€\n\n";
        assertEquals("Test per l'ordine di classe", expected, odc.toString());
    }
}
