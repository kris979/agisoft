package misc;

import java.util.List;


/**
 * 
 *
 */
public class Misc {

    public String deFront(String str) {
        Character a = new Character('a');
        Character b = new Character('b');
        Character charAt0 = str.charAt(0);
        Character charAt1 = str.charAt(1);
        String deFronted = "";
        if (charAt0.equals(a)){
            deFronted+=charAt0;
        }
        if (charAt1.equals(b)){
            deFronted+=charAt1;
        }
        deFronted+=str.substring(2);
        return deFronted;
    }

    public String doubleChar(String str) {
        char[] strAsArray = str.toCharArray();
        String doubled = "";
        for (char c : strAsArray) {
            doubled += c;
            doubled += c;
        }
        return doubled;
    }

    public String mixString(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        String max = aLength < bLength ? a : b;
        
        String mixed = "";
        for (int i = 0; i < max.length(); i++) {
            mixed+= a.charAt(i);
            mixed+= b.charAt(i);
        }
        if (max.equals(a)) {
            mixed+=b.substring(max.length());
        } else {
            mixed+=a.substring(max.length());
        }
        return mixed;
    }

    public void test() {
        int x = 1;
        x+= x++ * x++ * x++;
        System.out.println(x);
    }
    
    public static void main(String[] args) {
        Misc misc = new Misc();
        misc.test();
        System.out.println(misc.mixString("1dupa", "dupa"));
    }
    
}
