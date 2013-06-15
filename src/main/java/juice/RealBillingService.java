package juice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class RealBillingService implements BillingService {
    
    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;
    
    @Inject
    CreditCard card;

    @Inject
    public RealBillingService(@PayPal CreditCardProcessor processor, TransactionLog transactionLog) {
      this.processor = processor;
      this.transactionLog = transactionLog;
    }

    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        System.out.println(card);
        try {
            ChargeResult result = processor.charge(creditCard, order.getAmount());
            transactionLog.logChargeResult(result);

            if (result.wasSuccessful())
                return Receipt.forSuccessfulCharge(order.getAmount());
            else
                return Receipt.forDeclinedCharge(result.getDeclineMessage());
        
        } catch (UnreachableException e) {
            transactionLog.logConnectException(e);
            return Receipt.forSystemFailure(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        
        //this should go in the main of the app
        Injector injector = Guice.createInjector(new BillingModule());

//        CreditCardProcessor processor = new PaypalCreditCardProcessor();
//        TransactionLog transactionLog = new DatabaseTransactionLog();
//        BillingService billingService = new RealBillingService(processor, transactionLog);
        
        //above 3 lines are replaced with this
        BillingService billingService = injector.getInstance(BillingService.class);

//        PizzaOrder order = new PizzaOrder(100);
        PizzaOrder order = injector.getInstance(PizzaOrder.class);
        
//        CreditCard creditCard = new CreditCard("1234", 12, 2011);
        CreditCard creditCard = injector.getInstance(CreditCard.class);
        System.out.println(creditCard);
        Receipt receipt = billingService.chargeOrder(order, creditCard);
        System.out.println(receipt);
      }
}