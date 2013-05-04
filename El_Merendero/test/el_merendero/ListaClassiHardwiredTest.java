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
public class ListaClassiHardwiredTest {
    
    public ListaClassiHardwiredTest() {
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
     * Test of ListaStudentiXClasse method, of class ListaClassiHardwired.
     */
    @Test
    public void testListaStudentiXClasseData() {
        System.out.println("ListaStudentiXClasse");
        String nomeclasse = "5C-ELT";
        ListaClassiHardwired instance = new ListaClassiHardwired();
        String[] expResult = {"AASSIR RIDA","ABBRACCIAVENTO MARCO","BECCANTINI ANDREA","CABRERA JASON","CAMPANALE MATTIA","DISTRATTO DOMENICO","GOLDONI RICCARDO","GUBERMAN VILLAFANE MAURICIO NAHUEL","MARMIROLI NICOLO' DANIEL","SALARDI FILIPPO"};
        String[] result = instance.ListaStudentiXClasseData(nomeclasse);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getClassiTotali method, of class ListaClassiHardwired.
     */
    @Test
    public void testGetClassiTotali() {
        System.out.println("getClassiTotali");
        ListaClassiHardwired instance = new ListaClassiHardwired();
        short expResult = 10;
        short result = instance.getClassiTotali();
        assertEquals(expResult, result);
    }
}
