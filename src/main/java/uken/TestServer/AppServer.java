package uken.TestServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class AppServer implements Runnable{

    private Socket cSocket;
    private BufferedReader input;
    private PrintWriter output;

    public AppServer(Socket clientSocket){
        try {
            cSocket = clientSocket;
            System.out.println("Nawiązano połązcenie z " + cSocket.toString());
            input = new BufferedReader(
                    new InputStreamReader(cSocket.getInputStream(),
                            StandardCharsets.UTF_8));
            output = new PrintWriter(cSocket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {
        String message = "Wybierz opcję: ;" +
                "1) opcja 1 ;" +
                "2) opcja 2 ;" +
                "e) zakończ";
        String line;
        boolean work = true;
        try{
            while (work){
                output.println(message);
                line = input.readLine();
                switch (line){
                    case "1":
                        output.println("opcaj 1");
                        break;
                    case "2":
                        output.println("opcja 2");
                        break;
                    case "e":
                        output.println("Bye!");
                        work = false;
                    default:
                        output.println("nie ma takiej opcji");
                        System.out.println("błędna opcja");
                        break;
                }
            }
            System.out.println("Zakończenie połączenia z klientem "
                    + cSocket.toString());
            input.close();
            output.close();
            cSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
