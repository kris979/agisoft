/* 
  * ============================================================================ 
  * Name      : TestInstaceOf.java
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
package operators;

/**
 * @author bliszcza
 *
 */
public class TestInstaceOf {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int i = 4;
        Integer j = new Integer(i);
        long k = 4;
        Long l = new Long(k);
        Object ooo = 4;

//        won't compile as instanceof can't test primitive types
//        if (i instanceof Integer) {   
//            System.out.println(i + "is instance of Integer");
//        }

//        if (i instanceof ooo) {
//            System.out.println(j + " is instance of Integer");
//        }#l

        if (j instanceof Object) {
            System.out.println("Integer: " + j + " is instance of Object");            
        }
        
        //primitive int and Integer object
        if (i == j) {
            System.out.println("integer can be compared with Integer");
        }
        
        //primitive int and primitive long
        if (i == k) {
            System.out.println("integer can be compared with long");                       
        }
        
        //primitive int and Long object
        if (i == l) {
            System.out.println("integer can be compared with Long");                                   
        }
        
        //but everything is an object
        Object o = l;
        System.out.println(o);
        Object oo = k; //long is autoboxed to Long
        System.out.println(oo instanceof Long && oo instanceof Object);
        
//        if (ooo instanceof int) {
//            System.out.println("ooo isn't int");
//        }
//        
        if (ooo instanceof Integer) {
            System.out.println("ooo is a Integer");
        }

    }

}
