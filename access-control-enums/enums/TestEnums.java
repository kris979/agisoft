/* 
 * ============================================================================ 
 * Name      : TestEnums.java
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
package enums;

enum Size {
    SMALL(1), MEDIUM(2), LARGE(3), XL;

    Size(int size) {
        realSize = size;
        System.out.println("Size constructor:" + realSize);
    }

    Size() {
        System.out.println("Default constructor");

    }

    int realSize;
}



class Test {
    int count = 0;
    
    Test() {
        count++;
    }
}

/**
 * 
 *
 */
public class TestEnums {

    static Size s = Size.MEDIUM; // first time we get a size, all size objects are created, constructor called each time
    static Test t,t1;
    
    public static void main(String[] args) {
        t = new Test();
        t1 = new Test();
        System.out.println(t.count + "," + t1.count);
        System.out.println(s.realSize + ":" + s.XL.realSize);
        switch (Size.MEDIUM) {
        case MEDIUM: System.out.println("Medium-switch");
        case LARGE: System.out.println("Large-switch");
        }
    }

}
