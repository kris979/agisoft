/* 
  * ============================================================================ 
  * Name      : RegionImpl.java
  * ============================================================================
  */
package kata.castles;

import java.util.List;

/**
 * 
 *
 */
public class RegionImpl implements Region {
    
    private List<Castle> castles;

    /**
     * @param kata.castles
     */
    public RegionImpl(List<Castle> castles) {
        this.castles = castles; 
    }

    /* (non-Javadoc)
     * @see kata.castles.Region#getMinimumNumberOfSoldiersRequiredToConquerTheRegion()
     */
    @Override
    public int getMinimumNumberOfSoldiersRequiredToConquerTheRegion() {
        int minNumber = 0;
        for (Castle castle : castles) {
            minNumber += castle.getNumberOfSoldiersExpectedToDieDuringAttack();
            minNumber += castle.getNumberOfSoldiersRequiredToRemainInCastle();
        }
        return minNumber;
    }

    /* (non-Javadoc)
     * @see kata.castles.Region#getCapturePlan()
     */
    @Override
    public String getCapturePlan() {
        int soldiers = getMinimumNumberOfSoldiersRequiredToConquerTheRegion();
        String capturePlan = null;
        for (Castle firstCastle : castles) {
            try {
                capturePlan = firstCastle.capture(soldiers);
                if (capturePlan != null) {
                    return capturePlan;
                }
            } catch (NotEnoughSoldiersException e) {
            }
        }
        return capturePlan;
    }


}
