/* 
  * ============================================================================ 
  * Name      : Stock.java
  * ============================================================================
  */
package bdd;

/**
 * 
 *
 */
public class Stock {

    private final String symbol;
    private final double threshold;
    private double price;

    /**
     * @param symbol
     * @param threshold
     */
    public Stock(String symbol, double threshold) {
        this.symbol = symbol;
        this.threshold = threshold;
    }

    /**
     * @param price
     */
    public void tradeAt(double price) {
        this.price = price;
    }

    /**
     * @return
     */
    public String getStatus() {
        if (price < threshold) {
            return "OFF";
        } else {
            return "ON";
        }
    }

}
