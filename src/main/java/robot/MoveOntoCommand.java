/* 
  * ============================================================================ 
  * Name      : MoveOntoCommand.java
  * ============================================================================
  */
package robot;

/**
 * 
 *
 */
public class MoveOntoCommand extends AbstractCommand {

    /**
     * @param sourceBlock
     * @param destinationBlock
     */
    public MoveOntoCommand(int sourceBlock, int destinationBlock) {
        super(sourceBlock, destinationBlock);
    }
    
    /* (non-Javadoc)
     * @see robot.Command#execute()
     */
    @Override
    public void execute() {
        System.out.println("Moving " + sourceBlock +  " onto " + destinationBlock + "\n");
    }

}
