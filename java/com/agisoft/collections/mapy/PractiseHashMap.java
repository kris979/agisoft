/* 
  * ============================================================================ 
  * Name      : PractiseHashMap.java
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

import java.util.HashMap;
import java.util.Map;

class Person {
    String name;
    
    public Person(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Person))
            return false;
        Person other = (Person) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    
}

/**
 * 
 *
 */
public class PractiseHashMap {

    Map<Person,Integer> friends = new HashMap<Person,Integer>();
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        final PractiseHashMap practiseHashMap = new PractiseHashMap();
        practiseHashMap.put();
        assert (20 == practiseHashMap.get());
        practiseHashMap.go1();
        practiseHashMap.canPutNullKey();
    }
    
    void put() {
        Person p = new Person("Aga");
        friends.put(p, 20);
    }
    
    Integer get() {
        Person friend = new Person("Aga");
        return friends.get(friend);
    }
    
    void go1() {
        Map<Integer, String> m = new HashMap<Integer,String>();
        m.put(2,"test");
        assert "test" == m.get(new Integer(2));
    }
    
    void canPutNullKey() {
        friends.put(null, 111);
        assert(111 == friends.get(null));
        System.out.println(friends.get(null));
        
        friends.put(new Person("Kris"), null);
        assert(null == friends.get(new Person("Kris")));
    }

}
