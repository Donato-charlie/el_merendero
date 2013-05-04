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
public class ClasseTest {
    
    public ClasseTest() {
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
     * Test of Set_nomeClasse method, of class Classe.
     */
    @Test
    public void testSet_nomeClasse() {
        System.out.println("Set_nomeClasse");
        String nomefile = "5A-ELT.txt";
        Classe instance = new Classe(nomefile);
        instance.Set_nomeClasse(nomefile);
        assertEquals("5A-ELT",instance.getNomeClasse());
    }

    /**
     * Test of getNomiStudenti method, of class Classe.
     */
    @Test
    public void testGetNomiStudenti() {
        System.out.println("getNomiStudenti");
        Classe instance = new Classe("5C-ELT.txt");
        String[] expResult = {"AASSIR RIDA","ABBRACCIAVENTO MARCO","BECCANTINI ANDREA","CABRERA JASON","CAMPANALE MATTIA","DISTRATTO DOMENICO","GOLDONI RICCARDO","GUBERMAN VILLAFANE MAURICIO NAHUEL","MARMIROLI NICOLO' DANIEL","SALARDI FILIPPO"};
        String[] result = instance.getNomiStudenti();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNomeClasse method, of class Classe.
     */
    @Test
    public void testGetNomeClasse() {
        System.out.println("getNomeClasse");
        Classe instance = new Classe("5C-ELT.txt");
        String expResult = "5C-ELT";
        String result = instance.getNomeClasse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of set_studenti method, of class Classe.
     */
    @Test
    public void testSet_studenti() throws Exception {
        System.out.println("set_studenti");
        String nomefile = "5C-ELT.txt";
        Classe instance = new Classe("5C-ELT.txt");
        instance.set_studenti(nomefile);
        String[] expResult = {"AASSIR RIDA","ABBRACCIAVENTO MARCO","BECCANTINI ANDREA","CABRERA JASON","CAMPANALE MATTIA","DISTRATTO DOMENICO","GOLDONI RICCARDO","GUBERMAN VILLAFANE MAURICIO NAHUEL","MARMIROLI NICOLO' DANIEL","SALARDI FILIPPO"};
        assertEquals(expResult,instance.getNomiStudenti());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toStringStudenti method, of class Classe.
     */
    @Test
    public void testToStringStudenti() {
        System.out.println("toStringStudenti");
        Classe instance = new Classe("5C-ELT.txt");
        String[] expResult = {"AASSIR RIDA","ABBRACCIAVENTO MARCO","BECCANTINI ANDREA","CABRERA JASON","CAMPANALE MATTIA","DISTRATTO DOMENICO","GOLDONI RICCARDO","GUBERMAN VILLAFANE MAURICIO NAHUEL","MARMIROLI NICOLO' DANIEL","SALARDI FILIPPO"};
        String[] result = instance.toStringStudenti();
        assertArrayEquals(expResult, result);
    }
}
