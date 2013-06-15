/* 
  * ============================================================================ 
  * Name      : CheckOutTest.java
  * ============================================================================
  */
package kata.kataIX;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import kata.parser.CheckOut;
import kata.parser.Item;
import kata.parser.ItemNotInStockException;
import kata.parser.SuperMarketCheckout;

import org.junit.Before;
import org.junit.Test;


/**
 * 
 *
 */
public class CheckOutTest {
    
    private List<Item> stockList = new ArrayList<Item>();
    private CheckOut co;

    @Before 
    public void prepareTestRules() {
        Item itemA = Item.withDiscount("A",3,50,130);
        Item itemB = Item.withDiscount("B",2,30,45);
        stockList.add(itemA);
        stockList.add(itemB);
        co = SuperMarketCheckout.withStockList(stockList);
    }
    
    @Test(expected = ItemNotInStockException.class)
    public void checkoutWithoutStock() {
        co = SuperMarketCheckout.getInstance();
        co.scan("A");
    }
    
    @Test
    public void singleScanTest() {
        assertTrue(co.scan("A"));
    }
    
    @Test
    public void incrementalTest() {
        assertThat(co.total(), is(0d));
        co.scan("A");  assertThat( co.total(), is(50d));
        co.scan("B");  assertThat( co.total(), is(80d));
        co.scan("A");  assertThat( co.total(), is(130d));
        co.scan("A");  assertThat( co.total(), is(160d));
        co.scan("B");  assertThat( co.total(), is(175d));
        co.scan("A");  assertThat( co.total(), is(225d));
        co.scan("A");  assertThat( co.total(), is(275d));
        co.scan("A");  assertThat( co.total(), is(305d));
    }
    
    @Test
    public void totalsTest() {
        assertThat( price(""), is(0d)); co.resetForNewCustomer();
        assertThat( price("A"), is(50d)); co.resetForNewCustomer();
        assertThat( price("B"), is(30d)); co.resetForNewCustomer();
        assertThat( price("AB"), is(80d)); co.resetForNewCustomer();
        assertThat( price("AA"), is(100d)); co.resetForNewCustomer();
        
        assertThat( price("AAA"), is(130d)); co.resetForNewCustomer();
        assertThat( price("AAAA"), is(180d)); co.resetForNewCustomer();
        assertThat( price("AAAAA"), is(230d)); co.resetForNewCustomer();
        assertThat( price("AAAAAA"), is(260d)); co.resetForNewCustomer();

        assertThat( price("AAAB"), is(160d)); co.resetForNewCustomer();
        assertThat( price("AAABB"), is(175d)); co.resetForNewCustomer();
    }
    
    private double price(String order) {
        char[] items = order.toCharArray();
        for (int i = 0; i < items.length; i++) {
            co.scan(items[i]);
        }
        return co.total();
    }
}
