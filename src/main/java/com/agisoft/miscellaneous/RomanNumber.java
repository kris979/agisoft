/* 
  * ============================================================================ 
  * Name      : RomanNumber.java
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
package com.agisoft.miscellaneous;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 *
 */
public class RomanNumber extends Number {
    /**
     * 
     */
    private static final String IS_NOT_A_VALID_ROMAN_NUMBER = " is not a valid Roman number";
    private static final long serialVersionUID = -419342548143576823L;
    private String romanNumber;
    private char[] characters;
    private Map<Character,Integer> romanNumbers;

    /**
     * @param romanNumber
     */
    public RomanNumber(String romanNumber) {
        super();
        this.romanNumber = romanNumber;
        this.characters = romanNumber.toCharArray();
        this.romanNumbers = new HashMap<Character,Integer>();
        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
    }

    /* (non-Javadoc)
     * @see java.lang.Number#intValue()
     */
    @Override
    public int intValue() {
        Integer next = 0;
        Integer current = convertCharacter(characters[0]);
        Integer previous = 0;
        int result = 0;
        for (int i = 0; i < characters.length; i++) {
            
            if (i < characters.length - 1) {
                next = convertCharacter(characters[i + 1]);
            } else {
                next = 0;
            }
          
            if (previous != 0 && current != 0 && previous < current) {
                if ( (current == next) || (current > next && previous == next) ) {
                    throw new NumberFormatException();
                }
            }
            
            if (next > current) {
                if (previous != 0 && previous <= current) {
                    throw new NumberFormatException();
                } else if (current > 1 && previous == 0) {
                    throw new NumberFormatException();
                }
                result -= current;
            } else if (current == 5 && next == current) {
                throw new NumberFormatException();
            } 
            else {
                result += current;
            }
            
            previous = current;
            current = next;
        }
        return result;
    }

    /**
     * @param romanCharacter
     * @return
     */
    private Integer convertCharacter(Character romanCharacter) {
        Integer result = romanNumbers.get(romanCharacter);
        if (result == null) {
            throw new NumberFormatException();
        }
        return result;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Number#longValue()
     */
    @Override
    public long longValue() {
        // TODO Auto-generated method stub
        return 0;
    }



    /* (non-Javadoc)
     * @see java.lang.Number#floatValue()
     */
    @Override
    public float floatValue() {
        // TODO Auto-generated method stub
        return 0;
    }



    /* (non-Javadoc)
     * @see java.lang.Number#doubleValue()
     */
    @Override
    public double doubleValue() {
        // TODO Auto-generated method stub
        return 0;
    }
}
