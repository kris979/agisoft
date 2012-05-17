package patterns.strategy;

import java.util.logging.Logger;


/**
 * 
 *
 */
public class StrategyPattern {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("Conan", new SwordAttack(), new Run());
        warrior.goIntoBattle();
        warrior.setMoveStrategy(new Walk());
        warrior.goIntoBattle();
    }
}
