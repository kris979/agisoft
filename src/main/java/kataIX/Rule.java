/* 
  * ============================================================================ 
  * Name      : Rule.java
  * ============================================================================
  */
package kataIX;

import java.util.List;

/**
 * 
 *
 */
public interface Rule {

    /**
     * @param items
     * @return updated Total Price
     */
    public double applyDiscount(double currentTotalPrice, List<String> items);
    
    
    public String name();


    /**
     * @return
     */
    public double getPrice();


    /**
     * 
     */
    public void resetDiscountCounter();

}
