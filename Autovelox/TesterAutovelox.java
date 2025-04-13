import java.io.*;
import java.net.*;
import java.util.*;

public class TesterAutovelox {

    private static final int PORTA = 1050;
    private static final List<Autovelox> autoveloxList = LettoreCSV.leggiAutovelox("Mappa-degli-autovelox-in-italia.csv");

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

            String[] elementi = richiesta.split(" ");
            if (elementi.length != 2) {
                return "Errore: richiesta non valida. Usa il formato 'get <comune>' oppure 'get <provincia>'.";
            }

            String comando = elementi[0].toLowerCase();
            String parametro = elementi[1];

            if (comando.equals("get")) {
                return getAutoveloxInfo(parametro);
            } else {
                return "Errore: comando non riconosciuto.";
            }
        }

        // Modifica della ricerca basata sul parametro comune
        private String getAutoveloxInfo(String parametro) {
            // Cerca l'autovelox nel comune o nella provincia
            for (Autovelox autovelox : TesterAutovelox.autoveloxList) {
                // Supponiamo che il parametro sia un comune o una provincia
                if (autovelox.getComune().equalsIgnoreCase(parametro) || autovelox.getProvincia().equalsIgnoreCase(parametro)) {
                    return autovelox.toString();
                }
            }
            return "Errore: autovelox non trovato per il comune/provincia: " + parametro;
        }
    }
}
