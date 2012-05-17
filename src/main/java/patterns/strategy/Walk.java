package patterns.strategy;

import java.util.logging.Logger;

/**
 * 
 *
 */
public class Walk implements MoveStrategy {
    
    /**
     * @param logger
     */
    public Walk(Logger logger) {
        super();
        this.logger = logger;
    }


    private final Logger logger;


    /* (non-Javadoc)
     * @see patterns.strategy.MoveStrategy#move()
     */
    @Override
    public void move() {
        logger.info("Walking...");
    }

}
