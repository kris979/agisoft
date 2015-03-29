/**
 * 
 */
package interfaces;

/**
 * @author kris
 *
 */
public interface Etable {
	
	//by default all methods are public abstract in all interfaces.
	Boolean isEtable();
	
	//by default all variables are public static final in all interfaces.
	int SEEDS = 5;

	boolean isDrinkable();
}

interface Fruites extends Etable {   
}

interface Foods extends Etable, Fruites {
    
}

//abstract class Fruit implements Etable, Fruites {
//}

abstract class Vegetable {
}

