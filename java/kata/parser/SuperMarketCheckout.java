/* 
  * ============================================================================ 
  * Name      : SuperMarketCheckout.java
  * ============================================================================
  */
package kata.parser;

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
     * @see kata.kataIX.CheckOut#scan(java.lang.String)
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
     * @see kata.kataIX.CheckOut#scan(char)
     */
    @Override
    public boolean scan(char item) {
        return scan(Character.toString(item));
    }

    /* (non-Javadoc)
     * @see kata.kataIX.CheckOut#total()
     */
    @Override
    public double total() {
        for (Item rule : rules.values()) {
            total = rule.applyDiscount(total, basket);
        }
        return total;
    }

    /* (non-Javadoc)
     * @see kata.kataIX.CheckOut#reset()
     */
    @Override
    public void resetForNewCustomer() {
        total = 0d;
        basket.clear();
        for (Item rule : rules.values()) {
            rule.resetDiscountCounter();
        }
    }

    /**
     * @return
     */
    public static CheckOut getInstance() {
        return new SuperMarketCheckout(new ArrayList<Item>());
    }

    /**
     * @param stockList
     * @return
     */
    public static CheckOut withStockList(List<Item> stockList) {
        // TODO Auto-generated method stub
        return null;
    }


}
