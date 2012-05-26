/* 
  * ============================================================================ 
  * Name      : SuperMarketCheckout.java
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
public class SuperMarketCheckout implements CheckOut {
    
    private double total = 0.0D;
    private List<String> basket = new ArrayList<String>();
    private Map<String,Item> rules = new LinkedHashMap<String,Item>();

    /**
     * @param rule
     * @return
     */
    public static CheckOut withDiscountRules(List<Item> rules) {
        return new SuperMarketCheckout(rules);
    }
    
    /**
     * 
     */
    private SuperMarketCheckout(List<Item> rules) {
        super();
        for (Item rule : rules) {
            String name = rule.name();
            this.rules.put(name, rule);
        }
    }

    
    /* (non-Javadoc)
     * @see kataIX.CheckOut#scan(java.lang.String)
     */
    @Override
    public boolean scan(String item) {
        Item rule = rules.get(item);
        checkIfInStock(rule);
        total+=rule.getPrice();
        return basket.add(item);
    }

    /**
     * @param rule
     * @throws ItemNotInStockException
     */
    private void checkIfInStock(Item rule) throws ItemNotInStockException {
        if (rule == null) {
            throw new ItemNotInStockException();
        }
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
        for (Item rule : rules.values()) {
            total = rule.applyDiscount(total, basket);
        }
        return total;
    }

    /* (non-Javadoc)
     * @see kataIX.CheckOut#reset()
     */
    @Override
    public void resetForNewCustomer() {
        total = 0d;
        basket.clear();
        for (Item rule : rules.values()) {
            rule.resetDiscountCounter();
        }
    }


}
