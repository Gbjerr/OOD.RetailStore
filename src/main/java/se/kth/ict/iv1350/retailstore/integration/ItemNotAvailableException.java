package se.kth.ict.iv1350.retailstore.integration;

/**
 * Thrown when searched item cannot be found in ItemRegistry.
 */
public class ItemNotAvailableException extends Exception {
    
    /**
     * Specifies the ID of an item which cannot be found.
     * @param regNo the ID of searched product which couldnt be found.
     */
    public ItemNotAvailableException(String regNo) {
        super("varan med ID :    " + regNo + "     hittades ej. Vänligen försök igen.");
    }
    
}
