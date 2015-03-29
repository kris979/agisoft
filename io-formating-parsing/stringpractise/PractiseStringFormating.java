 package stringpractise;

public class PractiseStringFormating {

    /**
     * @param args
     */
    public static void main(String[] args) {
        testFormat();
    }

    static void testFormat() {

        int x = 0;
        System.out.format("%s + %d\n", "dupa", 10);
        
        System.out.format("%2$s + %1$d", 5, "cycki");  //number$ <-- which arg to use  %charanter set    
        
        System.out.printf("\n%b\n",2>3);
        
        double d = 23.23;
        System.out.printf("%f",d);
    }
}
