/* 
  * ============================================================================ 
  * Name      : NavigableMapWithStrings.java
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
import java.util.NavigableMap;
import java.util.TreeMap;

interface I {
    double d = 34.534;
}

class A{
    double dd = I.d;
}

public class NavigableMapWithStrings {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new NavigableMapWithStrings().integerStringKeys();
        
        A a = new A();
        A b = a;
        System.out.println(a.hashCode() + ":" + b.hashCode());
        System.out.println(a.dd);
        
    }

    void integerStringKeys() {
        NavigableMap<String,Integer> map = new TreeMap<String,Integer>();
        map.put("10", 3);
        map.put("1",10);
        map.put("3", 40);
        map.put("30", 30);
        map.put("4",300);
        System.out.println(map.toString());
        Map.Entry<String,Integer> entry = map.lastEntry();
        System.out.println(entry.getKey());
    }
}
