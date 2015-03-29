/* 
  * ============================================================================ 
  * Name      : StaticGenerics.java
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
package generics;


class MyStaticGeneric {

//    String member;
//    static T member;    
//    - can not make static reference to non static type
    

//    T getMember() { return new T();}              - can not instantiate T
//    static T getMember() { return new T(); }      - can not make static reference to non static type T
    
    public MyStaticGeneric(String m) {
//        member = m;
    }

    static <T extends Object> void go(T m) {
        System.out.println(m);
    }
    
}

/**
 * 
 *
 */
public class StaticGenerics {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyStaticGeneric sg = new MyStaticGeneric("Kris");
        MyStaticGeneric.go(23423);
    }

}
