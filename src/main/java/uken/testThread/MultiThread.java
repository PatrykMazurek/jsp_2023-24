package uken.testThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThread {

    private int numberThread;

    public MultiThread(){
        this.numberThread = 5;
    }

    public void fixedThread(){
        ExecutorService service = Executors.newFixedThreadPool(this.numberThread);
        StartRunnable startR = new StartRunnable();
        for (int i = 0; i < 40; i++){
            service.submit(startR);
        }
        service.shutdown();
    }

    public void cachedThread(){
        ExecutorService service = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) service;

        List<Future<Integer>> futureList = new ArrayList<>();
        int numTask = 0;
        while (numTask < 200){
            if (threadPoolExecutor.getActiveCount() < this.numberThread){
                StartCallable startC = new StartCallable();
                futureList.add(threadPoolExecutor.submit(startC));
                numTask++;
            }
        }
        System.out.println("Odczytywanie wyników pozyskanych z wątków");

        for(Future<Integer> future : futureList){
            try{
                int number = future.get(1, TimeUnit.SECONDS);
                System.out.println("zwrócona wartość: " + number);
            } catch (ExecutionException | TimeoutException |InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        threadPoolExecutor.shutdown();
    }
}
