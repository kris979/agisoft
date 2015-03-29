package com.agisoft.ikm;
import java.util.Arrays;

/* 
 * ============================================================================ 
 * Name      : ArrayCopy.java
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

/**
 * 
 *
 */
public class ArrayCopy {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = new int[] { 1,4,5 };
        int[] clone = arr.clone();
        arr[1] = 234;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(clone));
        
        int[] arr1 = arr;
        
        System.out.println(Arrays.toString(arr));
        arr1[1] = 5;
        System.out.println(Arrays.toString(arr));
        
        System.out.println(Arrays.toString(Arrays.copyOf(arr, 10)));
    }

}
