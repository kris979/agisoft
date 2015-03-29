package com.agisoft.ikm;
/* 
  * ============================================================================ 
  * Name      : Tokenizer.java
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


import java.util.StringTokenizer;

/**
 * 
 *
 */
public class Tokenizer {

    /**
     * @param args
     */
    public static void main(String[] args) {
//                                                  string delimiter  
// delimiter is not counted as a token
// by default delimiter is " \t\n\r\f"        
        StringTokenizer stk1 = new StringTokenizer("a,b", ","); //2 tokens  a b
        StringTokenizer stk2 = new StringTokenizer(",ab", ","); //1         ab
        StringTokenizer stk3 = new StringTokenizer("ab,", ","); //1         ab
        StringTokenizer stk4 = new StringTokenizer(",ab,", ",");//1         ab
        System.out.println(stk1.countTokens()+" "+stk2.countTokens()+" "+stk3.countTokens()+" "+stk4.countTokens());

    }

}
