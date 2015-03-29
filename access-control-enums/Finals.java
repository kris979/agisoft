/* 
 * ============================================================================ 
 * Name      : Finals.java
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

class Based {
    final void f() {
        System.out.println("final");
    }
}
/**
 * 
 *
 */
public class Finals extends Based {
    
    final Object o;

    Finals() {
        o = null;
        System.out.println(o instanceof Object);
        Integer i = 4;
//        o = i;
    }
    
    void method(Object o) {
        System.out.println("Object");
    }

    void method(String s) {
        System.out.println("string");
    }
    
    void method(StringBuffer b) {
        System.out.println("StringBuffer");
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
//        new Finals().method(null);
        new Finals().f();
    }

}
