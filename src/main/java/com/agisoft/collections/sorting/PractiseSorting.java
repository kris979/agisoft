/* 
 * ============================================================================ 
 * Name      : PractiseCollections.java
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
package com.agisoft.collections.sorting;

import java.util.Arrays;
import java.util.Comparator;

class Person {
    private String name;

    public Person(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class PersonComparator implements Comparator<Person> {

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

/**
 * @author bliszcza
 * 
 */
public class PractiseSorting {

    public static void main(String[] args) {
        String[] names = new String[] { "Dorota", "Magda", "Basia", "Asia", "Kasia", "Stasia" };
        // String[] names = new String[] {"JSP","JAVA","Java", "XML", "JXML", "Jxml","BAva", "Bava","java"};
        mustImplementComparable(names);
//         stringBinarySearch(names);
    }

    static void mustImplementComparable(String[] names) {
        Person[] ppl = new Person[] { new Person(names[0]), new Person(names[1]), new Person(names[2]) };

        // expect elements of ppls to implement Comparable otherwise throws ClassCastException
         Arrays.sort(ppl);
        // alternatively we can provide comparator
//        Arrays.sort(ppl, new PersonComparator());
        int index_with_comparator = Arrays.binarySearch(ppl, new Person(names[0]), new PersonComparator());
        int index_without_comparator = Arrays.binarySearch(ppl, new Person(names[0]));
        System.out.println(index_with_comparator + "" + index_without_comparator);
    }

    private static void stringBinarySearch(String[] names) {
        
        /*
         * If Comparator is used to sort then it must be used to search as well.
         * Otherwise unpredictable results is returned, usually negative value.
         * Not an exception or compiler error.
         * 
         * It is different for user defined objects. They must implement java.land.Comparable
         * public int compareTo(T obj) otherwise sort throws ClassCastException. Alternatively, 
         * an instance of java.lang.Comparator should be provided for both sort and binarySearch()
         * methods.
         */
        
        System.out.print("before: " + Arrays.toString(names));
        Arrays.sort(names);
//        Arrays.sort(names, new NameComparator());
        System.out.print("\nafter: " + Arrays.toString(names));
        
        int stasia = Arrays.binarySearch(names, "Stasia");
        int jas = Arrays.binarySearch(names, "Jas");
        
//        int stasia = Arrays.binarySearch(names, "Stasia", new NameComparator()); 
//        int jas = Arrays.binarySearch(names, "Jas", new NameComparator());
        
        System.out.println("\nStasia index: " + stasia + " Jas index: " + jas);
        
        
        
        
    }

    static class NameComparator implements Comparator<String> {

        /* (non-Javadoc)
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
        
    }
}
