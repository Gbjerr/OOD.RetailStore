package se.kth.ict.iv1350.retailstore.integration;

import se.kth.ict.iv1350.retailstore.model.Sale;

/**
 * Class responsible for representing a simplified external system for storing
 * sales.
 */
public class SalesLog {
    
    /**
     * Gives response when recieving information about performed sale.
     * @param completedSale the performed sale containing relevant details.
     */
    
    public void storeSale(Sale completedSale) {
        System.out.println("\nsale has been stored");
    }
}
