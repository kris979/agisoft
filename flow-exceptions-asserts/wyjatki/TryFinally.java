/* 
  * ============================================================================ 
  * Name      : TryFinally.java
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
package wyjatki;


/**
 * 
 *
 */
public class TryFinally {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        try {
//            int i = 2/0;
//            throw new IOException();   - finally does not cut it, catch must be present otherwise compiler error
        } finally {
            System.out.println("in finally");
        }
        
        System.out.println(1%2);
        System.out.println(0%2);
    }

    /**
     * 
     */
    private void sysout() {
        // TODO Auto-generated method stub

    }
    
}
