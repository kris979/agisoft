/* 
  * ============================================================================ 
  * Name      : Team.java
  * ============================================================================
  */
package kataIV;

/**
 * 
 *
 */
public class Team extends AbstractParsedItem {

    /**
     * @param name
     * @param forGoals
     * @param againstGoals
     */
    public Team(String name, int forGoals, int againstGoals) {
        super(name, forGoals, againstGoals);
    }
    
    /**
     * @return the forGoals
     */
    public int getForGoals() {
        return max;
    }
    /**
     * @return the againstGoals
     */
    public int getAgainstGoals() {
        return min;
    }
    /**
     * @return the goalDifference
     */
    public int getGoalDifference() {
        return difference;
    }
}
