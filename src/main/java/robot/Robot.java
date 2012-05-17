/* 
  * ============================================================================ 
  * Name      : Robot.java
  * ============================================================================
  */
package robot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 *
 */
public class Robot {
    
    private List<Command> commands = new ArrayList<Command>();

    /**
     * @param command
     */
    public void addCommand(Command command) {
        commands.add(command);
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
