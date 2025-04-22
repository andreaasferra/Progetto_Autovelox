
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LettoreCSV {
    public static List<String[]> leggiCSV(String nomeFile) {
        List<String[]> righe = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] valori = linea.split(";");
                righe.add(valori);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return righe;
    }
}
