/* 
  * ============================================================================ 
  * Name      : MoveOverCommand.java
  * ============================================================================
  */
package robot;

/**
 * 
 *
 */
public class MoveOverCommand extends AbstractCommand {
    
    /**
     * @param sourceBlock
     * @param destinationBlock
     */
    public MoveOverCommand(int sourceBlock, int destinationBlock) {
        super(sourceBlock, destinationBlock);
    }

    /* (non-Javadoc)
     * @see robot.Command#execute()
     */
    @Override
    public void execute() {
        System.out.println("Moving " + sourceBlock +  " over " + destinationBlock + "\n");
    }

}
