package se.kth.ict.iv1350.retailstore.model;

/**
 * Class responsible for collecting information about specific item.
 */
public class ItemDTO {
    private String name;
    private String regNo;
    private String description;
    private int price;
    
    /**
     * Contructor for an item containing necessary info.
     * @param name name of product
     * @param regNo RegNo of product
     * @param description description of product
     * @param price price of product
     */
    public ItemDTO (String name, String regNo, String description, int price) {
        this.name = name;
        this.regNo = regNo;
        this.description = description;
        this.price = price;
    }
    
    /**
     * Assembles string representing info of current item.
     * @param quantity quantity
     * @return string containg info.
     */
    public String toString(int quantity) {
        StringBuilder builder = new StringBuilder();
        builder.append("name of product: " + name + "\n");
        builder.append("regNo: " + regNo + "\n");
        builder.append("description: " + description + "\n");
        builder.append("price/st: " + price + "\n");
        builder.append("quantity: " + quantity + "\n");
        return builder.toString();
    }
    
    /**
     * Getter of ID of item
     * @return regNo
     */
    public String getRegNo () {
        return regNo;
    }

    /**
     * Getter of price of item
     * @return 
     */
    public int getPrice() {
        return price;
    }
}
