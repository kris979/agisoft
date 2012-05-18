/* 
  * ============================================================================ 
  * Name      : RegionTest.java
  * ============================================================================
  */
package castles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


/**
 * 
 *
 */
public class RegionTest {
    
    private Region region;
    

    @Before
    public void prepareTestRegion() {
        Castle c1 = new CastleImpl("One",5,5,5);
        Castle c2 = new CastleImpl("Two",10,5,5);
        Castle c3 = new CastleImpl("Three",5,1,1);
        c1.connectWith(c3);
        c3.connectWith(c1);
        c2.connectWith(c3);
        c3.connectWith(c2);
        List<Castle> castles = new LinkedList<Castle>();
        castles.add(c1);
        castles.add(c2);
        castles.add(c3);
        assertThat(c1.connnectedWith(c2), is(false));
        assertThat(c1.connnectedWith(c3), is(true));
        assertThat(c3.connnectedWith(c1), is(true));
        assertThat(c3.connnectedWith(c2), is(true));
        assertThat(c2.connnectedWith(c1), is(false));
        assertThat(c2.connnectedWith(c3), is(true));
        region = new RegionImpl(castles);
    }
    
    @Test 
    public void getMinimumNumberOfSoldiersRequiredToConquerTheRegion() {
        assertThat(region,is(notNullValue()));
        assertThat(region.getMinimumNumberOfSoldiersRequiredToConquerTheRegion(), is(22));
    }
    
    @Test
    public void getCapturePlanTest() {
        assertThat(region.getCapturePlan(), is("2-3-1"));
    }
    

    
    
}
