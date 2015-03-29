package com.agisoft.threads;

/* 
 * ============================================================================ 
 * Name      : Latch.java
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
 * Could be used to coordinate multiple threads performing a task like sharing loop load to do a job faster.
 *
 */
public class Latch {

    //need to have an object to synchronize on. I guess I could use "this" as well..
    private Object obj = new Object();
    private int threadsNo;
    
    /**
     * @param threadsNo
     */
    public Latch(int threadsNo) {
        super();
        synchronized (obj) {
            this.threadsNo = threadsNo;
        }
    }
    
    
    /**
     * Our master thread calls that to wait for all thread workers to finish their part of the job. 
     * @see line: 103
     * @throws InterruptedException
     */
    public void await() throws InterruptedException {
        synchronized (obj) {
            while(threadsNo > 0) {
                System.out.println("Waiting for all threads to finish");
                obj.wait();
            }
        }
    }
    
    
    /**
     * This method is called by each thread worker to indicate that it has finished his part of a job.
     */
    public void finish() {
        synchronized (obj) {
            if (--threadsNo < 0) {
                obj.notifyAll();
            }
        System.out.println(threadsNo + " threads still working.");    
        }
    }

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        int workingThreadsNo = 5;
        
        //latch to coordinate
        Latch l = new Latch(workingThreadsNo);
        
        //spliting a job into number of threads.
        for (int i = 0; i < workingThreadsNo; i++) {
            Thread t = new WorkerThread(l,Integer.toString(i));
            t.start();
        }
      //waiting for all threads to finish
        l.await();
    }
}
