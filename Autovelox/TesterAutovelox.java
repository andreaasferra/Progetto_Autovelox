import java.io.*;
import java.util.*;

public class TesterAutovelox {
    public static void main(String[] args) {

        String nomeFile = "Mappa-degli-autovelox-in-italia.csv";
        List<Autovelox> autovelox = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(nomeFile))){

            String riga;
            boolean primaRiga = true;

            while((riga = br.readLine()) != null){

                if (primaRiga){

                    primaRiga = false;
                    continue;

                }

                String[] dati = riga.split(";");

                if(dati.length == 9){

                    String comune = dati[0].trim();
                    String provincia = dati[1].trim();
                    String regione = dati[2].trim();
                    String nome = dati[3].trim();
                    String anno = dati[4].trim();
                    String data = dati[5].trim();
                    String identificatore = dati[6].trim();
                    String longitudine = dati[7].trim();
                    String latitudine = dati[8].trim();

                    autovelox.add(new Autovelox(comune, provincia, regione, nome, anno, data, identificatore, longitudine, latitudine));

                }

            }

        }catch(IOException e){

            System.err.println("Errore nella lettura del file" + e.getMessage());

        }

        System.out.println("Dati letti dal CSV: ");
        for(Autovelox a : autovelox){

            System.out.println(a);

        }

    }

}