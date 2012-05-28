/* 
 * ============================================================================ 
 * Name      : CastleImplTest.java
 * ============================================================================
 */
package kata.castles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import kata.castles.CastleImpl;
import kata.castles.NotEnoughSoldiersException;

import org.junit.Test;

/**
 * 
 *
 */
public class CastleImplTest {

    
    @Test
    public void captureCastleWithEnoughSoldiers() {
        int enoughSoldiers = 22;
        CastleImpl testCastle = new CastleImpl("One",5,5,5);
        assertThat(testCastle.capture(enoughSoldiers), is("One-12"));
    }

    @Test(expected=NotEnoughSoldiersException.class)
    public void captureCastleWithoutEnoughSoldiers() {
        int notEnoughSoldiers = 3;
        CastleImpl testCastle = new CastleImpl("One",5,5,5);
        testCastle.capture(notEnoughSoldiers);
    }
    
    @Test
    public void captureTwoCastles() {
        int enoughSoldiers = 22;
        CastleImpl testCastle1 = new CastleImpl("One",5,5,5);
        CastleImpl testCastle2 = new CastleImpl("Two",5,1,1);
        testCastle1.connectWith(testCastle2);
        assertThat(testCastle1.capture(enoughSoldiers), is("One-12,Two-10"));
    }

    @Test
    public void captureThreeCastles() {
        int enoughSoldiers = 22;
        CastleImpl testCastle1 = new CastleImpl("One",5,5,5);
        CastleImpl testCastle2 = new CastleImpl("Two",10,5,5);
        CastleImpl testCastle3 = new CastleImpl("Three",5,1,1);
        testCastle1.connectWith(testCastle3);
        testCastle3.connectWith(testCastle2);
        assertThat(testCastle1.capture(enoughSoldiers), is("One-12,Three-10,Two-0"));
    }
}
