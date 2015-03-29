/* 
  * ============================================================================ 
  * Name      : Barbarian.java
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
package patterns.templatemethod;

/**
 * 
 *
 */
public class Barbarian extends Warrior {

    /* (non-Javadoc)
     * @see patterns.templatemethod.Warrior#attack()
     */
    @Override
    protected void attack() {
        System.out.println(getName() + " is attacking with sword");
    }

    /* (non-Javadoc)
     * @see patterns.templatemethod.Warrior#move()
     */
    @Override
    protected void move() {
        System.out.println(getName() + " is running into battle.");
    }

    /* (non-Javadoc)
     * @see patterns.templatemethod.Warrior#prepare()
     */
    @Override
    protected void prepare() {
        System.out.println(getName() + " is sharpening his sword.");
    }

    /**
     * @return
     */
    private String getName() {
        return getClass().getSimpleName();
    }
}
