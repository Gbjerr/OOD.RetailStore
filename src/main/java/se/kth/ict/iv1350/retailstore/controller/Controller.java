/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.controller;

import java.util.ArrayList;
import java.util.List;
import se.kth.ict.iv1350.retailstore.integration.ItemRegistry;
import se.kth.ict.iv1350.retailstore.integration.InventorySystem;
import se.kth.ict.iv1350.retailstore.integration.AccountingSystem;
import se.kth.ict.iv1350.retailstore.integration.ItemNotAvailableException;
import se.kth.ict.iv1350.retailstore.integration.ItemRegistryException;
import se.kth.ict.iv1350.retailstore.model.TotalRevenueObserver;
import se.kth.ict.iv1350.retailstore.integration.Printer;
import se.kth.ict.iv1350.retailstore.integration.RegistryCreator;
import se.kth.ict.iv1350.retailstore.model.ItemDTO;
import se.kth.ict.iv1350.retailstore.model.Receipt;
import se.kth.ict.iv1350.retailstore.model.Sale;

/**
 * The class which performs all system operations when called from UI (view)
 */

public class Controller {
    private List<TotalRevenueObserver> observers = new ArrayList<>();
    private ItemRegistry itemReg;
    private Printer printer;
    private Sale sale;
    
    /**
    *  Constructor initiating controller
    *
    *@param creator object of class RegistryCreator
    *@param printer object of class Printer 
    */
    
    public Controller(RegistryCreator creator, Printer printer) {
        this.itemReg = creator.getItemRegistry();
        this.printer = printer;
    }
    
    /**
    * Creates new sale
    * @return sale - a sale object  
    */
    
    public Sale startNewSale() {
        this.sale = new Sale();
        return sale;
    }
    
    /**
    * Performs a search for a possible unit located in ItemRegistry and places it onto a list.
    * 
    * @param itemIDFier - identifies an item
    * @param quantity - input for choice of quantity
    */
    
    public void enterItemID(String itemIDFier, int quantity) throws OperationFailedException, ItemNotAvailableException {
        try{
            ItemDTO itemSpecification = itemReg.findItemByRegNo(itemIDFier);
            this.sale.addToList(itemSpecification, quantity);
        }
        catch(ItemRegistryException e) {
            throw new OperationFailedException("ItemRegistry was not readable", e);
        }
        
    }
    
    /**
     * gets total amount of sale
     *
     * @return total amount of sale
     */
    
    public int signalDoneScanning() {
       return this.sale.calculateTotalCost();
    }
    
    /**
     * Used when sale gets paid for.
     * @param recievedAmt - Amount fetched from customer
     */
    
    public void pay(int recievedAmt) {
        sale.addPaymentObservers(observers);
        Receipt receipt = sale.doPay(recievedAmt, sale);
        printer.printReceipt(receipt);
        sale.updateExternalSystems(sale);
        
    }
    
    /**
     * When a sale is paid for, observer will be notified.
     * 
     * @param observer - Observer which to notify
     */
     public void addPaymentObserver(TotalRevenueObserver observer) {
        observers.add(observer);
    }
    
}
