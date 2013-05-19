/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import java.io.File;
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
public class SalvatOrdClasTest {
    
    public SalvatOrdClasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Salvataggio method, of class SalvatOrdClas.
     */
    @Test
    public void testSalvataggio() {
 
        OrdineDiClasse prova1 = new OrdineDiClasse("4B INFO");
        Ordine p1 = new Ordine("Simone");
        Ordine p2 = new Ordine("Mattia");
        Ordine p3 = new Ordine("Edoardo");
        p1.add(new Merenda("panino", 2f, 1));
        p1.add(new Merenda("cotoletta", 5f, 4));
        p2.add(new Merenda("pizza", 1.5f, 3));
        p3.add(new Merenda("pizza", 1.5f, 1));
        prova1.add(p1);
        prova1.add(p2);
        prova1.add(p3);
        SalvatOrdClas.Salvataggio(prova1);
        System.out.println("Salvataggio");
        OrdineDiClasse p = null;
        SalvatOrdClas.Salvataggio(p);
        assertTrue(new File("./config/ordini/OrdineClas.txt").exists());
        //TODO: Controllare che il contenuto sia adatto 

        
        
    }

}
