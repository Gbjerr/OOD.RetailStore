/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.model;

/**
 *
 * @author gurra
 */
public class ItemDTO {
    private String name;
    private String regNo;
    private String description;
    private int price;
    
    public ItemDTO (String name, String regNo, String description, int price) {
        this.name = name;
        this.regNo = regNo;
        this.description = description;
        this.price = price;
    }
    
    public String toString(int quantity) {
        StringBuilder builder = new StringBuilder();
        builder.append("name of product: " + name + "\n");
        builder.append("regNo: " + regNo + "\n");
        builder.append("description: " + description + "\n");
        builder.append("price/st: " + price + "\n");
        builder.append("quantity: " + quantity + "\n");
        return builder.toString();
    }
    
    public String getRegNo () {
        return regNo;
    }

    public int getPrice() {
        return price;
    }
}
