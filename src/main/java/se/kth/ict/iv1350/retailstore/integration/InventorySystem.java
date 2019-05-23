/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.integration;

import se.kth.ict.iv1350.retailstore.model.Sale;

/**
 * Class representing a simplified external system for Inventory.
 *
 */
public class InventorySystem {
    
    public InventorySystem () {}
    
    /**
     * Responsible for giving a response when an object Sale is recieved. 
     * @param sale object containing information about the completed sale.
     */
    
    public void updateInvSys(Sale sale) {
        System.out.println("Inventory system updated");
    }
}
