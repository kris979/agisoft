/* 
  * ============================================================================ 
  * Name      : NavigSet.java
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
package com.agisoft.collections.mapy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * 
 *
 */
public class NavigSet {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new NavigSet().intListToNagivableSet();
    }

    void intListToNagivableSet() {
        List<String> list = new ArrayList<String>();
        list.add("4"); list.add("5"); list.add("6"); list.add("6"); list.add("7");

        NavigableSet set1 = new TreeSet(list);
        Iterator<String> iter = set1.descendingIterator();
        while (iter.hasNext()) {
            String string = (String) iter.next();
            System.out.println(string);
            
        }
        
//        NavigableSet<String> set = new TreeSet<String>(list);
//        for (String string : set) {
//            System.out.print(string);
//        }
//        System.out.println();
//        NavigableSet<String> descending = set.descendingSet();
//        for (String string : descending) {
//            System.out.print(string + ",");
//        }
//        
//        
//        Iterator<String> i = set.descendingIterator();
//        while (i.hasNext()) {
//            String string = (String) i.next();
//            System.out.println(string);
//        }
        
    }
}
