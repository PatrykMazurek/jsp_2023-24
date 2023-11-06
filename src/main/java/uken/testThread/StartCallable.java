package uken.testThread;

import java.util.Random;
import java.util.concurrent.Callable;

public class StartCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        int number = random.nextInt(1000);
        Thread.sleep(number + 300);
        return number;
    }
}
