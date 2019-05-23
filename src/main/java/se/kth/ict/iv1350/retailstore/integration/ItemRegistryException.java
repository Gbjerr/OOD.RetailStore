package se.kth.ict.iv1350.retailstore.integration;

/**
 * Thrown when something goes wrong in ItemRegistry.
 * 
 */
public class ItemRegistryException extends RuntimeException{
    
    
    /**
     * Creates instance which tells what did go wrong.
     * @param msg message describing the cause.
     */
    public ItemRegistryException(String msg){
        super(msg);
    }
    
}
