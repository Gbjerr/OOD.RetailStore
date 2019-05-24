/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.ict.iv1350.retailstore.model.ItemDTO;
import se.kth.ict.iv1350.retailstore.integration.ItemNotAvailableException;


/**
 *
 * @author gurra
 */
public class ItemRegistryTest {
    

    
    public ItemRegistryTest() {   
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testFindItemByRegNo() throws ItemNotAvailableException {
        System.out.println("findItemByRegNo");
        ItemRegistry itemReg = new ItemRegistry();
        try{
        ItemDTO result = itemReg.findItemByRegNo("abc123");
        ItemDTO expResult = new ItemDTO("gurkmeja", "abc123", "passar bra till köttfärs", 60);
        assertEquals(expResult.getRegNo(), result.getRegNo());
        }
        catch(ItemNotAvailableException e) {
            fail("should not be thrown" + e);
        }
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
    public void testVerifyID() {
        ItemRegistry itemReg = new ItemRegistry();
        String instance = "ä43232";
        Boolean result = itemReg.verifyID(instance);
        Boolean expResult = true;
        assertEquals(result, expResult, "boolean matches");
        
        fail("this is not expected....");
    }
    
    public void testGetItemNotAvailable() throws ItemNotAvailableException {
        ItemRegistry itemReg = new ItemRegistry();
        try{
            ItemDTO result = itemReg.findItemByRegNo("oiu943");
        }
        catch (ItemRegistryException e) {
            fail("This is not expected..");
        }
        catch (ItemNotAvailableException e) {
            String expResult = "varan med ID :    " + "oiu943" + "     hittades ej. Vänligen försök igen.";
            assertTrue(expResult.equals(e.getMessage()));
        }
    }
    
    public void testGetByInvalidRegNo() throws ItemNotAvailableException {
        ItemRegistry itemReg = new ItemRegistry();
        try{
           ItemDTO result = itemReg.findItemByRegNo("abö345");
        }
        catch(ItemNotAvailableException e) {
            fail("This is not expected..");
        }
        catch(ItemRegistryException e) {
            String result = e.getMessage();
            String expResult = "\nAttempt to find item with regNo, containing chars:  ~~ åäö ~~ "
                                                + "resulted in a database crash";
            assertTrue(result.equals(expResult));
        }
    }    
}
