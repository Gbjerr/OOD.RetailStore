package se.kth.ict.iv1350.retailstore.controller;

/**
 * Is thrown when operation was failed.
 */
public class OperationFailedException extends Exception{
    
    /**
     * Creates instance of the caused exception and message desribing it.
     * @param msg message describing the cause.
     * @param e the cause.
     */
    public OperationFailedException(String msg, Exception e) {
        super(msg, e);
    }
}
