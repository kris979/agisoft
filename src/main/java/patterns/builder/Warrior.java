/* 
  * ============================================================================ 
  * Name      : Warrior.java
  * ============================================================================
  */
package patterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public class Warrior {
    
    private String name;
    private List<String> equipment = new ArrayList<String>();

    /**
     * @param name2
     * @param equipment2
     * @return
     */
    public static Warrior Summon(String name2, List<String> equipment2) {
        return new Warrior(name2, equipment2);
    }

    /**
     * @param name2
     * @param equipment2
     */
    public Warrior(String name2, List<String> equipment2) {
        this.name = name2;
        this.equipment.addAll(equipment2);
    }

    @Override
    public String toString() {
        return "name: " + name + ", " + equipment.toString();
    }
    /**
     * 
     *
     */
    public static final class Builder {
        
        private String name;
        private List<String> equipment = new ArrayList<String>();
        
        /**
         * @param string
         * @return
         */
        public Builder name(String string) {
            this.name = string;
            return this;
        }

        /**
         * @param string
         * @return
         */
        public Builder equip(String string) {
            equipment.add(string);
            return this;
        }

        /**
         * @return
         */
        public Warrior summon() {
            return Warrior.Summon(this.name, this.equipment);
        }

    }

}
