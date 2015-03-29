/* 
  * ============================================================================ 
  * Name      : BillingModule.java
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

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

public class BillingModule extends AbstractModule {
  @Override 
  protected void configure() {
    bind(TransactionLog.class).to(DatabaseTransactionLog.class);
    
    //if there are more than one mapping for a given interface, we can use annotatedWith @see RealBillingService.class
    bind(CreditCardProcessor.class).annotatedWith(PayPal.class).to(PaypalCreditCardProcessor.class);
    bind(CreditCardProcessor.class).to(GoogleCheckoutCreditCardProcessor.class);
    
    bind(BillingService.class).to(RealBillingService.class);
    
    bind(Integer.class).annotatedWith(Names.named("$100")).toInstance(100);
  }

  @Provides
  CreditCard providesCreditCard() {
      return new CreditCard("12344", 10, 2010);
  }
  
}