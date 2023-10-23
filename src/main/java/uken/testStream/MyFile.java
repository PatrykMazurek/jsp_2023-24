package uken.testStream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MyFile {
    // przykład osbługi plików stworzony pod klasę BoardGame
    public void saveToFile(String path, List<BoardGame> games ){
        try{
            // stworzenia otwarcia do pliku z możliwościa zapisu
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(path, StandardCharsets.UTF_8));
            for (BoardGame g : games){
                // zapisywanie danych do pliku
                bufferedWriter.write(g.toString());
                // w przypadku kiedy w danych niema zdefiniowanej nowej lini
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            // zamknięcie pliku
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveObjToFile(String path, List<BoardGame> games){
        try{
            // stworzenia otwarcia do pliku z możliwościa zapisu
            ObjectOutputStream objOut = new ObjectOutputStream(
                    new FileOutputStream(path) );
            // deklarowanie wielkości danych zapisywanych w pliku
            objOut.writeInt(games.size());
            for (BoardGame g : games){
                // zapisywanie danych w pliku
                objOut.writeObject(g);
                objOut.flush();
            }
            // zamknięcie pliku
            objOut.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BoardGame> readFromFile(String path){
        List<BoardGame> gameList = new ArrayList<>();
        try {
            // stworzenie otwarcia do pliku z możliwością odczytu
            ObjectInputStream objIn = new ObjectInputStream(
                    new FileInputStream(path));
            int size = objIn.readInt();
            for (int i=0; i<size;i++){
                // odczytywanie danych serializowanych i rzutowanie ich na konkretny obiekt
                gameList.add((BoardGame) objIn.readObject());
            }
            // zamknięcie pliku
            objIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
            //            throw new RuntimeException(e);
        }
        return gameList;
    }
}
