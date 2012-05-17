/* 
  * ============================================================================ 
  * Name      : Command.java
  * ============================================================================
  */
package robot;

/**
 * 
 *
 */
public interface Command {

    /**
     * 
     */
    public abstract void execute();

    /**
     * @return
     */
    public abstract Integer getSrcBlock();

    /**
     * @return
     */
    public abstract Integer getDstBlock();

}
