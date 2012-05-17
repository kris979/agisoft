/* 
  * ============================================================================ 
  * Name      : WarriorFactory.java
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
package patterns.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 */
public class WarriorFactory {
    

    public static Map<String, Warrior> warriors = new HashMap<String, Warrior>();

    public static void registerNewWarrior(Warrior warrior) {
        warriors.put(warrior.getClass().getName(), warrior);
    }
    
    public static Warrior summonWarrior(Class<? extends Warrior> warriorClass) {
        Warrior warrior = warriors.get(warriorClass.getName());
        return warrior.summon();
    }
    
}
