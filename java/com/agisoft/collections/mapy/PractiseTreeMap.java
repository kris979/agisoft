/* 
  * ============================================================================ 
  * Name      : PractiseTreeMap.java
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

import java.util.Map;
import java.util.TreeMap;

class Friend implements Comparable<Friend> {
    String name;
    
    public Friend(String name) {
        this.name = name;
    }
    
    public int compareTo(Friend obj) {
        return name.compareTo(obj.name);
    }
}

/**
 * 
 *
 */
public class PractiseTreeMap {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new PractiseTreeMap().go1();
    }

    void go() {
        Map<Friend,Integer> m = new TreeMap<Friend,Integer>();
        m.put(new Friend("Aga"), 21);
        m.put(new Friend("Lamaga"), 21);
        System.out.println(m.get(new Friend("Aga")));
    }
    
    void go1() {
        Map<Integer,String> m = new TreeMap<Integer, String>();
        m.put(1,"Aga");
        System.out.println(m.get(1));
    }
}
