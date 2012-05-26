/* 
  * ============================================================================ 
  * Name      : DiscountRule.java
  * ============================================================================
  */
package kataIX;

import java.util.List;

public class DiscountRule {

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
    public DiscountRule(String itemName, int itemsRequiredForSpecialPrice, double unitPrice, double specialPrice) {
        super();
        this.itemName = itemName;
        this.itemsRequiredForSpecialPrice = itemsRequiredForSpecialPrice;
        this.unitPrice = unitPrice;
        this.specialPrice = specialPrice;
        this.discount = (itemsRequiredForSpecialPrice*unitPrice) - this.specialPrice;
    }
    
    public DiscountRule(String itemName, double unitPrice) {
        super();
        this.itemName = itemName;
        this.unitPrice = unitPrice;
    }

    /* (non-Javadoc)
     * @see kataIX.Rule#applyDiscount(double, java.util.List)
     */
    public double applyDiscount(double currentTotalPrice, List<String> items) {
        int discountsToApply = countDiscounts(items);
        if (discountsToApply > appliedDiscountCounter) {
            return applyDiscount(currentTotalPrice, discountsToApply);
        } else {
            return currentTotalPrice;
        }
    }

    /**
     * @param newTotalPrice
     * @param discountsToApply
     * @return
     */
    private double applyDiscount(double currentTotalPrice, int discountsToApply) {
        double newTotalPrice = currentTotalPrice;
        double currentDiscount = valueOfCurrentDiscounts(discountsToApply);
        double appliedDiscount = valueOfAppliedDiscounts();
        double calculatedDiscount = currentDiscount - appliedDiscount;
        newTotalPrice -= calculatedDiscount;
        appliedDiscountCounter++;
        return newTotalPrice;
    }

    /**
     * @param items
     * @return
     */
    private int countDiscounts(List<String> items) {
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
        return discountsToApply;
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
    public String name() {
        return itemName;
    }

    /* (non-Javadoc)
     * @see kataIX.Rule#getPrice()
     */
    public double getPrice() {
        return unitPrice;
    }

    /* (non-Javadoc)
     * @see kataIX.Rule#resetDiscountCounter()
     */
    public void resetDiscountCounter() {
        appliedDiscountCounter = 0;
    }

}
