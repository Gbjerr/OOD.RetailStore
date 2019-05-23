package se.kth.ict.iv1350.retailstore.integration;

import se.kth.ict.iv1350.retailstore.model.CashRegistry;
/**
 * Responsible for initiating important classes in Integration.
 */
public class RegistryCreator {
    private AccountingSystem accSys = new AccountingSystem();
    private InventorySystem invSys = new InventorySystem();
    private SalesLog salesLog = new SalesLog();
    private CashRegistry cashRegistry = new CashRegistry();
    private ItemRegistry itemRegistry = new ItemRegistry();

    public RegistryCreator () {}
    
    public AccountingSystem getAccountingSystem () {
        return accSys;
    }

    public InventorySystem getInventorySystem() {
        return invSys;
    }
    
    public SalesLog getSalesLog() {
        return salesLog;
    }
    
    public ItemRegistry getItemRegistry() {
        return itemRegistry;
    }
    
    public CashRegistry getCashRegistry() {
        return cashRegistry;
    }

}   
    


