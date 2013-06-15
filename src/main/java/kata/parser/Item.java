/* 
  * ============================================================================ 
  * Name      : Item.java
  * ============================================================================
  */
package kata.parser;

import java.util.List;

public class Item {

    private final String itemName;
    private final int itemsRequiredForSpecialPrice;
    private final double unitPrice;
    private final double specialPrice;
    private final double discount;
    
    private int appliedDiscountCounter = 0;

    public static Item withDiscount(String itemName, int itemsRequiredForSpecialPrice, double unitPrice, double specialPrice){
        return new Item(itemName, itemsRequiredForSpecialPrice, unitPrice, specialPrice);
    }
    
    public static Item withoutDiscount(String itemName, double unitPrice) {
        return new Item(itemName, 0, unitPrice, 0);
    }
    
    /**
     * @param itemName
     * @param itemsRequiredForSpecialPrice
     * @param unitPrice
     * @param specialPrice
     */
    private Item(String itemName, int itemsRequiredForSpecialPrice, double unitPrice, double specialPrice) {
        super();
        this.itemName = itemName;
        this.itemsRequiredForSpecialPrice = itemsRequiredForSpecialPrice;
        this.unitPrice = unitPrice;
        this.specialPrice = specialPrice;
        this.discount = (itemsRequiredForSpecialPrice*unitPrice) - this.specialPrice;
    }
    
    /* (non-Javadoc)
     * @see kata.kataIX.Rule#applyDiscount(double, java.util.List)
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
     * @see kata.kataIX.Rule#name()
     */
    public String name() {
        return itemName;
    }

    /* (non-Javadoc)
     * @see kata.kataIX.Rule#getPrice()
     */
    public double getPrice() {
        return unitPrice;
    }

    /* (non-Javadoc)
     * @see kata.kataIX.Rule#resetDiscountCounter()
     */
    public synchronized void resetDiscountCounter() {
        appliedDiscountCounter = 0;
    }

}
