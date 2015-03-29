package com.agisoft.ikm;
/* 
 * ============================================================================ 
 * Name      : NullPointer.java
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
public class NullPointer {
    
    static class Inner {
        static final int x = 5;
    }
    
    public static void main(String[] args) {
        
        testReminder();
//        testOperators();
    }

    /**
     * 
     */
    public static void testReminder() {
        int i=2; int j=0;

        j = ~i + ((++i * ++i) % --i) * ++i;

        System.out.println(j%5);
      
        System.out.println(3%4);
        System.out.println(2%5);
        System.out.println(1%5);
        System.out.println(1%2);
    }

    /**
     * 
     */
    public static void testOperators() {
        int x = 5;
        String str = null;


        //does not test second condition
        if (x == 5 || str.equals("hi")) {
            System.out.print(" Logical OR");
        }

        
        if (x == 5 | str.equals("hi")) {
            System.out.print(" Bitwise OR");
        }
    }
}
