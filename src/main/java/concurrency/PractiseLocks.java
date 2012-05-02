/* 
 * ============================================================================ 
 * Name      : PractiseLocks.java
 * ============================================================================
 */
package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 *
 */
public class PractiseLocks {

    public static void lock(Lock l) throws InterruptedException {
        boolean tryLock = l.tryLock();
        if (tryLock) {
            try {
                PractiseLocks practiseLocks = new PractiseLocks();
                practiseLocks.sleep(5, TimeUnit.SECONDS);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                System.out.println("Unlocked");
                l.unlock();
            }
            System.out.println("Done");
        } else {
            System.out.println("Lock already taken");
        }
    }

    /**
     * @param i
     * @param seconds
     * @throws InterruptedException
     */
    private void sleep(int i, TimeUnit seconds) throws InterruptedException {
        System.out.print("Sleeping");
        for (int j = 0; j < i; j++) {
            Thread.sleep(seconds.toMillis(1));
            System.out.print(".");
        }
        System.out.println("");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        final Lock l = new ReentrantLock();
        Runnable r = new Runnable() {
            public void run() {
                try {
                    PractiseLocks.lock(l);
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                    e.printStackTrace();
                }
            }
        };
        

        
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(r);
            t.start();
        }
    }
}
