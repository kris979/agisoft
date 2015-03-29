package com.agisoft.threads;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class R implements Runnable {
    int counter;

    @Override
    public void run() {
        while (counter < 10) {
            counter +=1;
            System.out.printf("%1$-2d alive\n", counter);
        }
        counter = 0;
        System.out.println("ready to die");
    }
};


/**
 * 
 *
 */
public class TestExecutorService {

    /**
     * @param args
     */
    public static void main(String[] args) {
//        ExecutorService es = Executors.newSingleThreadExecutor();
        ExecutorService es = Executors.newFixedThreadPool(2);

        R task = new R();
        R task1 = new R();
        R task2 = new R();
        es.execute(task);
        es.execute(task1);
        es.execute(task2);
        es.shutdown();
    }

}
