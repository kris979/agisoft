package com.agisoft.threads;

/*
 *          Standard wait idiom:
 * 
 *          synchronized (obj) {
 *              while (condition does not hold) {
 *                  obj.wait();                    - releases obj lock and reacquires it on wakeup.
 *                  //perform action appropriate to condition
 *              }
 *          }
 * 
 */



/**
 * 
 *
 */
public class TestWaitNotify {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        Thread setter = new Thread(new MeasurementsSetter(c));
        Thread drawer = new Thread(new Drawer(c));
        setter.start();
        drawer.start();
    }
}

class Drawer implements Runnable {
    private Calculator cal;
    
    /**
     * @param cal
     */
    public Drawer(Calculator cal) {
        super();
        this.cal = cal;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        synchronized (cal) {
        System.out.println("drawer");
            try {
                while (cal.notReady()) {                    
                    cal.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("drawing circle with radius equal to " + cal.calculate());
        }
    }
}

class MeasurementsSetter implements Runnable {
    private Calculator cal;

    /**
     * @param cal
     */
    public MeasurementsSetter(Calculator cal) {
        super();
        this.cal = cal;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        synchronized (cal) {
            System.out.println("Setting measurements");
            cal.setMeasurements(1, 34);
            cal.notifyAll();
        }
    }

    
}

class Calculator {
    
    int a,b;
    
    public void setMeasurements(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    /**
     * @return
     */
    public boolean notReady() {
        return (a == 0) & (b == 0) ? true : false;
    }

    public int calculate() {
        return a*b;
    }
}
