/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Donato
 */
public class StudenteTest {
    
    public StudenteTest() {
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
     * Test of getNome_Cognome method, of class Studente.
     */
    @Test
    public void testGetNome_Cognome() {
        System.out.println("getNome_Cognome");
        Studente instance = new Studente("MARIANO GHIRO");
        String expResult = "MARIANO GHIRO";
        String result = instance.getNome_Cognome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome_Cognome method, of class Studente.
     */
    @Test
    public void testSetNome_Cognome() {
        System.out.println("setNome_Cognome");
        String Nome_Cognome = "MARIANO GHIRO";
        Studente instance = new Studente("MARIANO GHIRO");
        instance.setNome_Cognome(Nome_Cognome);
        assertEquals("MARIANO GHIRO",instance.getNome_Cognome());
    }
}
