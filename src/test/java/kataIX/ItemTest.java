/* 
  * ============================================================================ 
  * Name      : ItemTest.java
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
public class ItemTest {
    
    private List<String> itemsToBuy = new ArrayList<String>();
    private Item ruleA = new Item("A", 3, 50, 130);
    private Item ruleWithoutDiscount = new Item("C", 10);
    private double totalPrice = 100D;

    @Test
    public void testRuleWithoutDiscount() {
        itemsToBuy.add("C");
        double newTotal = ruleWithoutDiscount.applyDiscount(totalPrice, itemsToBuy);
        assertThat(newTotal, is(100D));
    }
    
    @Test
    public void shouldSubstractOneDiscount() {
        itemsToBuy.add("A");
        itemsToBuy.add("A");
        itemsToBuy.add("A");
        double newTotal = ruleA.applyDiscount(totalPrice, itemsToBuy);
        assertThat(newTotal, is(80D));
    }
    
    @Test
    public void shouldSubstractOneDiscount1() {
        itemsToBuy.add("A");        itemsToBuy.add("B");
        itemsToBuy.add("A");        itemsToBuy.add("B");
        itemsToBuy.add("A");        itemsToBuy.add("B");
        itemsToBuy.add("A");
        double newTotal = ruleA.applyDiscount(totalPrice, itemsToBuy);
        assertThat(newTotal, is(80D));
    }

    @Test
    public void shouldNotSubstractAnything() {
        itemsToBuy.add("A");
        itemsToBuy.add("B");
        itemsToBuy.add("A");
        double newTotal = ruleA.applyDiscount(totalPrice, itemsToBuy);
        assertThat(newTotal, is(100D));
    }
    
    @Test
    public void shouldSubstractThreeDiscounts() {
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
