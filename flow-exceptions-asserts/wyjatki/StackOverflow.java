package wyjatki;

import java.io.IOException;

class BaseExceptionTest {
    void think() throws IOException {}
}

public class StackOverflow extends BaseExceptionTest {
    static long i = 0; 

    void think() throws IOException {}
    
    public static void main(String[] args) {
        try {
            new StackOverflow().go(); //that will definatelly throw java.lang.StackOverflowError
        } catch (Exception e) { //this won't catch anything because Error does not inherit from Exception
            System.out.println("ouch!");
        } catch (Error e) {
            System.out.println("Error ouch!");
        }
    }
    
    void go() {
        System.out.println(++i);
        go();
    }
}

