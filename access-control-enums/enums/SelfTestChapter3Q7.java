/* 
  * ============================================================================ 
  * Name      : SelfTestChapter3Q7.java
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
package enums;

enum Suits {
    CLUBS(20), DIAMONDS(20), NOTRUMP(40) {
        public int getValue(int bid) {
            return ((bid - 1) * 30) + 40;
        }
    };
    
    Suits(int points) {
        this.points = points;
    }
    
    private int points;
    
    public int getValue(int bid) {
        return points * bid;
    }
}

public class SelfTestChapter3Q7 {


    public static void main(String[] args) {
        if (new Integer(1023) == 1023) {
            System.out.println("equal");
        }
        System.out.println(Suits.NOTRUMP.getValue(3));
//        System.out.println(Suits.CLUBS + " " + Suits.CLUBS.points);
        System.out.println(Suits.values());
        Suits[] s = Suits.values();
        for (Suits string : s) {
            System.out.println(string);
        }
    }

}
