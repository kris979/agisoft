/* 
 * ============================================================================ 
 * Name      : StaticsScope.java
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

class Parent {
    static int x = 5;
    
    static int getValue() {
        return x;
    }
}

/**
 * 
 *
 */
public class StaticsScope extends Parent {

    static int a = getValue();         //standard error, getValue() is using x which is not yet initialized, just change the order
    static int x = 10;

    static Object o;
    static String s;
    static int i;
    
    static int getValue() {
        return x;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        if (1023 == 1023) {
            System.out.println("equals");
        }
        System.out.println(a); //prints 0 as when the getValue() method is called x hasn't been initialized yet.
        
        Parent sc = new StaticsScope();
        System.out.println(sc.getValue());
        
        System.out.println(o);
        System.out.println(s);
        System.out.println(i);
    }

}
