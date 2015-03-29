/* 
 * ============================================================================ 
 * Name      : Inner.java
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
public class StaticInner {

    class Inner {
        // static Boolean canNOTBeHere; - statics in a normal innner classes are not allowed
        void print() {
            System.out.println("Inner print");
        }
    }

    static class Inner2 {
        private static Boolean canBeHere = true; // static in static is allowed - right context
        private int counter;

        Inner2(int instance) {
            counter = instance;
        }

        @Override
        public String toString() {
            return "Inner2 [counter=" + counter + "]";
        }

    }

    public static void main(String[] args) {

        // we have got to have instance of Inner in order to instiantiate normal Inner
        Inner inner1 = new StaticInner().new Inner();
        inner1.print();

        // funny way of instiantiating a inner class object
        StaticInner a = new StaticInner();
        Inner inner2 = a.new Inner();
        inner2.print();

        // we dont need to have Inner in order to instantiate static instances of static Inner2
        Inner2 sInner1 = new Inner2(1);
        Inner2 sInner2 = new Inner2(2);

        System.out.println(sInner1);
        System.out.println(sInner2);
        sInner1.counter += 1; // we can access private variable here and increment the counter - it because it is from
                              // main()
                              // I think outside we should not have that access
        System.out.println(sInner1);

        System.out.println("accessing static member of static inner class: " + StaticInner.Inner2.canBeHere);
        
        
        Other other = new Other(new StaticInner());
        other.testAccess();
    }

}

class Other {
    private StaticInner inner;

    /**
     * @param inner
     */
    public Other(StaticInner inner) {
        super();
        this.inner = inner;
    }

    /**
     * 
     */
    public void testAccess() {
        //was trying to access Inner2 private variables from here and as I said above, we can not do that.
        System.out.println(new StaticInner.Inner2(5));
    }

}