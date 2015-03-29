/* 
  * ============================================================================ 
  * Name      : TestMyLinkedList.java
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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 *
 */
public class TestMyLinkedList {
    
    MyLinkedList list = new MyLinkedList();

    /**
     * Test method for {@link listy.MyLinkedList#add(java.lang.Integer)}.
     */
    @Test
    public void testAdd() {
        assertEquals(0, list.size());
        list.add(5);
        assertEquals(1, list.size());
        list.add(1);
        assertEquals(2, list.size());
    }
    
    /**
     * Test method for {@link listy.MyLinkedList#first()}.
     */
    @Test
    public void testFirst() {
        assertEquals(null, list.first());
        list.add(5);
        assertEquals(new Integer(5), list.first());
        list.add(4);
        assertEquals(new Integer(5), list.first());
    }
    
    /**
     * Test method for {@link listy.MyLinkedList#last()}.
     */
    @Test
    public void testLast() {
        assertEquals(null, list.last());
        list.add(5);
        assertEquals(new Integer(5), list.last());
        list.add(4);
        assertEquals(new Integer(4), list.last());
    }
    

    /**
     * Test method for {@link listy.MyLinkedList#next()}.
     */
    @Test
    public void testNext() {
        assertEquals(false, list.hasNext());
        list.add(4); 
        assertEquals(true, list.hasNext());
        assertEquals(new Integer(4), list.next());
        assertEquals(false, list.hasNext());
        list.add(5); 
        assertEquals(true, list.hasNext());
        assertEquals(new Integer(5), list.next());
        assertEquals(false, list.hasNext());
        list.add(6); 
        list.add(7); 
        assertEquals(true, list.hasNext());
        assertEquals(new Integer(6), list.next());
        assertEquals(true, list.hasNext());
        assertEquals(new Integer(7), list.next());
        assertEquals(false, list.hasNext());
    }

    /**
     * Test method for {@link listy.MyLinkedList#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("[]", list.toString());
        list.add(4);
        assertEquals("[4]", list.toString());
        list.add(1);
        assertEquals("[4,1]", list.toString());
    }
//    


}
