/* 
  * ============================================================================ 
  * Name      : Transaction.java
  * ============================================================================
  */
package csv;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 
 *
 */
public class Transaction {
    
    private Date date;    
    private TransactionType type;    
    private String sortCode;   
    private String accNumber; 
    private String description; 
    //TODO: change into google Checkout Money
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private BigDecimal balance;
    
    /**
     * @param date
     * @param type
     * @param sortCode
     * @param accNumber
     * @param description
     * @param debitAmount
     * @param creditAmount
     * @param balance
     */
    public Transaction(Date date, TransactionType type, String sortCode, String accNumber, String description,
            BigDecimal debitAmount, BigDecimal creditAmount, BigDecimal balance) {
        super();
        this.date = date;
        this.type = type;
        this.sortCode = sortCode;
        this.accNumber = accNumber;
        this.description = description;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.balance = balance;
    }
    

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }
    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * @return the type
     */
    public TransactionType getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(TransactionType type) {
        this.type = type;
    }
    /**
     * @return the sortCode
     */
    public String getSortCode() {
        return sortCode;
    }
    /**
     * @param sortCode the sortCode to set
     */
    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }
    /**
     * @return the accNumber
     */
    public String getAccNumber() {
        return accNumber;
    }
    /**
     * @param accNumber the accNumber to set
     */
    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the debitAmount
     */
    public BigDecimal getDebitAmount() {
        return debitAmount;
    }
    /**
     * @param debitAmount the debitAmount to set
     */
    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }
    /**
     * @return the creditAmount
     */
    public BigDecimal getCreditAmount() {
        return creditAmount;
    }
    /**
     * @param creditAmount the creditAmount to set
     */
    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }
    /**
     * @return the balance
     */
    public BigDecimal getBalance() {
        return balance;
    }
    /**
     * @param balance the balance to set
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
