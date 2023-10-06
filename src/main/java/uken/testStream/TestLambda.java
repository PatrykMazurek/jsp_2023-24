package uken.testStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.LongFunction;

@FunctionalInterface
interface SomeNumbers{
    double test(double a, double b);
}

public class TestLambda {

    public TestLambda(){
        // definicja wyrarzenia lambda
        SomeNumbers sN = (n,m) -> n/m;
        System.out.println(sN.test(3,5));

        int number = 1;
        // defincja blokowego wyrażenia lambda
        SomeNumbers sN2 = (n,m) -> {
            if (m == 0) {
                m = m + number;
            }
            // operacja nie dozwolona
//            number++;
            return n/m;
        };
        System.out.println(sN2.test(4, 0));

        List<String> stringList = Arrays.asList("Kraków", "Poznań", "Warszawa", "Częstochowa");
        // wypisywanie elemntów listy z wykorzystaniem wyrażenia lambda
        stringList.forEach(System.out::println);
        stringList.sort(Comparator.comparing(String::length));
        System.out.println("----------");
        stringList.forEach(System.out::println);

//        Zadanie silnia z wykorzystaniem wbudowanego w środowisko java inferfejsu funkcyjnego
        LongFunction<Long> silnia = (n) ->{
            long result = 1;
            for (int i = 1; i<=n; i++){
                result = result * i;
            }
            return result;
        };

        System.out.println("Silnia dla liczby 5 wynosi: " + silnia.apply(5));

        List<Person> pList = new ArrayList<>();
        pList.add(new Person("Jan Nowak", 34, "Kraków"));
        pList.add(new Person("Ewa Kowalska", 25, "Częstochowa"));
        pList.add(new Person("Tomasz Rak", 33, "Kraków"));
        pList.add(new Person("Dagmara Kowalska", 34, "Warszawa"));

        // wykonanie wyraezenia lambda do sortowania obiektów na liscie
        // dla klasy z polami prywatymi
        pList.sort(Comparator.comparing(Person::getName));

        // dla klasy z polami publicznymi
//        pList.sort(Comparator.comparing(person -> person.name));
        pList.forEach(System.out::println);
    }

}
