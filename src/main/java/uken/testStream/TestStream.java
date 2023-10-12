package uken.testStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

    public TestStream(){
        BoardGame game = new BoardGame();

        try {
            List<BoardGame> games = game.loadFromFile("Games.csv");
            System.out.println(games.size());
            // stworzenie obiektu Stream
            Stream<BoardGame> streamGame = games.stream();
            // wykorzystanie interfejsu funkcyjnego do utworzenia dostępu do obiektów stream
            Supplier<Stream<BoardGame>> supplierGame = () -> games.stream();
            // wykorzystanie obiektu list i filtracji z obiektami Stream
            List<BoardGame> tGame = games.stream()
                    .filter(g -> g.getYear() > 2004 && g.getYear() < 2010)
                    .toList();
            System.out.println(tGame.size());
            // wyszukanie pojedyńczego obiektu za pomacą Stream
            BoardGame objGame = games.stream()
                    .filter(g -> g.getYear() > 2004 && g.getYear() < 2010)
                    .findFirst().orElse(null);

            if (objGame != null){
                System.out.println(tGame);
            }else{
                System.out.println("Brak elementu w zbiorze");
            }
            // sprawdzenie czy w zbiorze istnieje boekt o podanyc hzałożeniach
            if( games.stream().anyMatch(g -> g.getAge().contains("13")) ) {
                System.out.println("Istnieje takie element");
            }else{
                System.out.println("Brak elementu w zbiorze");
            }
            // grupowanie wszystkich elementów zbioru po wybranym elemencie
            Map<Integer, List<BoardGame>> mapGame = games
                    .stream().collect(Collectors.groupingBy(BoardGame::getYear));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
