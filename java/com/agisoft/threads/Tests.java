package com.agisoft.threads;
import java.util.concurrent.CountDownLatch;

class Counter {
    int c;
    
    public void inc() { c+=1;}

    @Override
    public String toString() {
        return " Counter [c=" + c + "]";
    }
    
}

class Tests extends Thread {
    Counter counter;
    CountDownLatch latch;

    public Tests(CountDownLatch latch, Counter counter) {
        super();
        this.counter = counter;
        this.latch = latch;
    }

    public void run() {
        synchronized (counter) {
            counter.inc();
            System.out.println(Thread.currentThread().getName() + counter);
        }
        latch.countDown();
    }
    
    public static void main(String... args) throws Exception {
        Counter counter = new Counter();
        CountDownLatch latch = new CountDownLatch(5);
        Tests t1 = new Tests(latch, counter);
        Tests t2 = new Tests(latch, counter);
        Tests t3 = new Tests(latch, counter);
        Tests t4 = new Tests(latch, counter);
        Tests t5 = new Tests(latch, counter);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        latch.await();
        System.out.println(counter);
    }
    
}
