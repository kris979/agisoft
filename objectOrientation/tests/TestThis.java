/* 
  * ============================================================================ 
  * Name      : TestThis.java
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
package tests;

class This {
    int x = 10;
    
    static void test(int x) {
        System.out.println("this");
    }
}


class Those extends This {
    
    Those(int x, int y) {
        System.out.println("x=" + x + " y=" +y);
    }
    
    Those(int x) {
        this(x,10);
    }
    
    static void test(int x) {
        System.out.println("Those");
    }
    
    
    void reasign(This t) {
        t.x = 123;        
        t = new This();
        t.x = 321;
    }
}

public class TestThis {

    /**
     * @param args
     */
    public static void main(String[] args) {
        This t = new This();
        System.out.println(t.x + " : " + t);
        final Those those = new Those(1);
        those.reasign(t);
        System.out.println(t.x  + " : " + t);
        
    }

}
