package se.kth.ict.iv1350.retailstore.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.time.LocalDateTime;


import se.kth.ict.iv1350.retailstore.integration.AccountingSystem;
import se.kth.ict.iv1350.retailstore.integration.InventorySystem;
import se.kth.ict.iv1350.retailstore.integration.ItemRegistry;
import se.kth.ict.iv1350.retailstore.integration.SalesLog;
import se.kth.ict.iv1350.retailstore.model.CashRegistry;
import se.kth.ict.iv1350.retailstore.model.TotalRevenueObserver;

/**
 * Gathers/collects relevant information of a sale
 */

public class Sale {
    LocalDateTime timeOfSale;
    private List<Item> itemsOfChoice = new ArrayList<>();
    private List<TotalRevenueObserver> observers = new ArrayList<>();
    private int runningTotal;
    private int amountRecieved;
    private int amountChange;
    private int recievedAmt;
    private int changeAmount;
    private ItemRegistry itemReg;
    
    /**
     * Constructor representing Sale
     */
    
    public Sale () {
        timeOfSale = LocalDateTime.now();
    }
    
    /**
     * places wanted item on the list and decides 
     * whether to add quantity based on quantity input.
     * 
     * @param itemInfo - gathered info for individual item
     * @param quantity - quantity of wanted item
     * @throws UnsuccesfulOperationException 
     */
    
    public void addToList(ItemDTO itemInfo, int quantity) {
        boolean condition = false;
        Item itemCreate;
        itemCreate = new Item(itemInfo, quantity);
        for(Item item : itemsOfChoice) {
            if(item.getRegNo() == itemCreate.getRegNo()) {
                item.AddToQuantity(quantity);
                condition = true;
            }
        }
        if (condition == false){
            itemsOfChoice.add(itemCreate);
        }   
    }
    
 
    /**
     * 
     * @return 
     */
    
    public int calculateTotalCost() {
        runningTotal = 0;
        for(Item item : itemsOfChoice) {
            runningTotal = runningTotal + item.getPriceDueQuantity();
        }
        
        return runningTotal;
    }
    
    /*
    public Receipt pay(int recievedAmt, Sale sale) {
        this.recievedAmt = recievedAmt;
        calculateChange(recievedAmt);
        new SalesLog().storeSale(sale);
        new AccountingSystem().updateAccSys(sale);
        new InventorySystem().updateInvSys(sale);
        new CashRegistry().addPayment(recievedAmt);
        
        return new Receipt(sale);
    }

*/

    /**
     * Calulates change
     * @param recievedAmt - Recieved amount from customer 
     */
    private void calculateChange(int recievedAmt) {
        changeAmount = recievedAmt - runningTotal;
    }
    
    public String toString() {
        StringBuilder salesRepresentation = new StringBuilder();
        for(Item product : itemsOfChoice) {
            salesRepresentation.append(product.toString(product.getQuantity()) + "\n");
        } 
        salesRepresentation.append("Total Amount: " + runningTotal + "\n");
        salesRepresentation.append("Amount to return: " + changeAmount);
        
        return salesRepresentation.toString();
    }

    /**
     * performs when to pay.
     * 
     * @param recievedAmt - Amount recieved from customer
     * @param sale - object of Sale
     * @return Receipt - receipt of the recorded sale.
     */
    public Receipt doPay(int recievedAmt, Sale sale) {
       this.recievedAmt = recievedAmt;
       calculateChange(recievedAmt);
       updateExternalSystems(sale);
       notifyObservers(runningTotal);
       return new Receipt(sale);
    }

    
    
    private void notifyObservers(int amt) {
        for(TotalRevenueObserver observer : observers) {
            observer.newPayment(amt);
        }
    }
    
    /**
     * 
     * A specified observer to be notified when rental is paid off.
     * 
     * @param observer - an observer to be notified. 
     */
    
    public void addPaymentObserver(TotalRevenueObserver observer) {
        observers.add(observer);
    }
    
   /**
    * When sale is paid, it notifies specified observers 
    * 
    * @param payObservers - specified observers to be notified
    */
    public void addPaymentObservers(List<TotalRevenueObserver> payObservers) {
       observers.addAll(payObservers);
    }

    public void updateExternalSystems(Sale sale) {
       new SalesLog().storeSale(sale);
       new InventorySystem().updateInvSys(sale);
       new AccountingSystem().updateAccSys(sale);
    }
}

