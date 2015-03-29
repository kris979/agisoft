/* 
  * ============================================================================ 
  * Name      : PractiseGenerics3.java
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

import java.util.ArrayList;
import java.util.List;


class A {
    public String toString() {
        return getClass().toString().substring(6);
    }
}
class B extends A{}
class C extends B{}


/**
 * 
 *
 */
public class PractiseGenerics3 {

    public static void main(String[] args) {
        List<A> list = experimentWithGenericMethod(new A());
        list.add(new B());
        list.add(new C());
        System.out.println(list);
    }

    static <T extends A> List<T> experimentWithGenericMethod(T l) {
          List<T> list = new ArrayList<T>();
          return list; 
      }
      
      //    public <X extends V> PractiseGenerics3<? extends V> method(PractiseGenerics3<V super C> e) {
//        return new PractiseGenerics3<V>();
//    }
}
