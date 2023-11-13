package uken.TestServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class AppClient {

    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public AppClient(String host){
        try {
            socket = new Socket(host, 5055);
            System.out.println("Nawiązano połączenie z serwerem ");
            input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(),
                            StandardCharsets.UTF_8));
            output = new PrintWriter(socket.getOutputStream(), true);
            sendMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(){
        Scanner scan = new Scanner(System.in);
        try{
            String line ="";
            while (true){
                line = input.readLine().replace(";", "\n");
                System.out.println(line);
                String option = scan.nextLine();
                output.println(option);
                line = input.readLine().replace(";", "\n");
                System.out.println(line);
                if(option.equals("e")){
                    break;
                }
            }
            System.out.println("zakończenie połązcenia z serwerem");
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
