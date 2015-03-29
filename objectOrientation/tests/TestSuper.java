/* 
 * ============================================================================ 
 * Name      : TestSuper.java
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
package tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


class Grade {
    static int x = 10;
    static final int y = 45;
    
    protected int play(int x) {
        System.out.println(x);
        return 0;
    }

    Grade(int x) {
        x++;
    }

}


public class TestSuper extends Grade {
    TestSuper(int x) {
        super(y);
        System.out.println(y + "," + x);
    }

//    protected short play(int x) {return 0;}
    
    public static void main(String[] args) {
//        new TestSuper(10).play();
//        System.out.println(super.play(x));
        
          Date aDAte = null;
          Calendar aCalendar = Calendar.getInstance();
          aCalendar.setTimeInMillis(1450000000000L);
          aCalendar.add(Calendar.DAY_OF_MONTH, 60);
          aDAte = aCalendar.getTime();
          System.out.println(new SimpleDateFormat("dd-MMM-yyyy").format(aDAte));
    }
    
}
