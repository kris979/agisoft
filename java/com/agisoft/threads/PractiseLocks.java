package com.agisoft.threads;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/* 
 * ============================================================================ 
 * Name      : PractiseLocks.java
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

class Writer implements Runnable {

    private PractiseLocks test;
    private int numberToWrite;
    
    /**
     * @param test
     * @param numberToWrite
     */
    public Writer(PractiseLocks test, int numberToWrite) {
        super();
        this.test = test;
        this.numberToWrite = numberToWrite;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            try {
                test.write(numberToWrite);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   
    }
}

/**
 * 
 *
 */
public class PractiseLocks {
    
    int[] arr = new int[10];
    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    final Lock lck = new ReentrantLock();
    
    public void write(int number) throws InterruptedException {
//        Lock writeLock = readWriteLock.writeLock();
//        writeLock.lock();
        lck.lock();
//        boolean tryLock = lck.tryLock(2, TimeUnit.MILLISECONDS);
//        System.out.println("trylock: " + tryLock);
        try {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = number;
                System.out.print(arr[i] + "-");
            }
        } finally {
            lck.unlock();
//            writeLock.unlock();
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        PractiseLocks test = new PractiseLocks();
        Thread t1 = new Thread(new Writer(test, 1), "Writer-1");
        Thread t2 = new Thread(new Writer(test, 2), "Writer-2");
        t1.start();
        t2.start();
        
    }

}
