package com.agisoft.threads;
/* 
 * ============================================================================ 
 * Name      : TestThreadId.java
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
public class TestThreadId extends Thread {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Thread t = new TestThreadId();
        Thread t1 = new TestThreadId();
        System.out.println(t.getId() + "," + t1.getId());
        t.start();
        t1.start();
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getId() + ":"
                + Thread.currentThread().getPriority());
    }

}
