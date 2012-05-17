/* 
 * ============================================================================ 
 * Name      : CommandParser.java
 * ============================================================================
 */
package robot;

import java.util.Arrays;
import java.util.List;

/**
 * 
 *
 */
public class CommandParser {

    private String input;
    private int numberOfBlocks;
    private List<Command> commands;

    /**
     * @param input
     */
    public CommandParser(String input) {
        super();
        this.input = input;
        parse();
    }

    private void parse() {
        String[] lines = input.split("\n");
        System.out.println(Arrays.toString(lines));
        setNumberOfBlocks(lines);
        for (int i = 1; i < lines.length - 1; i++) {
            String[] commandString = lines[i].split(" ");
            Command c = createCommand(commandString);
            commands.add(c);
        }

    }

    /**
     * @param command
     * @return
     * @throws NumberFormatException
     */
    private Command createCommand(String[] command) throws NumberFormatException {
        int sourceBlock = Integer.parseInt(command[1]);
        int destinationBlock = Integer.parseInt(command[3]);
        String commandType = command[2];
        
        System.out.println(commandType);
        Command c = CommandFactory.getInstance(commandType, sourceBlock, destinationBlock);
        return c;
    }

    /**
     * @param lines
     * @throws NumberFormatException
     */
    private void setNumberOfBlocks(String[] lines) throws NumberFormatException {
        numberOfBlocks = Integer.parseInt(lines[0]);
    }

    /**
     * @return the input
     */
    public String getInput() {
        return input;
    }

    /**
     * @return the numberOfBlocks
     */
    public int getNumberOfBlocks() {
        return numberOfBlocks;
    }

    /**
     * @return the commands
     */
    public List<Command> getCommands() {
        return commands;
    }

}
