/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.model;

/**
 *
 * @author gurra
 */
public class Receipt {
    private Sale sale;
    
    public Receipt(Sale sale) {
        this.sale = sale;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("----COMPLETED SALE----\n");
        builder.append(sale.toString() + "\n");
        builder.append("----END OF RECEIPT----");
        
        return builder.toString();
        
    }

}
