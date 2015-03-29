package wyjatki;
import java.util.Random;

enum Foods {
    APPLE(false), BANANA(false), ORANGE(false), PIZZA(true), BROCCOLI(false), SPINACH(false), SALAD(false);

    boolean isBad;

    Foods(boolean isBad) {
        this.isBad = isBad;
    }

    public void isBad() throws BadFoodException {
        if (isBad) {
            throw new BadFoodException(this);
        }
    }
};


class BadFoodException extends Exception {
    static final long serialVersionUID = 0xcafe;
    Foods badFood;
 
    public BadFoodException(Foods f) {
        badFood = f;
    }
    
    public String getMessage() {
        return badFood.name();
    }
}


public class PractiseExceptions {
    
    static Foods[] badFoods = {Foods.APPLE, Foods.BANANA, Foods.BROCCOLI, Foods.SALAD};
    
    public static void main(String[] args) {

//        int a = 0;
//        int y = 7/a; //runtime Arithmetic exception

        //pick a random interfaces
        int pick = new Random().nextInt(Foods.values().length);        
        Foods f = Foods.values()[pick];
        
        try {
            f.isBad();
        } catch (BadFoodException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();       
        }
        finally {
            System.out.println("Excepion e is not accessible in finally block");
//            throw e;
        }
    }
    
}




