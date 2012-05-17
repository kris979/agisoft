/* 
  * ============================================================================ 
  * Name      : AbstractCommand.java
  * ============================================================================
  */
package robot;

/**
 * 
 *
 */
public abstract class AbstractCommand implements Command {

    protected int sourceBlock;
    protected int destinationBlock;

    /**
     * @param sourceBlock
     * @param destinationBlock
     */
    public AbstractCommand(int sourceBlock, int destinationBlock) {
        super();
        this.sourceBlock = sourceBlock;
        this.destinationBlock = destinationBlock;
    }

    /* (non-Javadoc)
     * @see robot.Command#getSrcBlock()
     */
    @Override
    public Integer getSrcBlock() {
        return sourceBlock;
    }

    /* (non-Javadoc)
     * @see robot.Command#getDstBlock()
     */
    @Override
    public Integer getDstBlock() {
        return destinationBlock;
    }

}
