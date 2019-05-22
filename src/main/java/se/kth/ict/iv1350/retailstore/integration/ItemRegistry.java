/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.integration;
import java.util.List;
import java.util.ArrayList;

import se.kth.ict.iv1350.retailstore.integration.ItemNotAvailableException;
import se.kth.ict.iv1350.retailstore.model.ItemDTO;
/**
 * @author gurra
 */
public class ItemRegistry {
    private static final List<ItemDTO> items = new ArrayList<>();
    
    ItemRegistry() {
        addItems();
    }
    
    public ItemDTO findItemByRegNo(String searchedRegNo) throws ItemNotAvailableException, ItemRegistryException{
        if(searchedRegNo.equals("åäö000")) {
            throw new ItemRegistryException("\nAttempt to find item with regNo:  ~~ åäö000 ~~ resulted in a database crash");
        }
        for(ItemDTO item : items) {
            if(item.getRegNo() == searchedRegNo) {
                return item;
            }
        }
        throw new ItemNotAvailableException(searchedRegNo);
    }
    
    private void addItems() {
        items.add(new ItemDTO("gurkmeja", "abc123", "passar bra till köttfärs", 60));
        items.add(new ItemDTO("pepperoni", "cba321", "fungerar bra till pizza", 35));
        items.add(new ItemDTO("tomat EKO", "bca231", "gott till sallad", 10));
        
    }
    
    
    
}
