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
    
    private List<Rule> testRules = new ArrayList<Rule>();
    private CheckOut co;

    @Before 
    public void prepareTestRules() {
        Rule ruleForA = new RuleImpl("A",3,50,130);
        Rule ruleForB = new RuleImpl("B",2,30,45);
        testRules.add(ruleForA);
        testRules.add(ruleForB);
        co = CheckOutImpl.getInstance(testRules);
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
        assertThat( price(""), is(0d)); co.reset();
        assertThat( price("A"), is(50d)); co.reset();
        assertThat( price("B"), is(30d)); co.reset();
        assertThat( price("AB"), is(80d)); co.reset();
        assertThat( price("AA"), is(100d)); co.reset();
        
        assertThat( price("AAA"), is(130d)); co.reset();
        assertThat( price("AAAA"), is(180d)); co.reset();
        assertThat( price("AAAAA"), is(230d)); co.reset();
        assertThat( price("AAAAAA"), is(260d)); co.reset();

        assertThat( price("AAAB"), is(160d)); co.reset();
        assertThat( price("AAABB"), is(175d)); co.reset();
    }
    
    private double price(String order) {
        char[] items = order.toCharArray();
        for (int i = 0; i < items.length; i++) {
            co.scan(items[i]);
        }
        return co.total();
    }
}
