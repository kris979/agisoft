/* 
  * ============================================================================ 
  * Name      : TestSwitchStatement.java
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
package flow;

/**
 * 
 *
 */
public class TestSwitchStatement {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String r = "-";
        char[] c = {'a','b','c','z'};
        for(char c1: c) 
            switch(c1) {
                case 'a': r+="a";
                case 'b': r+="b"; break;
                default:  r+="X";          //z will skip default
                case 'z': r+="z";
              }
        System.out.println(r);   
    }

}
