/* 
 * ============================================================================ 
 * Name      : CyclicBuffer.java
 * ============================================================================
 */
package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 *
 */
public class CyclicBuffer {


    public static class BarrierCheck implements Runnable {
        @Override
        public void run() {
            System.out.println("Checking.");
        }
    }

    public static class Runner implements Runnable {
        
        private CyclicBarrier barrier;
        /**
         * @param barrier
         */
        public Runner(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " running.");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new BarrierCheck());
        Runner runner = new Runner(barrier);
        for (int i = 0; i < 10; i++) {
            new Thread(runner).start();
        }
        System.out.println(barrier.getNumberWaiting());
        System.out.println(barrier.getParties());
    }
}
