package se.kth.ict.iv1350.retailstore.model;

/**
 * Class responsible for maintaining balance in registry of income.
 */
public class CashRegistry {
    private int balance;
    
    /**
     * constructor setting current balance,
     */
    public CashRegistry () {
        this.balance = 400;
    }
    
    /**
     * Adds amount of a payment and updates current balance.
     * @param payment amount payed.
     */
    public void addPayment (int payment) {
        balance = balance + payment;
        System.out.println("balance is now :" + balance);
    }
    
    /**
     * Getter for current balance.
     * @return balance.
     */
    public int getBalance () {
        return balance;
    }
    
    
}
