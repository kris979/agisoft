/* 
  * ============================================================================ 
  * Name      : CheckOutImpl.java
  * ============================================================================
  */
package kataIX;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 */
public class CheckOutImpl implements CheckOut {
    
    private double total = 0.0D;
    private List<String> items = new ArrayList<String>();
    private Map<String,DiscountRule> rules = new LinkedHashMap<String,DiscountRule>();

    /**
     * @param rule
     * @return
     */
    public static CheckOut getInstance(List<DiscountRule> rules) {
        return new CheckOutImpl(rules);
    }
    
    /**
     * 
     */
    private CheckOutImpl(List<DiscountRule> rules) {
        super();
        for (DiscountRule rule : rules) {
            String name = rule.name();
            this.rules.put(name, rule);
        }
    }

    
    /* (non-Javadoc)
     * @see kataIX.CheckOut#scan(java.lang.String)
     */
    @Override
    public boolean scan(String item) {
        DiscountRule rule = rules.get(item);
        if (rule == null) {
            throw new ItemNotInStockException();
        }
        total+=rule.getPrice();
        return items.add(item);
    }
    
    /* (non-Javadoc)
     * @see kataIX.CheckOut#scan(char)
     */
    @Override
    public boolean scan(char item) {
        return scan(Character.toString(item));
    }

    /* (non-Javadoc)
     * @see kataIX.CheckOut#total()
     */
    @Override
    public double total() {
        for (DiscountRule rule : rules.values()) {
            total = rule.applyDiscount(total, items);
        }
        return total;
    }

    /* (non-Javadoc)
     * @see kataIX.CheckOut#reset()
     */
    @Override
    public void reset() {
        total = 0d;
        items.clear();
        for (DiscountRule rule : rules.values()) {
            rule.resetDiscountCounter();
        }
    }


}
