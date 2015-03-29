/* 
  * ============================================================================ 
  * Name      : TestLogicalOperators.java
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
package operators;

/**
 * @author bliszcza
 *
 */
public class TestLogicalOperators {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Boolean a = true;
        boolean b = true;
        
        if (a == b ) {
            System.out.println(true);
        }
        
        if (a == true | false) {
            System.out.println("Interesting");
        }

    }

}
