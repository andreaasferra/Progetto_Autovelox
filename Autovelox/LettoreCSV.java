
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LettoreCSV {
    public static List<Autovelox> leggiFile(String path) throws IOException {
        List<Autovelox> lista = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        boolean firstLine = true;
        while ((line = reader.readLine()) != null) {
            if (firstLine) { firstLine = false; continue; }
            String[] parts = line.split(";");
            if (parts.length == 9)
                lista.add(new Autovelox(parts));
        }
        reader.close();
        return lista;
    }
}
