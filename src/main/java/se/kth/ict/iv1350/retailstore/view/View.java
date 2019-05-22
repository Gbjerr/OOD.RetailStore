/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.view;


import java.lang.System.Logger;
import se.kth.ict.iv1350.retailstore.controller.Controller;
import se.kth.ict.iv1350.retailstore.integration.ItemNotAvailableException;
import se.kth.ict.iv1350.retailstore.controller.OperationFailedException;
import se.kth.ict.iv1350.retailstore.loghandler.LogHandler;
import se.kth.ict.iv1350.retailstore.model.TotalRevenueObserver;
import se.kth.ict.iv1350.retailstore.integration.ItemRegistry;
import se.kth.ict.iv1350.retailstore.model.ItemDTO;
import se.kth.ict.iv1350.retailstore.model.Sale;
import se.kth.ict.iv1350.retailstore.view.ErrorMessageHandler;

/**
 * Acts as user interface
 */
public class View {
    private Controller contr;
    private ErrorMessageHandler error = new ErrorMessageHandler();
    private LogHandler logger;
    
   /**
    * Creates instance
    * @param contr Controller which performs all neccessary operations
    */
    
    public View(Controller contr) {
        this.contr = contr;
        this.error = error;
        this.logger = LogHandler.getLogger();
        contr.addPaymentObserver(new TotalRevenueView());
    }
    
    /**
    *  Calls to wanted system operations to be performed
    */
    
    public void sampleExecution(){
        System.out.println("----TIME FOR SCANNING GOODS----");
        contr.startNewSale();
    
        
        try{
        contr.enterItemID("94832", 2);
        contr.enterItemID("49309", 2);
        } 
        catch(ItemNotAvailableException | OperationFailedException e) {
            logger.logException(e);
            error.errorMsg(e.getMessage());
             
        }
        
        contr.demandTotalPrice();
        
        contr.pay(500);
    
    }
}
