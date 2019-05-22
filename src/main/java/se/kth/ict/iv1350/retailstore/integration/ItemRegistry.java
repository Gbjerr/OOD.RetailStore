/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.integration;
import java.util.List;
import java.util.ArrayList;

//import se.kth.ict.iv1350.retailstore.model.Item;
import se.kth.ict.iv1350.retailstore.model.ItemDTO;
/**
 * @author gurra
 */
public class ItemRegistry {
    private static final List<ItemDTO> items = new ArrayList<>();
    
    ItemRegistry() {
        addItems();
    }
    
    public static ItemDTO findItemByRegNo(String searchedRegNo) throws IdentifierWasNotFoundException, DatabaseFailureException {
       
        
        
        for(ItemDTO item : items) {
            if(item.getRegNo() == searchedRegNo) {
                return item;
            }
        }
        
        if (searchedRegNo.contains("ä")){
            throw new DatabaseFailureException("connection to database was lost");
        }
        
        throw new IdentifierWasNotFoundException("\n" + "Item ID: " + searchedRegNo + " was not found in registry :( "  );
    }
    
    private void addItems() {
        items.add(new ItemDTO("gurkmeja", "abc123", "passar bra till köttfärs", 60));
        items.add(new ItemDTO("pepperoni", "cba321", "fungerar bra till pizza", 35));
        items.add(new ItemDTO("tomat EKO", "bca231", "gott till sallad", 10));
        
    }
    
    
    
}
