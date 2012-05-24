/* 
  * ============================================================================ 
  * Name      : BuilderPattern.java
  * ============================================================================
  */
package patterns.builder;

/**
 * 
 *
 */
public class BuilderPattern {

    public static void main(String[] args) {
        Warrior.Builder builder = new Warrior.Builder();
        Warrior warrior = builder.name("Conan").equip("Sword").equip("Shield").summon();
        System.out.println(warrior);
        
    }
}
