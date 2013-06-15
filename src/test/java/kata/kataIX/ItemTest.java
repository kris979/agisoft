/* 
  * ============================================================================ 
  * Name      : ItemTest.java
  * ============================================================================
  */
package kata.kataIX;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import kata.parser.Item;

import org.junit.Test;


/**
 * 
 *
 */
public class ItemTest {
    
    private List<String> shoppingList = new ArrayList<String>();
    private Item discountedItem = Item.withDiscount("A", 3, 50, 130);
    private Item itemsWithoutDiscount = Item.withoutDiscount("C", 10);
    private double totalPrice = 100D;

    @Test
    public void testRuleWithoutDiscount() {
        shoppingList.add("C");
        double newTotal = itemsWithoutDiscount.applyDiscount(totalPrice, shoppingList);
        assertThat(newTotal, is(100D));
    }
    
    @Test
    public void shouldSubstractOneDiscount() {
        shoppingList.add("A");
        shoppingList.add("A");
        shoppingList.add("A");
        double newTotal = discountedItem.applyDiscount(totalPrice, shoppingList);
        assertThat(newTotal, is(80D));
    }
    
    @Test
    public void shouldSubstractOneDiscount1() {
        shoppingList.add("A");        shoppingList.add("B");
        shoppingList.add("A");        shoppingList.add("B");
        shoppingList.add("A");        shoppingList.add("B");
        shoppingList.add("A");
        double newTotal = discountedItem.applyDiscount(totalPrice, shoppingList);
        assertThat(newTotal, is(80D));
    }

    @Test
    public void shouldNotSubstractAnything() {
        shoppingList.add("A");
        shoppingList.add("B");
        shoppingList.add("A");
        double newTotal = discountedItem.applyDiscount(totalPrice, shoppingList);
        assertThat(newTotal, is(100D));
    }
    
    @Test
    public void shouldSubstractThreeDiscounts() {
        shoppingList.add("A");        shoppingList.add("B");
        shoppingList.add("A");        shoppingList.add("B");
        shoppingList.add("A");        shoppingList.add("B");
        shoppingList.add("A");        shoppingList.add("A");
        shoppingList.add("A");        shoppingList.add("A");
        shoppingList.add("A");        shoppingList.add("A");
        double newTotal = discountedItem.applyDiscount(totalPrice, shoppingList);
        assertThat(newTotal, is(40D));
    }
}
