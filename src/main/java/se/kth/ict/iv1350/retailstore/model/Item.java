package se.kth.ict.iv1350.retailstore.model;

/**
 * Class responsible for associating a specified item with its quantity.
 */
public class Item {
    private int quantity;
    private ItemDTO itemDTO;
    
    /**
     * Constructor initiating what item should be associated with wanted amount.
     * @param itemDTO
     * @param quantity 
     */
    public Item(ItemDTO itemDTO, int quantity) {
        this.itemDTO = itemDTO;
        this.quantity = quantity;
    }
    
    /**
     * getter for item.
     * @return itemDTO
     */
    public ItemDTO getItem() {
        return itemDTO;
    }
    
    /**
     * Adds quantity to associated item.
     * @param quantity quantity of item
     */
    public void AddToQuantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }
    
    /**
     * Calculates price of item in cohesion to its quantity.
     * @return calculated price.
     */
    public int getPriceDueQuantity() {
        return itemDTO.getPrice() * quantity;
    }
   
    /**
     * Adds quantity to be visible for assmebling string.
     * @param quantity quantity of item
     * @return string representing item and quantity.
     */
    public String toString(int quantity) {
        return itemDTO.toString(quantity);
    }
    
    /**
     * getter for regNo.
     * @return regNo.
     */
    public String getRegNo() {
        return itemDTO.getRegNo();
    }
    
    /**
     * getter for regNo.
     * @return quantity.
     */
    public int getQuantity () {
        return this.quantity;
    }
}
