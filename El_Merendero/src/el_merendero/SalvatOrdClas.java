/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author piffy
 */
public class SalvatOrdClas {

    public static void Salvataggio(OrdineDiClasse p) {
        try {
            //TODO: Il nome del file deve dipendere dal nome dell'ordine di classe
            FileOutputStream file = new FileOutputStream("./config/ordini/OrdineClas.txt");
            PrintStream Output = new PrintStream(file);
            Output.println(p);


        } catch (IOException e) {
            System.out.println("Errore: " + e);
            System.exit(1);
        }
    }

    
}
