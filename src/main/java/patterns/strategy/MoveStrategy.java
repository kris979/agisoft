package patterns.strategy;

/**
 * There are common situations when classes differ only in their behavior ie walk or run. For this cases is a good idea
 * to isolate the algorithms in separate classes in order to have the ability to select different algorithms at runtime.
 * Warrior can walk or run.
 * 
 * 
 * The strategy design pattern splits the behavior (there are many behaviors) of a class from the class itself. This has
 * some advantages, but the main draw back is that a client must understand how the Strategies differ. Since clients get
 * exposed to implementation issues the strategy design pattern should be used only when the variation in behavior is
 * relevant to them.
 */
public interface MoveStrategy {

    public abstract void move();

}
