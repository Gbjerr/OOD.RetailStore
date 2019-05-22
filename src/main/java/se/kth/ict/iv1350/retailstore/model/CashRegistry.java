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
public class CashRegistry {
    private int balance;
    
    public CashRegistry () {
        this.balance = 400;
    }
    
    public void addPayment (int payment) {
        balance = balance + payment;
        System.out.println("balance is now :" + balance);
    }
    
    public int getBalance () {
        return balance;
    }
    
    
}
