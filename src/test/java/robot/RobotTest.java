/* 
  * ============================================================================ 
  * Name      : RobotTest.java
  * ============================================================================
  */
package robot;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 *
 */
public class RobotTest {
    

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
    public void robotShouldExecuteAllCommands() {
        Robot r = new Robot();
        Command testCommand = new MoveOverCommand(0, 0);
        r.addCommand(testCommand);
        r.executeCommands();
    }
}
