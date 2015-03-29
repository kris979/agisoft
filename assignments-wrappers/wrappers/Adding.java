/* 
  * ============================================================================ 
  * Name      : Adding.java
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
package wrappers;

/**
 * 
 *
 */
public class Adding {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(args.length);
        comparingWrappers();
//        addingDoubleAndInt();
    }

    private static void comparingWrappers() {
        Integer i1 = 20; //will only work for short letters < 128
        Integer i2 = 20;
        System.out.println((i1==i2) + ":" + i1.equals(i2));
        
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println((i3==i4) + ":" + i3.equals(i4));
    }
    
    
    /**
     * 
     */
    private static void addingDoubleAndInt() {
        double d = 234.234;
        double d1 = 234;
        int i = 234;
        
        System.out.println(d+d1+i);
    }

}
