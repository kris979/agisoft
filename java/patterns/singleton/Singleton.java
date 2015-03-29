/* 
  * ============================================================================ 
  * Name      : Singleton.java
  * ============================================================================
  */
package patterns.singleton;

import java.io.IOException;
import java.io.Serializable;

import patterns.factory.BarbarianWarrior;
import patterns.factory.Warrior;


/**
 * 
 *
 */
public enum Singleton implements Serializable{

    SINGLE("Kris");
    
    @SuppressWarnings("unused")
	private final String name;
    private int count;

    private Singleton(String name) {
        this.name=name;
    }
    
    public void increment() {
        count++;
    }

    public void showCount() {
        System.out.println(Thread.currentThread().getName() + ":" + count);
    }
    
    public Warrior createWarrior() {
        return new BarbarianWarrior();
    }
    
    
    public static void main(String[] args) throws IOException {
        
        Runnable r = new Runnable() {
            
            @Override
            public void run() {
                Singleton s = Singleton.SINGLE;
                for (int i = 0; i < 10; i++) {
                    s.increment();
                    s.showCount();
                    Thread.yield();
                }
            }
        };
        
        Thread t = new Thread(r);
        Thread t1 = new Thread(r);
        t.start();
        t1.start();

    }
}


