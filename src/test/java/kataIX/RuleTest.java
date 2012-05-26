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
    
    private List<String> itemsToBuy = new ArrayList<String>();
    private DiscountRule ruleA = new DiscountRule("A", 3, 50, 130);
    private DiscountRule ruleWithoutDiscount = new DiscountRule("C", 10);
    private double totalPrice = 100D;

    @Test
    public void testRuleWithoutDiscount() {
        itemsToBuy.add("C");
        double newTotal = ruleWithoutDiscount.applyDiscount(totalPrice, itemsToBuy);
        assertThat(newTotal, is(100D));
    }
    
    @Test
    public void discoutCaclulation1() {
        itemsToBuy.add("A");
        itemsToBuy.add("A");
        itemsToBuy.add("A");
        double newTotal = ruleA.applyDiscount(totalPrice, itemsToBuy);
        assertThat(newTotal, is(80D));
    }
    
    @Test
    public void discoutCaclulation2() {
        itemsToBuy.add("A");
        itemsToBuy.add("B");
        itemsToBuy.add("A");
        double newTotal = ruleA.applyDiscount(totalPrice, itemsToBuy);
        assertThat(newTotal, is(100D));
    }
    
    @Test
    public void discoutCaclulation3() {
        itemsToBuy.add("A");        itemsToBuy.add("B");
        itemsToBuy.add("A");        itemsToBuy.add("B");
        itemsToBuy.add("A");        itemsToBuy.add("B");
        itemsToBuy.add("A");
        double newTotal = ruleA.applyDiscount(totalPrice, itemsToBuy);
        assertThat(newTotal, is(80D));
    }
    
    @Test
    public void discoutCaclulation4() {
        itemsToBuy.add("A");        itemsToBuy.add("B");
        itemsToBuy.add("A");        itemsToBuy.add("B");
        itemsToBuy.add("A");        itemsToBuy.add("B");
        itemsToBuy.add("A");        itemsToBuy.add("A");
        itemsToBuy.add("A");        itemsToBuy.add("A");
        itemsToBuy.add("A");        itemsToBuy.add("A");
        double newTotal = ruleA.applyDiscount(totalPrice, itemsToBuy);
        assertThat(newTotal, is(40D));
    }
}
