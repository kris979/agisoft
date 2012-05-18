/* 
  * ============================================================================ 
  * Name      : CastleImpl.java
  * ============================================================================
  */
package castles;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public class CastleImpl implements Castle {
    
    private String name;
    private int numberOfSoldiersRequiredToCaptureTheCastle;
    private int numberOfSoldiersExpectedToDieDuringAttack;
    private int numberOfSoldiersRequiredToRemainInCastle;
    private List<Castle> roads;
    
    /**
     * @param name
     * @param numberOfSoldiersRequiredToCaptureTheCastle
     * @param numberOfSoldiersExpectedToDieDuringAttack
     * @param numberOfSoldiersRequiredToRemainInCastle
     */
    public CastleImpl(String name, int numberOfSoldiersRequiredToCaptureTheCastle,
            int numberOfSoldiersExpectedToDieDuringAttack, int numberOfSoldiersRequiredToRemainInCastle) {
        super();
        this.name = name;
        this.numberOfSoldiersRequiredToCaptureTheCastle = numberOfSoldiersRequiredToCaptureTheCastle;
        this.numberOfSoldiersExpectedToDieDuringAttack = numberOfSoldiersExpectedToDieDuringAttack;
        this.numberOfSoldiersRequiredToRemainInCastle = numberOfSoldiersRequiredToRemainInCastle;
        roads = new LinkedList<Castle>();
    }

    /* (non-Javadoc)
     * @see castles.Castle#connectWith(castles.Castle)
     */
    @Override
    public Boolean connectWith(Castle c) {
        return roads.add(c);
    }

    /* (non-Javadoc)
     * @see castles.Castle#connnectedWith(castles.Castle)
     */
    @Override
    public Boolean connnectedWith(Castle c2) {
        return roads.contains(c2);
    }

    /* (non-Javadoc)
     * @see castles.Castle#getNumberOfSoldiersExpectedToDieDuringAttack()
     */
    @Override
    public int getNumberOfSoldiersExpectedToDieDuringAttack() {
        return numberOfSoldiersExpectedToDieDuringAttack;
    }

    /* (non-Javadoc)
     * @see castles.Castle#getNumberOfSoldiersRequiredToRemainInCastle()
     */
    @Override
    public int getNumberOfSoldiersRequiredToRemainInCastle() {
        return numberOfSoldiersRequiredToRemainInCastle;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getName();
    }

    /* (non-Javadoc)
     * @see castles.Castle#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
     * @see castles.Castle#getNumberOfSoldiersRequiredToCaptureTheCastle()
     */
    @Override
    public int getNumberOfSoldiersRequiredToCaptureTheCastle() {
        return numberOfSoldiersRequiredToCaptureTheCastle;
    }

    /* (non-Javadoc)
     * @see castles.Castle#capture(int)
     */
    @Override
    public String capture(int soldiers) throws NotEnoughSoldiersException {
        if (soldiers < numberOfSoldiersRequiredToCaptureTheCastle) {
            throw new NotEnoughSoldiersException();
        }
        int totalSoldiersRequiredToCaptureThisCastle = numberOfSoldiersExpectedToDieDuringAttack + numberOfSoldiersRequiredToRemainInCastle;
        int soldiersLeft = soldiers - totalSoldiersRequiredToCaptureThisCastle;
        String capturePlan = getName() + "-" + soldiersLeft;
        if (isConnected()) {
            capturePlan+=",";
            Castle nextCasleToCapture = roads.get(0);
            return capturePlan + nextCasleToCapture.capture(soldiersLeft);
        } else {
            return capturePlan;
        }
    }

    /**
     * @return
     */
    private boolean isConnected() {
        return roads.size() > 0;
    }


}
