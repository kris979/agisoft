/* 
  * ============================================================================ 
  * Name      : MoveOverCommand.java
  * ============================================================================
  */
package kata.robot;

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
     * @see kata.robot.Command#execute()
     */
    @Override
    public void execute() {
        System.out.println("Moving " + sourceBlock +  " over " + destinationBlock + "\n");
    }

}
