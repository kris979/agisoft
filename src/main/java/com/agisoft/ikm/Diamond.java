package com.agisoft.ikm;
/* 
  * ============================================================================ 
  * Name      : Diamond.java
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


interface I1 {
    String name = "I1";
    String s1 = "I1.s1";
}

interface I2 {
    String name = "I2";
    String s2 = "I2.s2";
}
    
/**
 * 
 *
 */
public class Diamond implements I1, I2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.print(I1.s1+",");
        System.out.print(I2.s2+",");
        System.out.println(I2.name);
        System.out.println(s1);
        System.out.println(s2);
//        System.out.println(name);            ambiguous so we must explicitly say from which Interface we want ot use it from
        System.out.println(I1.name);
    }

}
