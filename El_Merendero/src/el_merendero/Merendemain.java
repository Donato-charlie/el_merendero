/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author b11g12
 */
public class Merendemain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Merenda[] ar = new Merenda[10];
        ar[0] = new Merenda(5.0f, "pan");
        ar[1] = new Merenda(4.5f, "poninan");
        ar[2] = new Merenda(3.5f, "poninan");
        Listamerende li = new Listamerende();
        li.add(ar[0]);
        li.add(ar[1]);
        li.add(ar[2]);
        li.remove("poninan");
        System.out.println(li);
        System.out.println(li.getTotale());
//-------------------------------------------------------------------------------------------------
        Ordine io = new Ordine("Simone");
        Merenda m1 = new Merenda(1.2f, "cane");
        io.getMerendeOrdinate().add(m1);
        io.getMerendeOrdinate().add(ar[1]);
        ListaMerendeAll p = new ListaMerendeAll();
        String[] f = p.getProdotti();
        System.out.println(f[0]);
        System.out.println(f[1]);
        float price[]=p.getPrezzi();
        System.out.println(price[0]);
    }
    //--------------------------------------------------------------------------------------
}
