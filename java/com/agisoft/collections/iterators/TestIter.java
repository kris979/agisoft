/* 
  * ============================================================================ 
  * Name      : TestIter.java
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
package com.agisoft.collections.iterators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 
 *
 */
public class TestIter {

    
    /**
     * @param args
     */
    public static void main(String[] args) {
        Set s = new HashSet();
        s.add(0);
        s.add(Integer.parseInt("1"));
        doStuff(s);
    }
    
    static void doStuff(Set<Number> s) {
        do2(s);
        Iterator i = s.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        Object[] oa = s.toArray();
    }
    
    static void do2(Set s) {
        System.out.print(s.size() + " ");
    }
    
    void newVsOldListType() {
        List<String> newList = new ArrayList<String>();
        newList.add("JAVA"); newList.add("Mega"); newList.add("AOA"); newList.add("Aeflska");
        for (String string : newList) {
            System.out.print(string + ",");
        }
        System.out.println("\n===========");
        List oldList = new ArrayList();
        oldList.add("JAVA"); oldList.add("Mega"); oldList.add("AOA"); oldList.add("Aeflska");
        for (String string : (List<String>)oldList) {
            System.out.print(string + ",");
        }
    }

}
