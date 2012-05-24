/* 
  * ============================================================================ 
  * Name      : RuleTest.java
  * ============================================================================
  */
package kataIX;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * 
 *
 */
public class RuleTest {
    
    private List<String> items = new ArrayList<String>();
    private Rule rule = new RuleImpl("A", 3, 50, 130);
    private double currentTotalPrice = 100D;

    @Test
    public void discoutCaclulation1() {
        items.add("A");
        items.add("A");
        items.add("A");
        double newTotal = rule.applyDiscount(currentTotalPrice, items);
        assertThat(newTotal, is(80D));
    }
    
    @Test
    public void discoutCaclulation2() {
        items.add("A");
        items.add("B");
        items.add("A");
        double newTotal = rule.applyDiscount(currentTotalPrice, items);
        assertThat(newTotal, is(100D));
    }
    
    @Test
    public void discoutCaclulation3() {
        items.add("A");        items.add("B");
        items.add("A");        items.add("B");
        items.add("A");        items.add("B");
        items.add("A");
        double newTotal = rule.applyDiscount(currentTotalPrice, items);
        assertThat(newTotal, is(80D));
    }
    
    @Test
    public void discoutCaclulation4() {
        items.add("A");        items.add("B");
        items.add("A");        items.add("B");
        items.add("A");        items.add("B");
        items.add("A");        items.add("A");
        items.add("A");        items.add("A");
        items.add("A");        items.add("A");
        double newTotal = rule.applyDiscount(currentTotalPrice, items);
        assertThat(newTotal, is(40D));
    }
}
