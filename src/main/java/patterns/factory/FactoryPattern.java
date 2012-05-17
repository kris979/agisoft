package patterns.factory;


/**
 * creates objects without exposing the instantiation logic to the client. refers to the newly created object through a
 * common interface
 * 
 * The advantage is obvious: New shapes can be added without changing a single line of code in the framework(the client
 * code that uses the shapes from the factory). As it is shown in the next sections, there are certain factory
 * implementations that allow adding new products without even modifying the factory class.
 */
public class FactoryPattern {
    
    static
    {
        try
        {
            Class.forName(BarbarianWarrior.class.getName());
//            Class.forName(NecromancerWarrior.class.getName());
//            Class.forName(SorcererWarrior.class.getName());
        }
        catch (ClassNotFoundException any)
        {
            any.printStackTrace();
        }
    }
    
    public static void main(String[] args) {

        // The client needs a product, but instead of creating it directly using the new operator, it asks the factory
        // object for a new product, providing the information about the type of object it needs.

        // The factory instantiates a new concrete product and then returns to the client the newly created
        // product(casted to abstract product class).

        // The client uses the products as abstract products without being aware about their concrete implementation.

        Warrior myWarrior = WarriorFactory.summonWarrior(BarbarianWarrior.class);
        myWarrior.move();
        myWarrior.attack();
    }
    

}
