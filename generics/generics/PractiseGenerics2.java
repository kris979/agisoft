/* 
  * ============================================================================ 
  * Name      : PractiseGenerics2.java
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
package generics;

import java.util.ArrayList;
import java.util.List;

class Base {}
class Level extends Base {}
class Maze extends Level {}

/**
 * 
 *
 */
public class PractiseGenerics2 {

    public static void main(String[] args) {
        new PractiseGenerics2().go();
    }
    
    void go() {
        List<Level> list = new ArrayList<Level>();
        list.add(new Level());
        list.add(new Maze());
        read1(list);
        read2(list);
    }

    void read0(List<Base> l) {
        Base b = l.get(0);
    }
    
    void read1(List<? extends Level> l) {
        Base b = l.get(0);
        Level ll = l.get(0);
//        Maze m = l.get(0);
//        l.add(new Base());
//        l.add(new Level());
    }
    
    void read2(List<? super Level> l) {
        Base b = (Base)l.get(0);
        Level ll = (Level)l.get(0);
        Maze m = (Maze)l.get(0);
        l.add(new Maze());
        l.add(new Level());
//        l.add(new Base());
    }
}
