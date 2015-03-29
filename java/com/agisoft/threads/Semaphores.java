package com.agisoft.threads;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class TestSem implements Runnable {

    private Semaphore semaphore;

    public TestSem(Semaphore sem) {
        this.semaphore = sem;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            if (semaphore.tryAcquire(1, TimeUnit.MICROSECONDS)) {
                System.out.println(Thread.currentThread().getName() + " Semaphore acquired. "
                        + semaphore.availablePermits() + " permits left.");
                long sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum *= i;
                }
                semaphore.release();
            } else {
                System.out.println("Wait is over.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 
 *
 */
public class Semaphores {

    private final Semaphore sem = new Semaphore(2, true);

    public void go() {
        TestSem testSem = new TestSem(sem);
        Thread t1 = new Thread(testSem);
        Thread t2 = new Thread(testSem);
        Thread t3 = new Thread(testSem);
        Thread t4 = new Thread(testSem);
        Thread t5 = new Thread(testSem);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    public static void main(String[] args) {
        new Semaphores().go();
    }
}
