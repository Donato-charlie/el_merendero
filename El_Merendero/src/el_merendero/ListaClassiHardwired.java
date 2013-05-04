/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package el_merendero;

import java.io.File;
import java.util.Arrays;

/**
 *
 * @author charlie
 */
public class ListaClassiHardwired {
    
    private Classe classi[];
    private String nomiFile[];
    private String NomiClassi[];
    private short classiTotali;
    
    /**
     * In questo costruttore inizializziamo la variabile "ClassiTotali", inizializzata con valore 0,
     * e creiamo (e inizializzamo) l'array "CLASSE" di tipo classi.
     * Inoltre, richiamiamo la funzione "ElencoFile" 
     */
    public ListaClassiHardwired(){
        this.classiTotali=0;
        ElencoFile();
        classi = new Classe[classiTotali];
        setClassi();
        NomiClassi=new String[classiTotali];
       NomiClassi=  ListaNomiClassi();
    }

    private void setClassi() {
        for(short i=0;i<classiTotali;i++){
            classi[i]=new Classe(nomiFile[i]);
        }
    }
    /**
     * Scorre tutti i file e inserisce i loro nomi dentro l'array.
     * @return Array contenente tutti i nomi della classi.
     */
    private String[] ListaNomiClassi(){
       String s[] = new String [classiTotali];       
       for(short i=0;i<classiTotali;i++) {
            s[i]= classi[i].getNomeClasse();
        }
       return s;
    }
    /**
     * 
     * @param nomeclasse 
     * @return Array contenente i nomi di tutti gli studenti del nome della classe passata come parametro
     */
    
    public String[] ListaStudentiXClasseData(String nomeclasse){
        for(short i = 0; i< classiTotali;i++){
            if(classi[i].getNomeClasse().toUpperCase().equals(nomeclasse.toUpperCase())){
                return classi[i].getNomiStudenti();
            }
        }
        return null;
    }
    
    /**
     * Creiamo una variabile di tipo File.
     * Controlliamo se i file di cui vogliamo l'elenco siano contenuti nella
     * directory e otteniamo l'elenco dei file al suo interno; ordiniamo i file trovati
     * estrapolandone il nome. Aumentiamo il valore della variabile "ClassiTotali"
     */
    
    private void ElencoFile()
    {
        File file = new File(".");
        if(file.isDirectory())
        {
            File[] filesInDir = file.listFiles();
	    Arrays.sort(filesInDir);
            nomiFile = new String [filesInDir.length];
	    for(File f : filesInDir)
            {
                String estensione = ".txt";
                if(f.isFile() && f.getName().toLowerCase().contains(estensione))
                {
                    nomiFile[classiTotali]= f.getName();
                    classiTotali++;
                }                
	    }
	}
    }

    public short getClassiTotali() {
        return classiTotali;
    }
    
    
  /*  @Override
    public String toString(){
        String s = "";
        for(short i=0;i<classiTotali;i++){
            s += classi[i].toString();
        }
        return s;
    }*/
}
