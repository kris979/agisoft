package juice;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;


@BindingAnnotation @Target({ FIELD, PARAMETER, METHOD }) @Retention(RUNTIME)
@interface PayPal {}

/**
 * 
 *
 */
public class PaypalCreditCardProcessor implements CreditCardProcessor {

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
