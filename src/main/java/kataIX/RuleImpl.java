/* 
  * ============================================================================ 
  * Name      : RuleImpl.java
  * ============================================================================
  */
package kataIX;

import java.util.List;

/**
 * 
 *
 */
public class RuleImpl implements Rule {

    private String itemName;
    private int itemsRequiredForSpecialPrice = 0;
    private double unitPrice = 0d;
    private double specialPrice = 0d;
    private double discount = 0d;

    /**
     * @param itemName
     * @param itemsRequiredForSpecialPrice
     * @param unitPrice
     * @param specialPrice
     */
    RuleImpl(String itemName, int itemsRequiredForSpecialPrice, double unitPrice, double specialPrice) {
        super();
        this.itemName = itemName;
        this.itemsRequiredForSpecialPrice = itemsRequiredForSpecialPrice;
        this.unitPrice = unitPrice;
        this.specialPrice = specialPrice;
        this.discount = (itemsRequiredForSpecialPrice*unitPrice) - this.specialPrice;
    }

    /* (non-Javadoc)
     * @see kataIX.Rule#applyDiscount(double, java.util.List)
     */
    @Override
    public double applyDiscount(double currentTotalPrice, List<String> items) {
        double newTotalPrice = currentTotalPrice;
        int counter = 0;
        for (String string : items) {
            if(string.equals(itemName)) {
                counter++;
            }
            if (counter == itemsRequiredForSpecialPrice) {
                newTotalPrice-=discount;
                counter = 0;
            }
        }
        return newTotalPrice;
    }

    /* (non-Javadoc)
     * @see kataIX.Rule#name()
     */
    @Override
    public String name() {
        return itemName;
    }

    /* (non-Javadoc)
     * @see kataIX.Rule#getPrice()
     */
    @Override
    public double getPrice() {
        return unitPrice;
    }

}
