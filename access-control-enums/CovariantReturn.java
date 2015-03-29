/* 
 * ============================================================================ 
 * Name      : CovariantReturn.java
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

class A {
    int x = 1;
}

class B extends A {
    int x = 2;
}

class Base {
    
    A getObject() {
        System.out.println("Base");
        return new B();
    }
}

public class CovariantReturn extends Base {

    B getObject() {
       System.out.println("CovariantReturn");
       return new B(); 
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        Base test = new CovariantReturn();
//        System.out.println(test.getObject() instanceof B);
        A b = test.getObject();
        System.out.println(b instanceof B);
        System.out.println(b.x);
    }
}
