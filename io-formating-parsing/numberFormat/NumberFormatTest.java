/* 
 * ============================================================================ 
 * Name      : NumberFormatTest.java
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
package numberFormat;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * 
 *
 */
public class NumberFormatTest {

    /**
     * @param args
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {
        final NumberFormatTest numberFormatTest = new NumberFormatTest();
//        numberFormatTest.go();
        numberFormatTest.exam3q44();
        
    }

    void go() throws ParseException {
        
        String price = "£0.002423423423 sdfsd";
        Float l = 123120.32400000F;
       
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.UK);
        numberFormat.setMaximumFractionDigits(3);
        System.out.println(numberFormat.parse(price));
        System.out.println(numberFormat.format(l));
        
//        NumberFormat currency = NumberFormat.getCurrencyInstance(l);
//        System.out.println(currency.getMaximumFractionDigits());
//        currency.setMaximumFractionDigits(1);
//        try {
//            Number pound = currency.parse(price);
//            System.out.println(pound);
//        } catch (ParseException e) {
//            System.out.println("Failed to parse " + price);
//            e.printStackTrace();
//        }

    }
    
    enum Heroes { EN, GANDALF}
    
    /**
     * 
     */
    private void exam3q44() {
        
        System.out.println(Heroes.GANDALF);
        
        NumberFormat nf1, nf2;
        Number n;
        Locale[] la = NumberFormat.getAvailableLocales();
        System.out.println("Available locales:" + la.length);
        for (int i = la.length-1; i > la.length - 3; i--) {
            nf1 = NumberFormat.getCurrencyInstance(la[i]);
            System.out.println(la[i].getDisplayCountry() + ":" + nf1.format(123.456f));
        }

        final String obj = "123.456f";
        try {
            for (int i = 0; i < la.length; i++) {
                nf2 = NumberFormat.getInstance();
                n = nf2.parse(obj);
//                System.out.println(n);
                String s = nf2.format(123.456f);
                System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("Can't parse");
        }
    }

}
