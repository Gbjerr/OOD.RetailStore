/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.integration;

import se.kth.ict.iv1350.retailstore.model.Sale;

/**
 *
 * @author gurra
 */
public class SalesLog {
    
    public void storeSale(Sale saleToBeCompleted) {
        System.out.println("\nsale has been stored");
    }
}