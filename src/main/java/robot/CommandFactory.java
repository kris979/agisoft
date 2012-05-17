/* 
  * ============================================================================ 
  * Name      : CommandFactory.java
  * ============================================================================
  */
package robot;

/**
 * 
 *
 */
public class CommandFactory {
    
    /**
     * @param commandType
     * @param sourceBlock
     * @param destinationBlock
     * @return
     */
    public static Command getInstance(String commandType, int sourceBlock, int destinationBlock) {
        if (commandType.equals("over")) {
            return new MoveOverCommand(sourceBlock, destinationBlock);
        } else {
            return new MoveOntoCommand(sourceBlock, destinationBlock);
        }
    }
    
    
}