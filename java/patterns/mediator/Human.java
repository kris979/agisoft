/* 
  * ============================================================================ 
  * Name      : Human.java
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
package patterns.mediator;

/**
 * 
 *
 */
public class Human extends Race implements NegotiableRace {

    /**
     * @param m
     */
    Human(Mediator m) {
        super(m);
    }

    /* (non-Javadoc)
     * @see patterns.mediator.NegotiableRace#negotiate()
     */
    @Override
    public void negotiate() {
        System.out.println(getClass().getSimpleName() + " does not negotiate with Zerg");
    }

    /* (non-Javadoc)
     * @see patterns.mediator.NegotiableRace#stopNegotiations()
     */
    @Override
    public void stopNegotiations() {
        // TODO Auto-generated method stub
        
    }

}
