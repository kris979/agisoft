/* 
  * ============================================================================ 
  * Name      : PractiseTreeSet.java
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
package com.agisoft.collections.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 *
 */
public class PractiseTreeSet {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final PractiseTreeSet practiseTreeSet = new PractiseTreeSet();
//        practiseTreeSet.go();
        practiseTreeSet.iterating();
    }
    
    void iterating() {
        Set<Integer> set = new TreeSet<Integer>();
        set.add(1); set.add(43); set.add(4345); set.add(new Integer(20));
        Iterator iter = set.iterator();
    }
    
    
    void go() {
        Set<String> s = new LinkedHashSet<String>();
        s.add("-");
        s.add("a");
        s.add("z");
        s.add("123");
        s.add("X");
        s.add("A");

        
        for (String integer : s) {
            System.out.print(integer + ",");
        }
        
        System.out.println("\n------------");
        
        Set<String> s1 = new HashSet<String>(s);
        for (String integer : s1) {
            System.out.print(integer + ",");
        }
        
        System.out.println("\n------------");
        
        TreeSet<String> s2 = new TreeSet<String>(s);
        for (String integer : s2) {
            System.out.print(integer + ",");
        }
    }

}
