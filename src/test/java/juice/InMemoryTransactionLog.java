
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
