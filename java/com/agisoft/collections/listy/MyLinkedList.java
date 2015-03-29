/* 
  * ============================================================================ 
  * Name      : MyLinkedList.java
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
package com.agisoft.collections.listy;

/**
 * FIFO
 *
 */
public class MyLinkedList {
    static class Entry {
        Entry next;
        Entry previous;       
        Integer value;
    }
    
    Entry first;
    Entry last;
    
    int index;
    Entry next;
    Entry previous;
    
    public void add(Integer v) {
      Entry e = new Entry();
      e.value = v;
      if (first == null) {
          first = e;
          last = e;
      } else {
          last.next = e;
          e.previous = last;
          last = e;
      }
    }
    
    public Integer first() {
        return first == null ? null : first.value;
    }
    
    public Integer last() {
        return last == null ? null : last.value;
    }
    
    public Integer next() {
        Entry e = first;
        for (int i = 0; i < index; i++) {
            e = e.next;
        }
        index+=1;
        return e.value;
    }
    
    public boolean hasNext() {
        if (first != null) {
            if (index == 0) 
                return true;
            Entry e = first;
            for (int i = 0; i < index-1; i++) {
                e = e.next;
            }
            return e.next != null ? true : false;
        }
        return false;
    }

    public String toString() {
        String s = "[";
        Entry e = first;
        if (e != null) {
            s+=e.value;
            while (e.next != null) {
                e = e.next;
                s+=",";
                s+=e.value;
            }
        }
        s+="]";
        return s;
    }
    
    public int size() {
        if (first == null)
            return 0;
        Entry e = first;
        int size = 1;
        while (e.next != null) {
            size+=1;
            e = e.next;
        }
        return size;
    }
}
