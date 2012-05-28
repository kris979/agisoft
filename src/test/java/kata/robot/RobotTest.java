/* 
  * ============================================================================ 
  * Name      : RobotTest.java
  * ============================================================================
  */
package kata.robot;


import kata.robot.Robot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * 
 *
 */
public class RobotTest {
    
    private String input = "10\nmove 4 over 3\nmove 2 onto 4\nquit";
    

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
        Robot r = new Robot(input);
        r.executeCommands();
    }
}
