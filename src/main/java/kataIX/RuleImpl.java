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
    private int appliedDiscountCounter = 0;

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
        
        int discountsToApply = 0;
        int itemsCounter = 0;
        for (String item : items) {
            if(item.equals(itemName)) {
                itemsCounter++;
            }
            if (itemsCounter == itemsRequiredForSpecialPrice) {
                discountsToApply++;
                itemsCounter = 0;
            }
        }
        
        if (discountsToApply > appliedDiscountCounter) {
            double currentDiscount = valueOfCurrentDiscounts(discountsToApply);
            double appliedDiscount = valueOfAppliedDiscounts();
            double calculatedDiscount = currentDiscount - appliedDiscount;
            newTotalPrice -= calculatedDiscount;
            appliedDiscountCounter++;
            return newTotalPrice;
        } else {
            return currentTotalPrice;
        }
    }

    private double valueOfCurrentDiscounts(int discountsToApply) {
        return discountsToApply*this.discount;
    }
    private double valueOfAppliedDiscounts() {
        return this.appliedDiscountCounter * this.discount;
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

    /* (non-Javadoc)
     * @see kataIX.Rule#resetDiscountCounter()
     */
    @Override
    public void resetDiscountCounter() {
        appliedDiscountCounter = 0;
    }

}
