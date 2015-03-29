/* 
  * ============================================================================ 
  * Name      : PractiseList.java
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
package com.agisoft.collections.listy;

import java.util.Collections;
import java.util.List;
import java.util.Vector;


class Animal {}
class Cat extends Animal {}
class Dog extends Animal {}

/**
 * A list cares about the index. One thing List has that non-list does not are methods related to index.
 * All list implementations are ordered by index position. 
 *
 *ArrayList     - ordered by index, not sorted, fast iteration and fast random access.
 *
 *Vector        - the same as ArrayList but synchronized, deprecated. dont use it.
 *
 *LinkedList    - Like ArrayList ordered by index. Additionally, elements are doubly-linked which gives new methods 
 *                to add elements on the beginning and the end. May iterate more slowly than ArrayList but gives
 *                better insertion and deletion.
 */
public class PractiseList {
    List<String> arrayList;
    List<String> vector;
    List<String> linkedList;

    /**
     * @param args
     */
    public static void main(String[] args) {
        Vector<String> countries = new Vector<String>();
        countries.add("USA"); 
        countries.add("Russia");
        countries.add("UK");
        countries.add(null);   //can add but throws NullPointerException when iterating 

        List<? extends Object> list = countries;
//        list.add("Poland");
        
        Collections.sort(countries);
        
        for (Object object : list) {
            System.out.println(object);
        }
    }

}
