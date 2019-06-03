package se.kth.ict.iv1350.retailstore.model;

/**
 * Class responsible for recieving object of sale and assemble receipt based on
 * performed sale.
 */
public class Receipt {
    private Sale sale;
    
    /**
     * contructor of receipt initiating sale containing necessary info.
     * @param sale 
     */
    public Receipt(Sale sale) {
        this.sale = sale;
    }

    /**
     * Assembles string for Receipt to be printed out.
     * @return string of total receipt.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        //builder.append("----COMPLETED SALE----\n");
        builder.append(sale.toString() + "\n");
        builder.append("----END OF RECEIPT----");
        
        return builder.toString();
        
    }

}
