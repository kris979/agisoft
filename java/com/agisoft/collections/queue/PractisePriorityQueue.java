/* 
 * ============================================================================ 
 * Name      : PractisePriorityQueue.java
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
package com.agisoft.collections.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 *
 */
public class PractisePriorityQueue {

    static class PQSort implements Comparator<String> {

        /*
         * (non-Javadoc)
         * 
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }

    }

    static class PQSortInt implements Comparator<Integer> {

        /* (non-Javadoc)
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
        
    }
    
    static String[] letters = { "b", "c", "a", "e", "d" };

    /**
     * @param args
     */
    public static void main(String[] args) {

        PQSort sort = new PQSort();
        PQSortInt sortInt = new PQSortInt();

        PriorityQueue<String> q = new PriorityQueue<String>(letters.length, new PQSort());
        q.addAll(Arrays.asList(letters));
        System.out.print("queue: " + q + "poll: ");
        for (String string : letters) {
            System.out.print(q.poll() + " ");
        }
        System.out.println();
    }

}
