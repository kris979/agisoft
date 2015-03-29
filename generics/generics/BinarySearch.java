/* 
  * ============================================================================ 
  * Name      : BinarySearch.java
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

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * 
 *
 */
public class BinarySearch {

    Integer[] array = {2,4,56,435,345,234,23};
    List<Integer> l = new Vector<Integer>(Arrays.asList(array));
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        final BinarySearch binarySearch = new BinarySearch();
        binarySearch.go();
        binarySearch.convert();
    }

    /**
     * 
     */
    void go() {
        java.util.Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int index = Arrays.binarySearch(array, 23);
        System.out.printf("23 at index: %d\n",index);
        index = Arrays.binarySearch(array, 0);
        System.out.printf("0 at index: %d\n",index);
        index = Arrays.binarySearch(array, 100);
        System.out.printf("100 at index: %d\n",index);
    }
    
    
    void convert() {
        Integer[] s = l.toArray(new Integer[0]);
        System.out.println(Arrays.toString(s));
    }
}
