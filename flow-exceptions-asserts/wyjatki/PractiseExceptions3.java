package wyjatki;


public class PractiseExceptions3 {

    /**
     * @param args
     */
    public static void main(String[] args) throws DupowateException {
        go();
    }
    
    static void go() throws BardziejDupowateException {
//        throw new DupowateException();  - wont compile as it fails IS-A test
        throw new BardziejDupowateException();
    }
    
}


class DupowateException extends Exception {    
}

class BardziejDupowateException extends DupowateException {
}