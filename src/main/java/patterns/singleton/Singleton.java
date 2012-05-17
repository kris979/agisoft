/* 
  * ============================================================================ 
  * Name      : Singleton.java
  * ============================================================================
  */
package patterns.singleton;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import patterns.factory.BarbarianWarrior;
import patterns.factory.Warrior;
import patterns.templatemethod.Barbarian;


/**
 * 
 *
 */
public enum Singleton implements Serializable{

    SINGLE("Kris");
    
    private String name;
    private int count;

    Singleton(String name) {
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
        
        FileOutputStream out = new FileOutputStream("enum");
        ObjectOutputStream oo = new ObjectOutputStream(out);
        oo.writeObject(SINGLE);
        oo.close();
        
        Runnable r = new Runnable() {
            
            @Override
            public void run() {
                Singleton s = Singleton.SINGLE;
                for (int i = 0; i < 100; i++) {
                    s.increment();
                    s.showCount();
                    Thread.yield();
                }
            }
        };
        
        Runnable r1 = new Runnable() {
            
            @Override
            public void run() {
                Singleton s = Singleton.SINGLE;
                for (int i = 0; i < 100; i++) {
                    s.increment();
                    s.showCount();
                    Thread.yield();
                }
            }
        };
        
        Thread t = new Thread(r);
        Thread t1 = new Thread(r1);
        t.start();
        t1.start();

    }
}


