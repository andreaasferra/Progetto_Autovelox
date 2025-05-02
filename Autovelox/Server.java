import java.io.IOException;
import java.net.*;
import java.util.*;

public class Server {  
    public static void main(String[] args) {
        final int PORT = 1050;
        try {
            List<Autovelox> dati = LettoreCSV.leggiFile("Mappa-degli-autovelox-in-italia.csv");
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server avviato sulla porta " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuovo client connesso: " + clientSocket.getInetAddress());
                new GestoreCliente(clientSocket, dati).start();
            }
        } catch (IOException e) {
            System.err.println("Errore nel server: " + e.getMessage());
        }
    }
}
