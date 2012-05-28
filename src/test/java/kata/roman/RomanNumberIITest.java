/* 
  * ============================================================================ 
  * Name      : RomanNumberIITest.java
  * ============================================================================
  */
package kata.roman;

import kata.roman.RomanNumberII;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
//import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.*;


/**
 * 
 *
 */
public class RomanNumberIITest {

    RomanNumberII rn = new RomanNumberII();
    
    @Test
    public void convertI() {
        assertEquals(rn.convert("I"),1);
    }
    
    @Test
    public void convertV() {
        assertEquals(rn.convert("V"),5);
    }
    
    @Test
    public void convertX() {
        assertEquals(rn.convert("X"),10);
    }

    @Test
    public void convertIV() {
        assertEquals(rn.convert("IV"),4);
    }
    
    @Test
    public void convertIX() {
        assertEquals(rn.convert("IX"),9);
    }
    
    @Test
    public void convertII() {
        assertEquals(rn.convert("II"),2);
    }
    
    @Test
    public void convertXIV() {
        assertEquals(rn.convert("XIV"),14);
    }
    

    
    @Test
    public void convertXX() {
        assertEquals(rn.convert("XX"),20);
    }
    
    @Test
    public void convertXV() {
        assertEquals(rn.convert("XV"),15);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void convertVX() {
        rn.convert("VX");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void convertXVX() {
        rn.convert("XVX");
    }
    
    @Test
    public void convertXIX() {
        assertEquals(rn.convert("XIX"),19);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void convertIXI() {
        rn.convert("IXI");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void convertIXIX() {
        rn.convert("IXIX");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void convertXIXI() {
        rn.convert("XIXI");
    }
}
