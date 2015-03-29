/* 
  * ============================================================================ 
  * Name      : TestConstructor.java
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

public class TestConstructor {
    int z;
    int y = z + 1;
    
    TestConstructor(int x)  {
        System.out.println(x);
        System.out.println(y);
        z=5;
        System.out.println(y);
    }
    
    void print() { 
        System.out.println(y);
        System.out.println(z);
    }
    
    public static void main(String[] args) {
    TestConstructor test = new TestConstructor(10);
    test.print();
    }

}

