/* 
  * ============================================================================ 
  * Name      : BinarybinaryChop.chopTest.java
  * ============================================================================
  */
package binarychop;


import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * 
 *
 */
public class BinaryChopTest {
    
    private BinaryChop binaryChop = new BinaryChop();
    
    @Test
    public void binarybinaryChopTest() {
        assertEquals(-1, binaryChop.chop(3, new int[]{}));
        assertEquals(-1, binaryChop.chop(3, new int[]{1}));
        assertEquals(0,  binaryChop.chop(1, new int[]{1}));
        assertEquals(0,  binaryChop.chop(1, new int[]{1, 3, 5}));
        assertEquals(1,  binaryChop.chop(3, new int[]{1, 3, 5}));
        assertEquals(2,  binaryChop.chop(5, new int[]{1, 3, 5}));
        assertEquals(-1, binaryChop.chop(0, new int[]{1, 3, 5}));
        assertEquals(-1, binaryChop.chop(2, new int[]{1, 3, 5}));
        assertEquals(-1, binaryChop.chop(4, new int[]{1, 3, 5}));
        assertEquals(-1, binaryChop.chop(6, new int[]{1, 3, 5}));
        assertEquals(0,  binaryChop.chop(1, new int[]{1, 3, 5, 7}));
        assertEquals(1,  binaryChop.chop(3, new int[]{1, 3, 5, 7}));
        assertEquals(2,  binaryChop.chop(5, new int[]{1, 3, 5, 7}));
        assertEquals(3,  binaryChop.chop(7, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binaryChop.chop(0, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binaryChop.chop(2, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binaryChop.chop(4, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binaryChop.chop(6, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binaryChop.chop(8, new int[]{1, 3, 5, 7}));
    }

}
