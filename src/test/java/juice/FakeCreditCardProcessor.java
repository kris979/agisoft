/* 
  * ============================================================================ 
  * Name      : FakeCreditCardProcessor.java
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

/**
 * 
 *
 */
public class FakeCreditCardProcessor implements CreditCardProcessor {
    
    CreditCard card;
    int amount;

    /* (non-Javadoc)
     * @see com.agisoft.juice.CreditCardProcessor#charge(com.agisoft.juice.CreditCard, java.lang.Object)
     */
    @Override
    public ChargeResult charge(CreditCard creditCard, int amount) throws UnreachableException {
        card = creditCard;
        this.amount = amount;
        return new ChargeResult(true, null);
    }

    /* (non-Javadoc)
     * @see com.agisoft.juice.CreditCardProcessor#getCardOfOnlyCharge()
     */
    @Override
    public CreditCard getCardOfOnlyCharge() {
        return card;
    }

    /* (non-Javadoc)
     * @see com.agisoft.juice.CreditCardProcessor#getAmountOfOnlyCharge()
     */
    @Override
    public int getAmountOfOnlyCharge() {
        return amount;
    }


}
