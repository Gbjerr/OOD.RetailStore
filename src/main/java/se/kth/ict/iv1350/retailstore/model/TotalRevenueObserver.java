
package se.kth.ict.iv1350.retailstore.model;

/**
 *interface handling the payment for observer pattern.
 * 
 */
public interface TotalRevenueObserver {
    
    
    void newPayment(int amt);
}
