import java.io.*;
import java.util.*;

public class LettoreCSV{

    public static List<Autovelox> leggiAutovelox(String nomeFile){

        List<Autovelox> listaAutovelox = new ArrayList<>();
      
        try(BufferedReader br = new BufferedReader(new FileReader(nomeFile))){

            String riga;
            br.readLine();

            while((riga = br.readLine()) != null){

                String[] elementi = riga.split(";");

                if(elementi.length == 9){

                    String comune = elementi[0].trim();
                    String provincia = elementi[1].trim();
                    String regione = elementi[2].trim();
                    String nome = elementi[3].trim();
                    String anno = elementi[4].trim();
                    String data = elementi[5].trim();
                    String identificatore = elementi[6].trim();
                    double latitudine = Double.parseDouble(elementi[7].trim());
                    double longitudine = Double.parseDouble(elementi[8].trim());

                    Autovelox autovelox = new Autovelox(comune, provincia, regione, nome, anno, data, identificatore, latitudine, longitudine);
                    listaAutovelox.add(autovelox);

                }

            }

        }catch(IOException e){

            e.printStackTrace();

    }
        return listaAutovelox;

    }

}