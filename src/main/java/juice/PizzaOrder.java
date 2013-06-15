/* 
  * ============================================================================ 
  * Name      : PizzaOrder.java
  * Part of     :  NEON
  * 
  * Copyright (c) 2007-2011 Nokia.  All rights reserved.
  * This material, including documentation and any related computer
  * programs, is protected by copyright controlled by Nokia.  All
  * rights are reserved.  Copying, including reproducing, storing,
  * adapting or translating, any or all of this material requires the
  * prior written consent of Nokia.  This material also contains
  * confidential information which may not be disclosed to others
  * without the prior written consent of Nokia.
 * 
  * ============================================================================
  */
package juice;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * 
 *
 */
public class PizzaOrder{

    Integer amount;

    String s = "test";

    /**
     * @param amount
     */
    @Inject
    public PizzaOrder(@Named("$100") Integer amount) {
        super();
        this.amount = amount;
    }
    
    /**
     * @return
     */
    Integer getAmount() {
        return amount; 
    }

    void test() {
        
    }

}
