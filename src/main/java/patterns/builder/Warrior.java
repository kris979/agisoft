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
public final class Warrior {
    
    private final String name;
    private final List<String> equipment = new ArrayList<String>();

    /**
     * @param name2
     * @param equipment2
     */
    private Warrior(String name2, List<String> equipment2) {
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
            return new Warrior(this.name, this.equipment);
        }

    }

}
