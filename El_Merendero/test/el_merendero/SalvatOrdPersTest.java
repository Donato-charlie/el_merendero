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
public class SalvatOrdPersTest {
    
    public SalvatOrdPersTest() {
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
     * Test of Salvataggio method, of class SalvatOrdPers.
     */
    @Test
    public void testSalvataggio() {
        System.out.println("Salvataggio Persone");        
        Ordine prova1=new Ordine("Simone");
        prova1.add(new Merenda("panino",2f,1));
        prova1.add(new Merenda("pizza",1.5f,3));
        prova1.add(new Merenda("pizza",1.5f,1));
        SalvatOrdPers.Salvataggio(prova1);
        //TODO Il nome deve dipendere dal nome della persona (e della data)
        assertTrue(new File("./config/ordini/OrdinePers.txt").exists());
        //TODO Controllare il contenuto del file
        
    }

   
}
