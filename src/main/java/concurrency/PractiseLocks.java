/* 
 * ============================================================================ 
 * Name      : PractiseLocks.java
 * ============================================================================
 */
package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 *
 */
public class PractiseLocks {
    
    public static class Runner implements Runnable {

        private CountDownLatch latch;
        
        /**
         * @param latch
         */
        private Runner(CountDownLatch latch) {
            super();
            this.latch = latch;
        }

        /* (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            try {
                doSomeWork();
                latch.countDown(); //decrement counter
                System.out.println(Thread.currentThread().getName() + "waiting.");
                latch.await(); //wait for other threads 
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "was interrupted.");  //finishing anyway
                } 
                System.out.println(Thread.currentThread().getName() + "done.");
        }
        
        /**
         * @throws InterruptedException 
         * 
         */
        private void doSomeWork() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " doing some work....");
            TimeUnit.SECONDS.sleep(1);
        }
    }


    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);   //best 3
        List<Runner> runners = new ArrayList<Runner>();
        for (int i = 0; i < 20; i++) {
            Runner runner = new Runner(latch);
            runners.add(runner);
        }
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (Runner runner : runners) {
            exec.execute(runner);
        }
        System.out.println(Thread.currentThread().getName() + " finishing...");
        
    }
    
    
}
