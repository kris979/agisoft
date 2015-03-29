/* 
  * ============================================================================ 
  * Name      : TestCasting.java
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

interface I {}
class Base implements I {}
class Derived extends Base {}


class A {}
class B extends A {int x = 5;}
class C extends A {}

/**
 * 
 *
 */
public class TestCasting {

    /**
     * @param args
     */
    public static void main(String[] args) {
//        test1();
        test2();
        
        System.out.println("ok");
    }
    
    static void test1() {
        Base b = new Base();
        Base b1 = new Derived();
        
//        Derived db = (Derived)b;    //ClassCastException is throws
        Derived db1 = (Derived)b1;   //compiles and runs just fine

        Derived d = new Derived();
        I i = b;
        i = (Base)d;
        b = (Base)i;
    }
    
    static void test2() {
        A a = new A();
        B b = new B();
        C c = new C();
        
        boolean bool;
//        c = a; //not a cast problem but incompatibile assignment to the reference
        b = (B)a;  //java.lang.ClassCastException
//        b = a;     // compilation error, cast is required
        a = b;
//        c = (C)b; //can not cast from B to C - there is no relationshipt between those types
//        b = (A)b; //not a cast problem but incompatibile assignment to the reference
        
    }

}
