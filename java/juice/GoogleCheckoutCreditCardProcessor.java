/* 
  * ============================================================================ 
  * Name      : GoogleCheckoutCreditCardProcessor.java
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
public class GoogleCheckoutCreditCardProcessor implements CreditCardProcessor {

    /* (non-Javadoc)
     * @see com.agisoft.juice.CreditCardProcessor#charge(com.agisoft.juice.CreditCard, int)
     */
    @Override
    public ChargeResult charge(CreditCard creditCard, int amount) throws UnreachableException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.agisoft.juice.CreditCardProcessor#getCardOfOnlyCharge()
     */
    @Override
    public CreditCard getCardOfOnlyCharge() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.agisoft.juice.CreditCardProcessor#getAmountOfOnlyCharge()
     */
    @Override
    public int getAmountOfOnlyCharge() {
        // TODO Auto-generated method stub
        return 0;
    }

}
