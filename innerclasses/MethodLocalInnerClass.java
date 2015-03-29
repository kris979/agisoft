/* 
 * ============================================================================ 
 * Name      : MethodLocalInnerClass.java
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
public class MethodLocalInnerClass {
    
    int x = 10;
    static int y = 5;
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        int j = 5;              //can NOT refer to non-final variable j from methods local inner class
        final int k = 10;       //can access only FINAL local variables that are declared before class definition

        class MethodsLocal {
            int x;
            MethodsLocal() {
                System.out.println("Methods local class");
            }
            
            void testAccess() {
                System.out.println("Methods local class can NOT access: j" /*+ j*/);
                System.out.println("Methods local class can access: k = " + k);
                System.out.println("Methods local class can access outer class private variable x = " + x);
                System.out.println("Methods local class can access outer class static variable y = " + y);
            }
        }
        
        MethodsLocal ml = new MethodsLocal();  //must be instatiated after class definition
        ml.testAccess();
        
        
    }

}
