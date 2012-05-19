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
    public void recursiveChopTest() {
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
        assertEquals(7, binaryChop.chop(9, new int[]{1, 2, 3, 4, 5, 7, 8, 9}));
    }

    @Test
    public void iterativeChopTest() {
        assertEquals(-1, binaryChop.iterativeChop(3, new int[]{}));
        assertEquals(-1, binaryChop.iterativeChop(3, new int[]{1}));
        assertEquals(0,  binaryChop.iterativeChop(1, new int[]{1}));
        assertEquals(0,  binaryChop.iterativeChop(1, new int[]{1, 3, 5}));
        assertEquals(1,  binaryChop.iterativeChop(3, new int[]{1, 3, 5}));
        assertEquals(2,  binaryChop.iterativeChop(5, new int[]{1, 3, 5}));
        assertEquals(-1, binaryChop.iterativeChop(0, new int[]{1, 3, 5}));
        assertEquals(-1, binaryChop.iterativeChop(2, new int[]{1, 3, 5}));
        assertEquals(-1, binaryChop.iterativeChop(4, new int[]{1, 3, 5}));
        assertEquals(-1, binaryChop.iterativeChop(6, new int[]{1, 3, 5}));
        assertEquals(0,  binaryChop.iterativeChop(1, new int[]{1, 3, 5, 7}));
        assertEquals(1,  binaryChop.iterativeChop(3, new int[]{1, 3, 5, 7}));
        assertEquals(2,  binaryChop.iterativeChop(5, new int[]{1, 3, 5, 7}));
        assertEquals(3,  binaryChop.iterativeChop(7, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binaryChop.iterativeChop(0, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binaryChop.iterativeChop(2, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binaryChop.iterativeChop(4, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binaryChop.iterativeChop(6, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binaryChop.iterativeChop(8, new int[]{1, 3, 5, 7}));
        assertEquals(7, binaryChop.iterativeChop(9, new int[]{1, 2, 3, 4, 5, 7, 8, 9}));
    }
}
