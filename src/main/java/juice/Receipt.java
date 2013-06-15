package juice;

/**
 * 
 *
 */
public class Receipt {
    
    /**
     * @param amount
     * @param isForSuccessfulCharge
     * @param message
     */
    private Receipt(int amount, boolean isForSuccessfulCharge, String message) {
        super();
        this.amount = amount;
        this.isForSuccessfulCharge = isForSuccessfulCharge;
        this.message = message;
    }

    int amount;
    boolean isForSuccessfulCharge;
    String message;
    

    /**
     * @param amount
     * @return
     */
    public static Receipt forSuccessfulCharge(int amount) {
        return new Receipt(amount, true, "successful"); 
}

    /**
     * @param declineMessage
     * @return
     */
    public static Receipt forDeclinedCharge(String declineMessage) {
        return new Receipt(0, false, "declined");
    }

    /**
     * @param message
     * @return
     */
    public static Receipt forSystemFailure(String message) {
        return new Receipt(0, false, "system failure");
    }

    /**
     * @return
     */
    public boolean hasSuccessfulCharge() {
        return isForSuccessfulCharge;
    }

    /**
     * @return
     */
    public int getAmountOfCharge() {
        return amount;
    }

    @Override
    public String toString() {
        return "Receipt [amount=" + amount + ", successful=" + isForSuccessfulCharge + ", message="
                + message + "]";
    }

}
