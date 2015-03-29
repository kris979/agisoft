/* 
 * ============================================================================ 
 * Name      : AccessInInnerClasses.java
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
public class AccessInInnerClasses {

    private boolean canAccess = true;

    private void myMethod() {
        System.out.println("myMethod");
        double[] arr;
//        System.out.println(arr.toString());
    }
    
    public void testAccessFromMethodInnerClass() {
        
        final int x = 10;
        
        class MethodInner {
            MethodInner() {
                System.out.println("method inner class:" + canAccess);
                myMethod();
                System.out.println(x);
            }
        }
        MethodInner mInner = new MethodInner();
        
    }
    
    class Inner {
        boolean innerAccess;
        
        Inner() {
            if (canAccess) {                                    //can access private outer variable
                myMethod();                                     //can access private outer method
                AccessInInnerClasses.this.myMethod();
                System.out.println(AccessInInnerClasses.this.canAccess);
            }
        }
    }
    
    public static void main(String[] args) {
        AccessInInnerClasses.Inner inner = new AccessInInnerClasses().new Inner();
        
        AccessInInnerClasses testAccess = new AccessInInnerClasses();
        testAccess.testAccessFromMethodInnerClass();
    }

}
