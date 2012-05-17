/* 
  * ============================================================================ 
  * Name      : Robot.java
  * ============================================================================
  */
package robot;

import java.util.List;

/**
 * 
 *
 */
public class Robot {
    
    private List<Command> commands;
    private CommandParser parser;

    /**
     * @param input
     */
    public Robot(String input) {
        parser = new CommandParser(input);
        commands = parser.getCommands();
    }


    /**
     * 
     */
    public void executeCommands() {
        for (Command command : commands) {
            command.execute();
        }
    }

}
