/* 
  * ============================================================================ 
  * Name      : AutoboxingTest.java
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
package wrappers;


/**
 * @author bliszcza
 *
 */
public class AutoboxingTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new AutoboxingTest().go();
    }
    
    void go() {
        Integer i = 5;              //autoboxed
        Integer j = 5;              //autoboxed
        Integer k = 128;            //autoboxed
        Integer l = 128;            //autoboxed
        Integer m = new Integer(5);
        System.out.println("1:" + (i==j));   //this is true because values between -127 to 127 are taken from InternalCache so both i and j refer to the same object
        System.out.println("2:" + (k==l));  //this is false because values > 127 are not stored in internal cache
        System.out.println("3:" + (i==m));  //this is false because we compare Integer object references
        System.out.println("4:" + (i.equals(m)));
        System.out.println("5:" + (k.equals(l)));

        
        //Integer i = 10 is not equivalent to Integer i = new Integer(10) because one is going to create a new object
        // whereas other is going to use internal cache object. 
    }

}

