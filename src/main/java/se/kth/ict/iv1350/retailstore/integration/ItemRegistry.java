package se.kth.ict.iv1350.retailstore.integration;
import java.util.List;
import java.util.ArrayList;

import se.kth.ict.iv1350.retailstore.integration.ItemNotAvailableException;
import se.kth.ict.iv1350.retailstore.model.ItemDTO;
/**
 * Class responsible to represent the registry in which all possible products
 * exist.
 */
public class ItemRegistry {
    private List<ItemDTO> items = new ArrayList<>();
    
    public ItemRegistry(List<ItemDTO> items) {
        this.items = items;
    }
    ItemRegistry() {
        addItems();
    }
    
    /**
     * Finds product in registry based on the ID of a product, and returns it.    
     * 
     * @param searchedRegNo ID of searched product.
     * @return return searched item.
     * @throws ItemNotAvailableException is thrown when item is not available.
     * @throws ItemRegistryException is thrown when unallowed chars exist in ID.
     */
    
    public ItemDTO findItemByRegNo(String searchedRegNo) throws ItemNotAvailableException, ItemRegistryException{
        if(verifyID(searchedRegNo)) {
            throw new ItemRegistryException("\nAttempt to find item with regNo, containing chars:  ~~ åäö ~~ "
                                                + "resulted in a database crash");
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
      
    /**
     * Verifies whether ID contains unallowed chars and returns a boolean.
     * @param searchedRegNo the ID to be investigated.
     * @return boolean based on result.
     */
    
    public boolean verifyID (String searchedRegNo) {
        if(searchedRegNo.contains("å") || 
                searchedRegNo.contains("ä") || searchedRegNo.contains("ö")) {
            return true;
        }
        return false;
    }
        
    
    
    
}
