package com.agisoft.threads;
/* 
 * ============================================================================ 
 * Name      : PractiseThreads.java
 * Part of     :  H4S
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

public class PractiseThreads {

    public static void main(String[] args) {
        new PractiseThreads().go();
    }

    public void go() {
        //1st method - this is a recommended way as most of the time our threads objects are really jobs 
        //and not more specialized version of Thread
        
        MyRunnableJob job = new MyRunnableJob();  //must implement public void run() 
        Thread t = new Thread(job);             //then we pass runnable object to a thread which calls its run() method
        t.setName("t0");
        t.start();          //does not actually guarantee to start the thread, it changes the status to runnable

        Thread t1 = new MyThread("t1"); //we can pass name in the constructor
        Thread t2 = new MyThread();
        t2.setName("t2");               //or use setName method
        Thread t3 = new MyThread("t3");
        t1.start();
        t2.start();
        t3.start();
        try {
            t3.join();  //joins the current thread (main) to the end of t3 - main will execute after t3 is dead
                        //unless something interrupts this thread, then its status is cleared and it is no longer
                        //guaranteed taht it will finish after t3
        } catch (InterruptedException e) {
            
        }
        System.out.println("main");
    }
}

class MyThread extends Thread {

	String test = "t";

	/**
	 * 
	 */
	public MyThread() {}
	
	/**
	 * @param name
	 */
	public MyThread(String name) {
	    super(name);
	}
	
	@Override
    public void run() {
    	try {
    		test.wait();
		} catch (Exception e) {
			// TODO: handle exception
		}
        System.out.println(this.getName());
    }
}

class MyRunnableJob implements Runnable {

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName());
    }

}