/* 
  * ============================================================================ 
  * Name      : CheckOut.java
  * ============================================================================
  */
package kata.kataIX;

/**
 * 
 *
 */
public interface CheckOut {
    
    /**
     * @param string
     * @return 
     */
    public boolean scan(String string);

    public boolean scan(char items);

    public double total();

    public void resetForNewCustomer();
}
