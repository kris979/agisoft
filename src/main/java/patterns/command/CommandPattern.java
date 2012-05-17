/* 
  * ============================================================================ 
  * Name      : CommandPattern.java
  * Part of     :  NEON
  * 
  * Copyright (c) 2007-2011 Nokia.  All rights reserved.
  * This material, including documentation and any related computer
  * programs, is protected by copyright controlled by Nokia.  All
  * rights are reserved.  Copying, including reproducing, storing,
  * adapting or translating, any or all of this material requires the
  * prior written consent of Nokia.  This material also contains
  * confidential information which may not be disclosed to others
  * without the prior written consent of Nokia.
 * 
  * ============================================================================
  */
package patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * The Command Pattern encapsulates a request (ie. move, attack, undo) as an object.
 * We can have many objects representing different requests.
 * This allows us to queue different requests, log them or even support undoable operations.
 */
public class CommandPattern {

    List<Command> commands = new ArrayList<Command>();
    Command undo = null;
    
    
    /**
     * Preperes command receivers. In this case it is actuall command class itself 
     * but concrete commands can also delegate reguests to the receivers...
     *  
     *  for example AttackCommand can delegate an attach to the barbarian or magician etc.
     */
    public void prepareCommands() {
        Command c0 = new UndoCommand();
        Command c1 = new AttackCommand();
        Command c2 = new MoveCommand();
        Command c3 = new AttackCommand();
        Command undo = new UndoCommand();
        Command c4 = new AttackCommand();
        Command c5 = new MoveCommand();
        commands.add(c0);
        commands.add(c1);
        commands.add(c2);
        commands.add(c3);
        commands.add(undo);
        commands.add(c4);
        commands.add(c5);
    }

    public void executeCommands() {
        for (Command c : commands) {
            
            if (undo != null || !(c instanceof UndoCommand)) {
                c.execute();
            }
            
            if (undo != null && c instanceof UndoCommand ) {
                undo.execute();
            } else {
                undo = c;
            }
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        CommandPattern commandPatternDemo = new CommandPattern();
        commandPatternDemo.prepareCommands();
        commandPatternDemo.executeCommands();
    }

}
