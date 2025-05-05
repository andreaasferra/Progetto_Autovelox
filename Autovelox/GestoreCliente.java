import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Optional;

public class GestoreCliente extends Thread {
    private final Socket client;
    private final List<Autovelox> dati;

    public GestoreCliente(Socket socket, List<Autovelox> dati) {
        this.client = socket;
        this.dati = dati;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

            out.println("Benvenuto! Comandi: MOSTRA_TUTTO, RIGA x, COLONNA x (0-8), CERCA_ID <ID>, QUIT");

            String input;
            while ((input = in.readLine()) != null) {
                input = input.trim();
                if (input.equalsIgnoreCase("QUIT")) {
                    out.println("Connessione terminata.");
                    break;
                } else if (input.equalsIgnoreCase("MOSTRA_TUTTO")) {
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
                    } catch (NumberFormatException e) {
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
                    } catch (NumberFormatException e) {
                        out.println("Formato comando COLONNA non valido.");
                    }
                } else if (input.startsWith("CERCA_ID")) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        String idRicerca = parts[1];
                        cercaPerId(idRicerca, out);
                    } else {
                        out.println("Formato comando CERCA_ID non valido.");
                    }
                } else {
                    out.println("Comando non riconosciuto.");
                }
            }
        } catch (IOException e) {
            System.out.println("Errore client: " + e.getMessage());
        }
    }

    private void cercaPerId(String idRicerca, PrintWriter out) {
        Optional<Autovelox> autovelox = dati.stream()
                .filter(a -> a.getIdentificatore().equalsIgnoreCase(idRicerca))
                .findFirst();

        if (autovelox.isPresent()) {
            out.println(Autovelox.header());
            out.println(autovelox.get());
        } else {
            out.println("Autovelox con ID " + idRicerca + " non trovato.");
        }
    }
}
