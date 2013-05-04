/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charlie
 */
public final class Classe {
    
    private Studente studenti[];
    private String nomeClasse;
    private short StudentiTotali;
    private String nomiStudenti[];
    
    /**
     * Questo metodo serve ad ottenere il nome della classe senza il formato di estensione.
     * La variabile "tot" è una variabile che serve per ottenere la lunghezza del nome del file.
     * La variabile "nomeClasse" assumerà il nome del file senza la sua estensione utilizzando il metodo substring.
     * @param nomefile è il nome del file di testo
     */
    public void Set_nomeClasse(String nomefile){
        short tot=(short)nomefile.length();
        nomeClasse = nomefile.substring(0, tot-4).toUpperCase();        
    }

    public String[] getNomiStudenti() {
        return nomiStudenti;
    }
    
    /**
     * Questo è il costruttore della classe "Classe".
     * Richiama la funzione "ContaStudenti" per ottenere il numero degli studenti che verranno inseriti dentro un array.
     * @param nomefile è il nome del file di testo.
     */
    public Classe(String nomefile)
    {
        StudentiTotali=0;
        try {
            ContaStudenti(nomefile);
            studenti=new Studente[StudentiTotali];
            set_studenti(nomefile);
            Set_nomeClasse(nomefile);
            this.nomiStudenti=toStringStudenti();
        } catch (IOException ex) {
            Logger.getLogger(Classe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNomeClasse() {
        return nomeClasse;
    }
    
    /**
     * Serve per contare il numero degli studenti di un file passato come parametro.
     * ReadLine serve per leggere una riga intera da file di testo e per ogni riga aumenta di 1 il contatore "StudentiTotali".
     * @param nomefile è il nome del file di testo.
     * @throws IOException 
     */
    
    private void ContaStudenti(String nomefile) throws IOException{
        String s;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(nomefile) );
            while( (s = reader.readLine()) != null ){
                StudentiTotali++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Classe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     *  Serve per aggiungere il nome degli studenti dentro l'array "studenti".
     * @param nomefile
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void set_studenti(String nomefile) throws FileNotFoundException, IOException{
        short i=0;
        String nome="";
        BufferedReader reader = new BufferedReader(new FileReader(nomefile) );
	while( (nome = reader.readLine()) != null ){
            studenti[i]=new Studente(nome.toUpperCase());
            i++;
        }
    }
    /**
     * Scorre tutta la classe e prende i nomi degli studenti e li mette su un array.
     * @return Array contenente tutti i nomi degli studenti.
     */
    public String[] toStringStudenti(){
        String s[]=new String[StudentiTotali];
        for(short i=0; i< StudentiTotali; i++) {
            s[i]=studenti[i].getNome_Cognome().toUpperCase();
        }
        return s;
    }
    /**
     * Utilizziamo il metodo 'ToString' per ricevere in output i nomi delle varie
     * classi con i rispettivi studenti
     * @return la variabile 's' è una stringa che verrà riempita ogni volta con il nome della classe e successivamente
     * dai nomi degli studenti che la compongono.
     */
    /*@Override
    public String toString() {
        String s = "";
        s = "\n"+nomeClasse+"\n\n";
        for(short i=0; i< StudentiTotali; i++) {
            s += studenti[i].getNome_Cognome()+"\n";
        }
        s +="-------------------------------------------------------------------------------------";
        return s;
        
    }   */
}