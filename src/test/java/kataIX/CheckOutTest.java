/* 
  * ============================================================================ 
  * Name      : CheckOutTest.java
  * ============================================================================
  */
package kataIX;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


/**
 * 
 *
 */
public class CheckOutTest {
    
    private List<Item> items = new ArrayList<Item>();
    private CheckOut co;

    @Before 
    public void prepareTestRules() {
        Item ruleForA = new Item("A",3,50,130);
        Item ruleForB = new Item("B",2,30,45);
        items.add(ruleForA);
        items.add(ruleForB);
        co = SuperMarketCheckout.withDiscountRules(items);
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
