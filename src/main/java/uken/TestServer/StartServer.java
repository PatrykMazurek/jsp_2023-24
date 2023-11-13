package uken.TestServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StartServer {

    private ServerSocket serverSocket;

    public StartServer(){
        try {
            serverSocket = new ServerSocket(5055);
            System.out.println("Oczekuje na połączenia ");
            startServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void startServer(){
        while (true){
            try {
                Socket clientSocket = serverSocket.accept();
                new Thread(new AppServer(clientSocket)).start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
