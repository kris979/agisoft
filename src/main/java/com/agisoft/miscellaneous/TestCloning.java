package com.agisoft.miscellaneous;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* 
 * ============================================================================ 
 * Name      : TestCloning.java
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


class MyClone implements Cloneable {

    String s = "test";
    int i = 4;
    
    public MyClone clone() {
        try {
            return (MyClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "MyClone [s=" + s + ", i=" + i + "]";
    }

}


/**
 * 
 *
 */
public class TestCloning {

    /**
     * @param args
     * @throws NoSuchMethodException 
     * @throws SecurityException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        MyClone c = new MyClone();
        System.out.println(c.s + " " + c.i);
        MyClone clone = (MyClone) c.clone();
        System.out.println(clone.s + " " + clone.i);
        if (clone instanceof Cloneable) {
            Method m = clone.getClass().getMethod("clone");
            boolean accessible = m.isAccessible();
            System.out.println(accessible);
            MyClone clone1 = (MyClone) m.invoke(clone);
            System.out.println(clone1);
        }
    }

}
