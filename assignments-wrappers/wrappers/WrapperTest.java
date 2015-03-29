/* 
  * ============================================================================ 
  * Name      : WrapperTest.java
  * Part of     :  H4S
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
package wrappers;

/**
 * @author bliszcza
 *
 */
public class WrapperTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        WrapperTest test = new WrapperTest();
//        test.defaultBooleanIsFalse();
//        test.whichMethodWillBeChosen();
        test.compareWrappers();
//        test.play(); 
    }
    
    void defaultBooleanIsFalse() {
        boolean[] b = new boolean[5];
        System.out.printf("Default boolean is: %b\n",b[0]);
    }

    void whichMethodWillBeChosen() {
        int a = 5;
        System.out.println("Passed int: " + confused(a) + " was chosen");
        Integer b = 5;
        System.out.println("Passed int: " + confused(b) + " was chosen");
    }
    
    void compareWrappers() {
        Byte b = 1;
        Short s = 1;
        Character c = 1;
        Integer i = 1;
        Float f = 1f;
        Double d = 1d;
        
        if (b.equals(s))
            System.out.println("Byte == Short");
        else 
            System.out.println("Byte != Short");
        
        if (c.equals(i)) {
            System.out.println("Character == Short");
        } else {
            System.out.println("Character != Short");
        }
    }
    
    
    void play(){
        int h = 0xcafe;
        String c = "cafe";
        
        int ca = Integer.parseInt(c,16);
        System.out.println(h + " " + c + " in decimal is " + ca);

        Integer caf = Integer.valueOf(c,16);

        String binary_cafe = Integer.toBinaryString(ca); 
        System.out.println("Decimal " + ca + " in binary is " + binary_cafe);

        String hex_cafe = Integer.toHexString(h);
        System.out.println("Hex cafe: " + hex_cafe);
        
        System.out.println("Value of " + c + " is " + caf);
    }

    String confused(byte b) {
        return "byte";
    }
    
    String confused(float f) {
        return "float"; 
    }
}
