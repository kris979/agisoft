package patterns.strategy;


/**
 * 
 *
 */
public class Walk implements MoveStrategy {
    
    /**
     */
    public Walk() {
        super();
    }


    /* (non-Javadoc)
     * @see patterns.strategy.MoveStrategy#move()
     */
    @Override
    public void move() {
        System.out.println("Walking...");
    }

}
