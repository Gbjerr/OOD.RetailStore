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
public class Item {
    private int quantity;
    private ItemDTO itemDTO;
    
    
    public Item(ItemDTO itemDTO, int quantity) {
        this.itemDTO = itemDTO;
        this.quantity = quantity;
    }
    
    public ItemDTO getItem() {
        return itemDTO;
    }
    
    public void AddToQuantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }
    
    public int getPriceDueQuantity() {
        return itemDTO.getPrice() * quantity;
    }
   
    public String toString(int quantity) {
        return itemDTO.toString(quantity);
    }
    
    public String getRegNo() {
        return itemDTO.getRegNo();
    }
    
    public int getQuantity () {
        return this.quantity;
    }
}
