package com.agisoft.threads;


/**
 * 
 * static:
 * yield()
 * sleep() - throws InterruptedException
 * 
 * non static:
 * start()
 * join()
 *
 */



public class PractiseThreadSynchronization1 implements Runnable {
    
    private int balance = 100;

    public static void main(String[] args) {
        PractiseThreadSynchronization1 acc = new PractiseThreadSynchronization1();
        Thread t0 = new Thread(acc);
        Thread t1 = new Thread(acc);
        Thread t2 = new Thread(acc);
        t0.start();
        t1.start();
        t2.start();
    }
    
    public void withdraw(int amount) {
        balance -= amount;
    }
    
    public int balance() {
        return balance;
    }
    
    public boolean canWithdraw() {
        return balance > 0 ? true : false;
    }
   
    //just remove sychronized to see what happens when we dont synchronize threads...
    public synchronized void makeWithdraw() {
        if (balance() <= 0) {
            System.out.println(Thread.currentThread().getName() + " : Account overdrawn!!!");
        } else {   
        for (int x =0; x < 10; x++) {
            withdraw(10);
            System.out.println(Thread.currentThread().getName() + " : £" + balance());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        }
        }
    }
    
    public void run() {
        makeWithdraw();
    }
}
