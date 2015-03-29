/* 
  * ============================================================================ 
  * Name      : AsList.java
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *
 */
public class AsList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Integer[] array = {3,1,4,1};
        list = Arrays.asList(array);
        array[3] = 2;
        list.set(0, 7);
        System.out.println("list:" + list);
        System.out.println("array:" + Arrays.toString(array));
        list.add(9);                                         // throws java.lang.UnsupportedOperationException
        System.out.println("list:" + list);
        
        
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1); list1.add(2);
        Integer[] arr = list1.toArray(new Integer[0]);
        arr[0] = 5;
        System.out.println(Arrays.toString(arr));
        list1.add(234);
        System.out.println(list1);
        System.out.println(Arrays.toString(arr));
    }
}
