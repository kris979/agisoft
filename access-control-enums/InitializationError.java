/* 
 * ============================================================================ 
 * Name      : InitializationError.java
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
public class InitializationError {

    static int x;
    
    static {
        int [] ia2 = {4,5,6};
    }

    static {
        int[] ia = {1,2,3};
        for (int i = 0; i < ia.length; i++) {
            System.out.println(ia[i] + " ");
        }
        x = 7;
        System.out.println(x);
    }
    
    
    {
        System.out.println("instance block");
    }

}
