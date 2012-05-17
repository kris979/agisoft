/* 
  * ============================================================================ 
  * Name      : CommandParserTest.java
  * ============================================================================
  */
package robot;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import org.junit.Test;

public class CommandParserTest {
    
    String input = "10\nmove 4 over 3\nmove 2 onto 4\nquit";
    CommandParser parser = new CommandParser(input);


    @Test 
    public void inputShouldBeTheSameAsTestInput() {
        assertThat(parser.getInput(), is(input));
    }
    
    @Test
    public void getNumberOfBlocksTest() {
        assertThat(parser.getNumberOfBlocks(), is(10));
    }
    
    @Test
    public void commandCreationTest() {
        String[] test = {"move","2","over","5"};
        Command command = parser.createCommand(test);
        assertThat(command,is(notNullValue()));
        assertThat(command,is(instanceOf(MoveOverCommand.class)));
        assertThat(command.getSrcBlock(), is(2));
    }
    
    @Test
    public void numberOfCommandsShouldBe2() {
        List<Command> commands = parser.getCommands();
        assertThat(commands,is(notNullValue()));
        assertThat(commands.size(), is(2));
    }
    
    @Test
    public void commandsBlocksAndTypeShouldBeCorrect() {
        List<Command> commands = parser.getCommands();
        assertThat(commands,is(notNullValue()));
        assertThat(commands.size(), is(2));
        Command command = commands.get(0);
        assertThat(command.getSrcBlock(), is(4));
        assertThat(command.getDstBlock(), is(3));
        assertThat(command,is(instanceOf(MoveOverCommand.class)));
        command = commands.get(1);
        assertThat(command.getSrcBlock(), is(2));
        assertThat(command.getDstBlock(), is(4));
        assertThat(command,is(instanceOf(MoveOntoCommand.class)));
    }
    
}
