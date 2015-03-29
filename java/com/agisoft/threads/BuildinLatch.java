package com.agisoft.threads;
import java.util.concurrent.CountDownLatch;

/* 
 * ============================================================================ 
 * Name      : BuildinLatch.java
 * Part of     :  NEON
 * 
 * Copyright (c) 2007-2011 Nokia.  All rights reserved.
 * This material, including documentation and any related computer
 * programs, is protected by copyright controlled by Nokia.  All
 * rights are reserved.  Copying, including reproducing, storing,
 * adapting or translating, any or all of this material requires the
 * prior written consent of Nokia.  This material also contains
 * confidential information which may not be disclosed to others
 * without the prior written consent of Nokia.
 * 
 * ============================================================================
 */

/**
 * 
 *
 */
public class BuildinLatch {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        int workingThreadsNo = 5;
        CountDownLatch l = new CountDownLatch(workingThreadsNo);
        //spliting a job into number of threads.
        for (int i = 0; i < workingThreadsNo; i++) {
            Thread t = new Worker(l,Integer.toString(i));
            t.start();
        }
      //waiting for all threads to finish
        l.await();
    }

}


class Worker extends Thread {
    
    private CountDownLatch latch;

    /**
     * @param latch
     */
    public Worker(CountDownLatch latch, String name) {
        super(name);
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Running Thread-" + Thread.currentThread().getName());
            for (int i = 0; i < 20; i++) {
                System.out.print(Thread.currentThread().getName());
                try {
                    Thread.sleep(1*1000);
                } catch (InterruptedException e) {
                    System.out.println("How dare you interrupting me.");
                }
            }
        } finally {
            System.out.println("Thread-" + Thread.currentThread().getName() + " finished.");
            latch.countDown();
        }
    }
}