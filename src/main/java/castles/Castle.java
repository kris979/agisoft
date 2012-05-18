/* 
  * ============================================================================ 
  * Name      : Castle.java
  * ============================================================================
  */
package castles;

/**
 * 
 *
 */
public interface Castle {

    /**
     * @param c3
     * @return 
     */
    Boolean connectWith(Castle c);

    /**
     * @param c2
     * @return
     */
    Boolean connnectedWith(Castle c2);

    /**
     * @return
     */
    int getNumberOfSoldiersExpectedToDieDuringAttack();

    /**
     * @return
     */
    int getNumberOfSoldiersRequiredToRemainInCastle();

    
    int getNumberOfSoldiersRequiredToCaptureTheCastle();
    
    /**
     * @return
     */
    String getName();

    /**
     * @param soldiers 
     * @return
     * @throws NotEnoughSoldiersException 
     */
    String capture(int soldiers) throws NotEnoughSoldiersException;

}
