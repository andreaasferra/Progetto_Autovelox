import java.io.*;
import java.net.*;
import java.util.*;

public class TesterAutovelox {

    private static final int PORTA = 1050;
    private static final List<String[]> csvContent = LettoreCSV.leggiCSV("Mappa-degli-autovelox-in-italia.csv");

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORTA)) {
            System.out.println("Server avviato... in attesa di connessioni");

            while (true) {
                Socket socketCliente = serverSocket.accept();
                System.out.println("Nuovo client connesso: " + socketCliente.getInetAddress());
                new GestoreCliente(socketCliente).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class GestoreCliente extends Thread {

        private final Socket socketCliente;
        private BufferedReader in;
        private PrintWriter out;

        public GestoreCliente(Socket socket) {
            this.socketCliente = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                out = new PrintWriter(socketCliente.getOutputStream(), true);

                String richiesta;
                while ((richiesta = in.readLine()) != null) {
                    System.out.println("Richiesta ricevuta: " + richiesta);
                    String risposta = avviaRichiesta(richiesta);
                    out.println(risposta);
                }

                socketCliente.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String avviaRichiesta(String richiesta) {
            String[] elementi = richiesta.split(" ", 3);
            if (elementi.length < 2) {
                return "Errore: comando incompleto.";
            }

            String comando = elementi[0].toLowerCase();

            if (!comando.equals("get")) {
                return "Errore: comando non riconosciuto.";
            }

            String tipo = elementi[1].toLowerCase();

            switch (tipo) {
                case "riga":
                    if (elementi.length < 3) return "Errore: specificare il numero della riga.";
                    return getRiga(elementi[2]);
                case "colonna":
                    if (elementi.length < 3) return "Errore: specificare il nome della colonna.";
                    return getColonna(elementi[2]);
                case "completo":
                    return getCompleto();
                default:
                    return "Errore: opzione non valida. Usa 'riga', 'colonna' o 'completo'.";
            }
        }

        private String getRiga(String numeroRigaStr) {
            try {
                int riga = Integer.parseInt(numeroRigaStr);
                if (riga < 0 || riga >= csvContent.size()) {
                    return "Errore: riga fuori range.";
                }
                return String.join(" | ", csvContent.get(riga));
            } catch (NumberFormatException e) {
                return "Errore: numero riga non valido.";
            }
        }

        private String getColonna(String nomeColonna) {
            if (csvContent.isEmpty()) return "Errore: file vuoto.";
            String[] intestazioni = csvContent.get(0);

            int index = -1;
            for (int i = 0; i < intestazioni.length; i++) {
                if (intestazioni[i].equalsIgnoreCase(nomeColonna)) {
                    index = i;
                    break;
                }
            }

            if (index == -1) return "Errore: colonna non trovata.";

            StringBuilder result = new StringBuilder();
            for (int i = 1; i < csvContent.size(); i++) {
                result.append(csvContent.get(i)[index]).append("\n");
            }

            return result.toString();
        }

        private String getCompleto() {
            StringBuilder result = new StringBuilder();
            for (String[] riga : csvContent) {
                result.append(String.join(" | ", riga)).append("\n");
            }
            return result.toString();
        }
    }
}
