/* 
  * ============================================================================ 
  * Name      : SorcererWarrior.java
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

/**
 * 
 *
 */
public class SorcererWarrior implements Warrior {

    static {
        WarriorFactory.registerNewWarrior(new SorcererWarrior());
    }
    
    /* (non-Javadoc)
     * @see patterns.factory.Warrior#attack()
     */
    @Override
    public void attack() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see patterns.factory.Warrior#move()
     */
    @Override
    public void move() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see patterns.factory.Warrior#summon()
     */
    @Override
    public Warrior summon() {
        return new SorcererWarrior(); 
    }

}
