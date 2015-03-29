package flow;

import java.util.ArrayList;
import java.util.List;

public class LabeledLoops {

    /**
     * @param args
     */
    public static void main(String[] args) {
//        doStuff();
        doStuff1();
        
        
        List a = new ArrayList<Integer>();
        List<Integer> l = new ArrayList();
    }

    static void doStuff() {
        int age = 0;
        
        outer:    
            while (age <= 21) {
                age++;
                if (age >= 16) {
                    System.out.println("get driving license");
                    continue outer;
                }
                System.out.println("another year");
            }
    }
    
    static void doStuff1() {
        boolean a = true;
        lol:
        switch (12) {
        case 1: {
            System.out.println(1);
            break;
        }
        case 12: {
            System.out.println(12);
        } 
        default: {
            System.out.println("default");
        }
        System.out.println("after default");
        }
        System.out.println("after switch");
    }
    
}
