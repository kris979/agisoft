/* 
  * ============================================================================ 
  * Name      : InMemoryTransactionLog.java
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
public class InMemoryTransactionLog implements TransactionLog {
    
    boolean successLogged;

    /* (non-Javadoc)
     * @see com.agisoft.juice.TransactionLog#logChargeResult(com.agisoft.juice.ChargeResult)
     */
    @Override
    public void logChargeResult(ChargeResult result) {
        successLogged = true;
    }

    /* (non-Javadoc)
     * @see com.agisoft.juice.TransactionLog#logConnectException(com.agisoft.juice.UnreachableException)
     */
    @Override
    public void logConnectException(UnreachableException e) {
        successLogged = false;
    }

    /* (non-Javadoc)
     * @see com.agisoft.juice.TransactionLog#wasSuccessLogged()
     */
    @Override
    public boolean wasSuccessLogged() {
        return successLogged;
    }

}
