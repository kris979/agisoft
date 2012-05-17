/* 
  * ============================================================================ 
  * Name      : CommandParserTest.java
  * ============================================================================
  */
package robot;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import static org.hamcrest.MatcherAssert.*;
//import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * 
 *
 */
public class CommandParserTest {
    
    String input = "10\nmove 4 over 3\nmove 2 onto 4\nquit";
    CommandParser parser = new CommandParser(input);

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNumberOfBlocksTest() {
//        assertThat(parser.getNumberOfBlocks(), is(10));
        assertEquals(10, parser.getNumberOfBlocks());
    }
    
//    @Test
//    public void numberOfCommandsShouldBeCorrect() {
//        List<Command> commands = parser.getCommands();
//        assertEquals(2, commands.size());
//    }
}
