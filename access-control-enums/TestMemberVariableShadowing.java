
/* 
 * ============================================================================ 
 * Name      : TestMemberVariableShadowing.java
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

class Super {
    int x = 10;
    static void print() {}
}
/**
 * 
 *
 */
public class TestMemberVariableShadowing extends Super {

    static int x = 11;

    /**
     * @param args
     */
    public static void main(String[] args) {
        new TestMemberVariableShadowing().go();
    }
    
    void go() {
        System.out.println(x);
    }

    static void print() {}                        //- can not override, static methods and vice versa but can SHADOW
}
