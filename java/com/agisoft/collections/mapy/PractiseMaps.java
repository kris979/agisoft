/* 
  * ============================================================================ 
  * Name      : PractiseMaps.java
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
package com.agisoft.collections.mapy;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/**
 * A MAP maps a unique key (ID) to a specific value(s)
 * Like Sets, Maps rely on equals() method to determine whether two keys are the same or different. 
 * 
 * HashMap - unsorted, unordered map. Use when you don't care about the order when you iterate through it.
 *           As with the HashSet hasCode() is responsible for the place where the key lands - better hashCode()
 *           is equal to a better performance.
 *           
 * LinkedHashMap - like LinkedHashSet it maintains insertion order. Slower than HashMap for adding and removing
 *                  elements but faster when when iterating through elements.            
 */

public class PractiseMaps {
    Map<String,String> hashMap;
    Map<String,String> linkedHashMap;
    Map<String,String> treeMap;

    Random r = new Random();
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        PractiseMaps pm = new PractiseMaps();
        pm.adding();
//        pm.testHashMap();
//        System.out.println("=====================================");
//        pm.testLinkedHashMap();
//        System.out.println("=====================================");
//        pm.testTreeMap();
//        System.out.println("=====================================");
////        pm.whoWillInsertFaster();
    }
    
    void adding() {
        linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("kris", "kris");
        System.out.println(linkedHashMap + " size:" + linkedHashMap.size());
        linkedHashMap.put(null, "a");
        System.out.println(linkedHashMap + " size:" + linkedHashMap.size());
        System.out.println(linkedHashMap.get(null));
    }

    void testHashMap() {
        hashMap = new HashMap<String, String>();
        hashMap.put("name", "Krzysztof");
        hashMap.put("name", "Agnieszka");         
        
        System.out.println("size: " + hashMap.size());        
        System.out.println(hashMap.get("name"));
        System.out.println(hashMap.containsKey("name"));
        //that is not going to work, HashMap stores one value per key.
        //so Krzysztof was replaced by Agnieszka
        System.out.println(hashMap.containsValue("Krzysztof"));
        
        System.out.println("Prining keys:");
        Set<String> keys = hashMap.keySet();
        for (String string : keys) {
            System.out.println(string);
        }
        
        System.out.println("Prining values:");
        Collection<String> values = (Collection<String>)hashMap.values();
        for (String string : values) {
            System.out.println(string);
        }
        
        for (Entry<String,String> e : hashMap.entrySet()) {
            System.out.println(e.toString());
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
    
    void testLinkedHashMap() {
        linkedHashMap = new LinkedHashMap<String, String>();
        for (int i = 0; i < 100; i++) {
            String key = Character.toString((char)r.nextInt(400));
            String value = Character.toString((char)r.nextInt(400));
            linkedHashMap.put(key, value);
        }
//        System.out.println(linkedHashMap.toString());
//        System.out.println(Thread.currentThread().getName());
    }
    
    void testTreeMap() {
        treeMap = new TreeMap<String, String>();
        for (int i = 0; i < 100; i++) {
            String key = Character.toString((char)r.nextInt(400));
            String value = Character.toString((char)r.nextInt(400));
            treeMap.put(key, value);
        }
//        System.out.println(treeMap.toString());
//        System.out.println(Thread.currentThread().getName());
    }
    
    void whoWillInsertFaster(){
        Thread t1 = new Tester1(this);
        t1.setName("LinkedHashMap");
        Thread t2 = new Tester2(this);
        t2.setName("TreeMap");
        t2.start();
        t1.start();
    }

}

class Tester1 extends Thread{
    PractiseMaps pm;
    
    Tester1(PractiseMaps pm) {
        this.pm = pm;
    }
    
    public void run() {
        pm.testLinkedHashMap();
        System.out.println(Thread.currentThread().getName() + " done!");
    }
}

class Tester2 extends Thread{
    PractiseMaps pm;
    
    Tester2(PractiseMaps pm) {
        this.pm = pm;
    }
    
    public void run() {
        pm.testTreeMap();
        System.out.println(Thread.currentThread().getName() + " done!");
    }
}

