package com.agisoft.collections.listy;
import java.util.ArrayList;
import java.util.List;

/* 
 * ============================================================================ 
 * Name      : TestLinkedList.java
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

enum Grade { A, B { public String toString() {return "Book";}} , C, D }


class Shape {}
class Rect extends Shape {}

/**
 * 
 *
 */
public class TestLinkedList {
    
    Number value;
    Number previous;
    Number next;
    Number first;
    
    static {
        int x = 4;
    }
    
    static int x;

//    below won't compile as it is virtually the same method
//    public static void print(String[] args) {
//        System.out.println("test");
//    }
//    
//    public static void print(String...args) {
//        System.out.println("test");
//    }
    
    
    static void add(List<? extends Number> l, Number elem) {
//        l.add(elem);
    }
    
    public static void main(String[] args) {
        java.util.LinkedList<Integer> l = new java.util.LinkedList<Integer>();
        l.add(2);
        l.addLast(10);
        l.add(23);

        System.out.println(x);
        System.out.println(l);
        
        System.out.println(l.indexOf(23));
        System.out.printf("list size: %s \n", l.size());
        
        Grade d = Grade.B;
        
        switch(d) {
        case A: System.out.println("Grade A"); break;
        case B: System.out.println(Grade.B); break;
        default: 
            System.out.println("Enough");
        }

        List<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(5));
        add(list, new Integer(4));
        
    }

}
