/* 
  * ============================================================================ 
  * Name      : Day.java
  * ============================================================================
  */
package kataIV;

/**
 * 
 *
 */
public class Day extends AbstractParsedItem {

    /**
     * @param name
     * @param maxTmp
     * @param minTmp
     */
    public Day(String dayNo, int maxTmp, int minTmp) {
        super(dayNo, maxTmp, minTmp);
    }

    /**
     * @return the spread
     */
    public int getSpread() {
        return difference;
    }

    /**
     * @return
     */
    public int getMinTemp() {
        return min;
    }

    /**
     * @return
     */
    public int getMaxTemp() {
        return max;
    }
    
}
