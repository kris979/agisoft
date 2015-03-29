/* 
 * ============================================================================ 
 * Name      : PractiseAsserts.java
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

/**
 * @author bliszcza
 *
 */
public class PractiseAsserts {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new PractiseAsserts().go();
    }
    
    void go() {
//        int j = 5/0; //java.lang.ArithmeticException
        int j = 7;
        assert(false): j++; //prints 7 because ++ would take effect after j was used in the expression but expression is throwing AssertionError
        assert(j>8) : j = 10; //that will print 10 next to the java.lang.AssertionError
        assert(j>8) : new PractiseAsserts(); //that will print an object reference
    }

}
