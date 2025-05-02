import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 1050;

        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String risposta;
            while ((risposta = in.readLine()) != null) {
                System.out.println(risposta);
                if (!in.ready()) break;
            }

            String comando;
            while (true) {
                System.out.print("> ");
                comando = stdin.readLine();
                out.println(comando);
                if (comando.equalsIgnoreCase("QUIT")) break;
                while ((risposta = in.readLine()) != null && !risposta.isEmpty()) {
                    System.out.println(risposta);
                    if (!in.ready()) break;
                }
            }
        } catch (IOException e) {
            System.err.println("Errore client: " + e.getMessage());
        }
    }
}
