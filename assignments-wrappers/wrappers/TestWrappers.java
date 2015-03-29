/* 
 * ============================================================================ 
 * Name      : TestWrappers.java
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
package wrappers;

import java.util.ArrayList;
import java.util.List;

public class TestWrappers {

    public static void main(String[] args) {
        final TestWrappers testWrappers = new TestWrappers();
        testWrappers.addingToLists();
        testWrappers.integersWrapperMethods();
        testWrappers.characterWrapperMethods();
        testWrappers.wrappersAreEqualWhenTheirPrimitivesAreEqual();
    }

    private void addingToLists() {
        List<Integer> list = new ArrayList<Integer>();

        //adding ints to Integer list - boxing takes place
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        //copying Integers from list to int array
        int[] integerArray = new int[10];
        for (Integer i : list) {
            integerArray[i] = i; //unboxing
            
        }

        //Lng[]  can be ittarated with primitive....
        Long[] longs = new Long[] {new Long(4), new Long(23), new Long(10)};
        for (long long1 : longs) {             
            System.out.print(long1 + ",");
            if (long1 == 4) {
                System.out.print("long1 == 4,");
            }
        }
        System.out.println();
    }

    public void integersWrapperMethods() { 
        Integer i = 5; // autoboxing
        
        // xxxValue() methods are NOT static
        int primitiveInt = i.intValue();
        byte primitiveByte = i.byteValue();
        
        int i1 = Integer.parseInt("10");
        int i2 = Integer.parseInt("101001010101", 2);
        int i3 = Integer.parseInt("cafe", 16);
        
        Integer I1 = Integer.valueOf(5);
        Integer I2 = Integer.valueOf("5");
        
        String hex = Integer.toHexString(51966);
        System.out.println(hex);
    }
    
    public void characterWrapperMethods() {
        char c = '£';
        Character C = c;
        System.out.println((int)c);
    }
    
    public void wrappersAreEqualWhenTheirPrimitivesAreEqual() {
        Integer a = 5;
        Integer b = 5;
        if (a == b)
            System.out.println("equals");
        else
            System.out.println("not equal");
    }
}
