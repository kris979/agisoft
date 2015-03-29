package com.agisoft.ikm;
import java.util.Formatter;

/* 
 * ============================================================================ 
 * Name      : StringFormatter.java
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
public class StringFormatter {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Formatter fmt = new Formatter();

        StringBuffer sb = new StringBuffer("A");

        fmt.format("%s", sb);

        System.out.println("Line 1 : "+ fmt);

        fmt.format("%s", sb.toString());

        System.out.println("Line 2 : "+ fmt);

        fmt.format("%#s", sb);

        System.out.println("Line 3 : "+ fmt);

        fmt.format("%-10.8s", sb);

        System.out.println("Line 4 : "+ fmt);

    }

}

