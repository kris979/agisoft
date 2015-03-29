/* 
  * ============================================================================ 
  * Name      : GenericMethods.java
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


class GenericMethodWithoutGenericClass {
    
    //even with constructor type must be defined if class is not generic
    public <T> GenericMethodWithoutGenericClass(T elem) {
        System.out.println("generic elem: " + elem);
    }
}


/**
 * 
 *
 */
public class GenericMethods<T> {
    
    //T does not need to be defined before return type because it has already been declared as a class type.
    List<T> addToList(T elem) {
        List<T> list = new ArrayList<T>();
        list.add(elem);
        return list;
    }
    
    
    //there must be <Y> before return type because Y type has not been defined in the class.
    <Y> List<Y> addToOtherList(Y elem) {
        List<Y> list = new ArrayList<Y>();
        list.add(elem);
        return list;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new GenericMethods<Integer>().addToList(4);
        System.out.println(list);
    }

}
