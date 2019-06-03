/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.view;

import se.kth.ict.iv1350.retailstore.model.TotalRevenueObserver;
/**
 *
 * @author gurra
 */
public class TotalRevenueView implements TotalRevenueObserver {
    private int revenue;
    
    protected TotalRevenueView() {
        this.revenue = 0;
    }
    
    public void newPayment(int amt) {
        revenue = revenue + amt;
        display();
    }
    
    private void display() {
        
        System.out.println("\n" + "REVENUE UPDATED: Total amount of sales " + revenue);
    }
    
    private int getRevenue() {
        return revenue;
    }
}
  

