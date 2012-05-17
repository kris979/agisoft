/* 
  * ============================================================================ 
  * Name      : Warrior.java
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
package patterns.strategy;


/**
 * 
 *
 */
public class Warrior {
    
    private AttackStrategy attackStrategy;
    private MoveStrategy moveStrategy;
    private String name;
    
    /**
     * @param name
     * @param attackStrategy
     * @param moveStrategy
     */
    public Warrior(String name, AttackStrategy attackStrategy, MoveStrategy moveStrategy) {
        super();
        this.name = name;
        this.attackStrategy = attackStrategy;
        this.moveStrategy = moveStrategy;
    }
    
    public void attack() {
        print();
        attackStrategy.attack();
    }

    
    public void move() {
        print();
        moveStrategy.move();
    }
    
    public void goIntoBattle() {
        prepare();
        move();
        attack();
    }
    
    /**
     * 
     */
    private void prepare() {
        System.out.println(name + " is preparing for battle");
    }

    /**
     * @return the attackStrategy
     */
    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }
    /**
     * @return the moveStrategy
     */
    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param attackStrategy the attackStrategy to set
     */
    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }
    /**
     * @param moveStrategy the moveStrategy to set
     */
    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 
     */
    private void print() {
        System.out.print(name + " is " );
    }
    

}
