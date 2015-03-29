/* 
  * ============================================================================ 
  * Name      : TestLiterals.java
  * Part of     :  H4S
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
package assignments;

/**
 * @author bliszcza
 *
 */
public class TestLiterals {

    /**
     * @param args
     */
    public static void main(String[] args) {
        byte a = 5;
        byte b = 6;
        byte c = (byte)(a + b);
        System.out.println(c);
        
        int d = 4;
        byte e = 1;
        int f = d + e;
        System.out.println(f);
        
        float g = 23.434f;
        byte h = 3;
        int i = (int)g + h;
        System.out.println(i);
        
        int j = 012;
        int k = i + j;
        System.out.println(k);
        
        int l = 0xcafe;
        System.out.println(l);
     

    }

}
