package patterns.strategy;



/**
 * 
 *
 */
public class StrategyPattern {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("Conan", new SwordAttack(), new Run());
        warrior.goIntoBattle();
        //changing strategy at runtime
        warrior.setMoveStrategy(new Walk());
        warrior.goIntoBattle();
    }
}
