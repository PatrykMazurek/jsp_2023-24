package uken.testThread;

import java.util.Random;

public class TestThread {

    public TestThread(){

        // implementacja wątków z wykorzystaniem klas anonimowych
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i< 5; i++){
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Bank b= new Bank();
        Runnable runnable1 = () -> {
            Random rand = new Random();
            for (int i=0; i< 50; i++){
                if(rand.nextBoolean()){
                    b.wplata(50);
                }else{
                    b.wyplata(30);
                }
            }
        };
        // tworzenie wątka
        Thread th1 = new Thread(runnable1);
        Thread th2 = new Thread(runnable1);
        // uruchomienie zadań przypisanych do wątka
        th1.start();
        th2.start();

        try {
            // jeżeli wymagana jest oczekiwanie na zakończenie pracy
            th1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
