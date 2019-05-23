
package se.kth.ict.iv1350.retailstore.integration;

import se.kth.ict.iv1350.retailstore.model.Sale;

/**
 * Class representing a simplified external system for accounting.
 * 
 */
public class AccountingSystem {
    
    public AccountingSystem() {}
    
    /**
     * Responsible for giving a response when an object Sale is recieved.
     * 
     * @param sale object containing information about the completed sale.
     */
    
    public void updateAccSys(Sale sale) {
        System.out.println("Accounting system updated");
    }
    
}
