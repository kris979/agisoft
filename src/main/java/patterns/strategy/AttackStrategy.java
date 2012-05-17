package patterns.strategy;

/**
 * There are common situations when classes differ only in their behavior. For this cases is a good idea to isolate the
 * algorithms in separate classes in order to have the ability to select different algorithms at runtime.
 * 
 */
public interface AttackStrategy {

    public abstract void attack();

}
