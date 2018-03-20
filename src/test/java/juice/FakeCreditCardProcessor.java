
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
