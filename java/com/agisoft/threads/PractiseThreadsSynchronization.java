package com.agisoft.threads;
/* 
 * ============================================================================ 
 * Name      : PractiseThreadsSynchronization.java
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

/**
 * @author bliszcza
 *
 */
public class PractiseThreadsSynchronization {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SynchronizedThread a = new SynchronizedThread("A");
        SynchronizedThread b = new SynchronizedThread("B");
        SynchronizedThread c = new SynchronizedThread("C");
        a.start();
        b.start();
        c.start();
    }
    
}

class SynchronizedThread extends Thread {
    
    private String s = "hi";   //synchronization on literal works because JAVA keeps only one string in a string pool
//    private String s = new String("hi");   //does not work!
//    static private String s = "hi";        //works as s is a class variable thus shared between instances.
    public SynchronizedThread(String name) {
        super(name);
    }
    
    public void run() {
        synchronized(s) {
            try {
                System.out.print(Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}