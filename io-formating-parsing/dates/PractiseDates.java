package dates;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PractiseDates {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PractiseDates dates = new PractiseDates();
        dates.testCalendar();
        System.out.println("============================");
        dates.testDates();
        System.out.println("============================");
//        dates.testLocale();
        System.out.println("============================");
        dates.testDateFormat();
        System.out.println("============================");
        dates.testNumberFormat();
    }

    @SuppressWarnings("deprecation")
    void testDates() {
        //default constructor creates a date using now.
        Date d = new Date();

        long l = 100000000000L;
        Date d1 = new Date(l);
        System.out.println(d1.toString());
        System.out.println(d1.toLocaleString());
        System.out.println(d1.toGMTString());
    }
    
    void testCalendar() {
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());
        c.add(Calendar.DAY_OF_MONTH, 7);
        System.out.println(c.getTime());
        c.add(Calendar.DAY_OF_WEEK, 6);
        System.out.println(c.getTime());
        c.add(Calendar.MONTH, 10);               //add potrafi zmienic rok
        System.out.println(c.getTime());
        c.roll(Calendar.MONTH, -10);            //roll nie potrafi zmienic roku, przesunie tylko miesiac
        System.out.println(c.getTime());
        
        c.set(1999,11,25);
        System.out.println(c.getTime());
        c.roll(Calendar.MONTH, 3);
        c.add(Calendar.DATE, 10);
        System.out.println(c.getTime());
    }
    
    void testLocale() {
//        Locale loc = new Locale("JP");
//        System.out.println(loc.getDisplayCountry()); //dont know why this is null
//        System.out.println(loc.getDisplayLanguage());
//        System.out.println(loc.getDisplayName());
        Locale[] locs = DateFormat.getAvailableLocales();
        for (Locale locale : locs) {
            System.out.println(locale.getCountry() + " " + locale.getDisplayCountry() + " " + locale.getDisplayLanguage());
        }
    }
    
    void testDateFormat() {
        Locale loc = new Locale("DE");
        Calendar c = Calendar.getInstance();
        Date d = c.getTime();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, loc);
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.MEDIUM, loc);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.SHORT, loc);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.SHORT); 
        String loc_date = df.format(d);
        System.out.println(loc_date);
        System.out.println(df1.format(d));
        System.out.println(df2.format(d));
    }
    
    void testNumberFormat() {
        float f = 123.23f;
        NumberFormat[] nf = new NumberFormat[2];
        nf[0] = NumberFormat.getInstance();
        nf[1] = NumberFormat.getCurrencyInstance();
        for (NumberFormat numberFormat : nf) {
            System.out.println(numberFormat.format(f));
        }
        
    }
    
    
     
}
