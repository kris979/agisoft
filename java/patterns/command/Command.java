/* 
 * ============================================================================ 
 * Name      : Command.java
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

/**
 * Interface for all the commands.
 * 
 * Concreate class implementing this interface executes a real action (ie. move or attack). It can either delegate a
 * request further to the action receiver (ie. barbarian, magican etc.) or do the job itself.
 * 
 * - encapsulate a request in an object - allows the parameterization of clients with different requests - allows saving
 * the requests in a queue
 * 
 * The Macro represents, at some extent, a command that is built from the reunion of a set of other commands, in a given
 * order. Just as a macro, the Command design pattern encapsulates commands (method calls) in objects allowing us to
 * issue requests without knowing the requested operation or the requesting object. Command design pattern provides the
 * options to queue commands, undo/redo actions and other manipulations.
 * 
 * The main advantage of the command design pattern is that it decouples the object that invokes the operation from the
 * one that know how to perform it. And this advantage must be kept. There are implementations of this design pattern in
 * which the invoker is aware of the concrete commands classes. This is wrong making the implementation more tightly
 * coupled. The invoker should be aware only about the abstract command class.
 */
public interface Command {

    public void execute();

}
