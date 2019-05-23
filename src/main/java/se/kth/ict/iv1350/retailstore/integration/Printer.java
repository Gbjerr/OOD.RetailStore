package se.kth.ict.iv1350.retailstore.integration;

import se.kth.ict.iv1350.retailstore.model.Receipt;
/**
 * Prints receipt containing record of performed sale.
 */
public class Printer {
    
    /**
     * Prints out receipt.
     * @param receipt reciept of perfomed sale.
     */
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt);
    }
}
