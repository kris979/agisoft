package operators;

import java.lang.Long;
import java.lang.String;
import java.lang.System;

public class TestArrays {

    public static void main(String[] args) {
        float f1 = 2.4f;
        float [][] f2 = { {43.0f}, {2.3f, 2.4f}, {54.4f, 45.3f} };
        float [] f3 = {3.4f};
        Long x = 43L;
        
//        if (f1 == f2) {
//            System.out.println("true");
//        }
//        
//        if (f2 == f2[2][1]) {
//            System.out.println("true");
//        }
        
        
        int index = 0;
        System.out.println( f3[index++]); //used then incremented
        System.out.println( f3[++index]); //incremented then used 
        
        if (x == f2[0][0]) {
            System.out.println("t1");
        }
            
        if (f1 == f2[1][1]) {
            System.out.println("t2");
        }
        
        if (f3 == f2[2]) {
            System.out.println("t3");
        }
    }

}
