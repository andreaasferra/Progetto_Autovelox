import java.io.*;
import java.net.*;
import java.util.List;

public class GestoreCliente extends Thread {
    private Socket client;
    private List<Autovelox> dati;

    public GestoreCliente(Socket socket, List<Autovelox> dati) {
        this.client = socket;
        this.dati = dati;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

            out.println("Benvenuto! Comandi: MOSTRA_ALL, RIGA x, COLONNA x (0-8), QUIT");

            String input;
            while ((input = in.readLine()) != null) {
                input = input.trim();
                if (input.equalsIgnoreCase("QUIT")) {
                    out.println("Connessione terminata.");
                    break;
                } else if (input.equalsIgnoreCase("MOSTRA_ALL")) {
                    out.println(Autovelox.header());
                    for (Autovelox c : dati) out.println(c);
                } else if (input.startsWith("RIGA")) {
                    try {
                        int idx = Integer.parseInt(input.split(" ")[1]);
                        if (idx >= 0 && idx < dati.size()) {
                            out.println(Autovelox.header());
                            out.println(dati.get(idx));
                        } else {
                            out.println("Indice riga fuori dai limiti.");
                        }
                    } catch (Exception e) {
                        out.println("Formato comando RIGA non valido.");
                    }
                } else if (input.startsWith("COLONNA")) {
                    try {
                        int col = Integer.parseInt(input.split(" ")[1]);
                        if (col >= 0 && col < 9) {
                            out.println(String.format("COLONNA %d:", col));
                            for (Autovelox c : dati)
                                out.println(c.toArray()[col]);
                        } else {
                            out.println("Indice colonna fuori dai limiti.");
                        }
                    } catch (Exception e) {
                        out.println("Formato comando COLONNA non valido.");
                    }
                } else {
                    out.println("Comando non riconosciuto.");
                }
            }
        } catch (IOException e) {
            System.out.println("Errore client: " + e.getMessage());
        }
    }
}
