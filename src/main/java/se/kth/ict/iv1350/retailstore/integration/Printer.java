/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.integration;

import se.kth.ict.iv1350.retailstore.model.Receipt;
/**
 *
 * @author gurra
 */
public class Printer {
    
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt);
    }
}
