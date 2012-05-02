/* 
 * ============================================================================ 
 * Name      : BounderBuffer.java
 * ============================================================================
 */
package concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



class Putter implements Runnable {
    /**
     * @param buffer
     */
    public Putter(BounderBuffer buffer) {
        super();
        this.buffer = buffer;
    }

    private final int MAX_SIZE = 5;
    private BounderBuffer buffer;

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            for (int i = 0; i < MAX_SIZE; i++) {
                System.out.println(Thread.currentThread().getName()+ " putting: " + i);
                buffer.put(Integer.toString(i));
            }
            System.out.println(buffer.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}

class Taker implements Runnable {
    private final int MAX_SIZE = 5;
    private BounderBuffer buffer;
    /**
     * @param buffer
     */
    public Taker(BounderBuffer buffer) {
        super();
        this.buffer = buffer;
    }
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            for (int i = 0; i < MAX_SIZE; i++) {
                System.out.println(Thread.currentThread().getName() + " taking: " + buffer.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}

public class BounderBuffer {
    
    private final int MAX_SIZE = 5;
    private Queue<String> buffer;
    private Lock lock;
    private Condition c1;
    private Condition c2;
    
    public BounderBuffer(Lock l, int size) {
        buffer = new LinkedList<String>();
        lock = l;
        c1 = lock.newCondition();
        c2 = lock.newCondition();
    }

    /**
     * @return
     */
    public int size() {
        return buffer.size();
    }

    public void put(String elem) throws InterruptedException {
        lock.lock();
        try {
            while( buffer.size() == MAX_SIZE ) {
                c1.await();
            }
            buffer.add(elem);
            c2.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String take() throws InterruptedException {
        lock.lock();
        try {
            while (buffer.size() == 0) {
                c2.await();
            }
            String s = buffer.remove();
            c1.signalAll();
            return s;
        } finally {
            lock.unlock();
        }
    }
    
    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        Lock l = new ReentrantLock();
        BounderBuffer buffer = new BounderBuffer(l,5);
        Thread t2 = new Thread(new Taker(buffer));
        t2.start();   
        Thread t1 = new Thread(new Putter(buffer));
        t1.start();
        t2.join();
        System.out.println("T1: " + t1.isAlive()  + " T2: " + t2.isAlive());
    }
    
}


