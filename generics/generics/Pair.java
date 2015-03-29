/* 
  * ============================================================================ 
  * Name      : Pair.java
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

/**
 * 
 *
 */
public class Pair<K, V> {
    
    K key;
    V value;
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        Pair<Integer,String> pair = new Pair<Integer, String>();
        //here we use a raw type which effectively is Pair<Object,Object>
        //it gives only a warning so legacy, non generic code can interact with generics
        Pair<Integer,String> pair1 = new Pair();               
        pair.setKey(4);
        pair.setValue("cztery");
        System.out.println(pair);

    }


    public K getKey() {
        return key;
    }


    public void setKey(K key) {
        this.key = key;
    }


    public V getValue() {
        return value;
    }


    public void setValue(V value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Pair [key=" + key + ", value=" + value + "]";
    }

}
