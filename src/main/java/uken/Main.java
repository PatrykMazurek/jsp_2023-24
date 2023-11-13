package uken;

import uken.TestServer.AppClient;
import uken.TestServer.StartServer;
import uken.testStream.BoardGame;
import uken.testStream.Person;
import uken.testStream.TestLambda;
import uken.testStream.TestStream;

import java.io.IOException;
import java.util.*;
import java.util.function.LongFunction;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
//        new TestLambda();
//        new TestStream();
        // testowanie programowania gniazdek
        if(args.length > 0){
            if (args[0].equals("server")){
                new StartServer();
            }
            if (args[0].equals("client")){
                new AppClient("localhost");
            }
        }
    }
}