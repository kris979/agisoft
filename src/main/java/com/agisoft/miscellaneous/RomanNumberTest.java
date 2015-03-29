/* 
  * ============================================================================ 
  * Name      : RomanNumberConverterTest.java
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


import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 *
 */
public class RomanNumberTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void I_is_1() {
        RomanNumber c = new RomanNumber("I");
        int result = c.intValue();
        assertEquals(1,result);
    }
    
    @Test
    public void II_is_2() {
        RomanNumber c = new RomanNumber("II");
        int result = c.intValue();
        assertEquals(2,result);
    }
    
    @Test
    public void III_is_3() {
        RomanNumber c = new RomanNumber("III");
        int result = c.intValue();
        assertEquals(3,result);
    }
    
    @Test
    public void IV_is_4() {
        RomanNumber c = new RomanNumber("IV");
        int result = c.intValue();
        assertEquals(4,result);
    }
    
    @Test
    public void V_is_5() {
        RomanNumber c = new RomanNumber("V");
        int result = c.intValue();
        assertEquals(5,result);
    }
    
    @Test
    public void VI_is_6() {
        RomanNumber c = new RomanNumber("VI");
        int result = c.intValue();
        assertEquals(6,result);
    }
    
    @Test
    public void VII_is_7() {
        RomanNumber c = new RomanNumber("VII");
        int result = c.intValue();
        assertEquals(7,result);
    }
    
    @Test
    public void VIII_is_8() {
        RomanNumber c = new RomanNumber("VIII");
        int result = c.intValue();
        assertEquals(8,result);
    }
    
    @Test
    public void IX_is_9() {
        RomanNumber c = new RomanNumber("IX");
        int result = c.intValue();
        assertEquals(9,result);
    }
    
    @Test
    public void X_is_10() {
        RomanNumber c = new RomanNumber("X");
        int result = c.intValue();
        assertEquals(10,result);
    }
    
    @Test
    public void XI_is_11() {
        RomanNumber c = new RomanNumber("XI");
        int result = c.intValue();
        assertEquals(11,result);
    }
    
    @Test
    public void XII_is_12() {
        RomanNumber c = new RomanNumber("XII");
        int result = c.intValue();
        assertEquals(12,result);
    }
    
    @Test
    public void XIII_is_13() {
        RomanNumber c = new RomanNumber("XIII");
        int result = c.intValue();
        assertEquals(13,result);
    }
    
    @Test
    public void XIV_is_14() {
        RomanNumber c = new RomanNumber("XIV");
        int result = c.intValue();
        assertEquals(14,result);
    }
    
    @Test
    public void XV_is_15() {
        RomanNumber c = new RomanNumber("XV");
        int result = c.intValue();
        assertEquals(15,result);
    }
    
    @Test
    public void XVI_is_16() {
        RomanNumber c = new RomanNumber("XVI");
        int result = c.intValue();
        assertEquals(16,result);
    }
    
    @Test
    public void XIX_is_19() {
        RomanNumber c = new RomanNumber("XIX");
        int result = c.intValue();
        assertEquals(19,result);
    }
    
    @Test
    public void XX_is_20() {
        RomanNumber c = new RomanNumber("XX");
        int result = c.intValue();
        assertEquals(20,result);
    }

    @Test
    public void XXII_is_22() {
        RomanNumber c = new RomanNumber("XXII");
        int result = c.intValue();
        assertEquals(22,result);
    }
    
    @Test
    public void XXIX_is_29() {
        RomanNumber c = new RomanNumber("XXIX");
        int result = c.intValue();
        assertEquals(29,result);
    }
    
    /*
     * 
     * Negative tests
     * 
     */
    
    @Test(expected = NumberFormatException.class)
    public void wrongNumber() {
        RomanNumber c = new RomanNumber("A");
        int result = c.intValue();
    }
    
    @Test(expected = NumberFormatException.class)
    public void wrongNumberVX() {
        RomanNumber c = new RomanNumber("VX");
        int result = c.intValue();
    }
    
    @Test(expected = NumberFormatException.class)
    public void wrongNumberIIX() {
        RomanNumber c = new RomanNumber("IIX");
        int result = c.intValue();
    }
    
    @Test(expected = NumberFormatException.class)
    public void wrongNumberIIV() {
        RomanNumber c = new RomanNumber("IIV");
        int result = c.intValue();
    }
    
    @Test(expected = NumberFormatException.class)
    public void wrongNumberIIIV() {
        RomanNumber c = new RomanNumber("IIIV");
        int result = c.intValue();
    }
    
    @Test(expected = NumberFormatException.class)
    public void wrongNumberVV() {
        RomanNumber c = new RomanNumber("VV");
        int result = c.intValue();
    }
    
    @Test(expected = NumberFormatException.class)
    public void wrongNumberIXI() {
        RomanNumber c = new RomanNumber("IXI");
        int result = c.intValue();
    }
    
    @Test(expected = NumberFormatException.class)
    public void wrongNumberXIXX() {
        RomanNumber c = new RomanNumber("XIXX");
        int result = c.intValue();
    }
    
    @Test(expected = NumberFormatException.class)
    public void wrongNumberXIIXX() {
        RomanNumber c = new RomanNumber("XIIXX");
        int result = c.intValue();
    }
    
    /*
     * 
     * Test coversion
     * 
     */
    
    @Test
    public void convertValidCharacter() throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        RomanNumber c = new RomanNumber("X");
        Method convertChar = RomanNumber.class.getDeclaredMethod("convertCharacter", Character.class);
        convertChar.setAccessible(true);
        int x = (Integer) convertChar.invoke(c, 'X');
        assertEquals(10,x);
    }
}
