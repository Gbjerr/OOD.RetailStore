/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import se.kth.ict.iv1350.retailstore.integration.ItemRegistry;
import se.kth.ict.iv1350.retailstore.integration.ItemNotAvailableException;
import se.kth.ict.iv1350.retailstore.integration.ItemRegistryException;
import se.kth.ict.iv1350.retailstore.model.Sale;
import se.kth.ict.iv1350.retailstore.model.ItemDTO;

/**
 *
 * @author gurra
 */
public class ControllerTest {
    
    private ByteArrayOutputStream outPut;
    private PrintStream sysOut;
    
    public ControllerTest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        sysOut = System.out;
        outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));
    }
    
    @AfterEach
    public void tearDown() {
        outPut = null;
        System.setOut(sysOut);
    }
    
    public void testEnterItemID() {
       Sale instance = new Sale();
       ItemDTO item = new ItemDTO("gurka", "gur734", "passar till sallad", 19);
       instance.addToList(item);
       Sale result = instance;
       
       assertTrue(result instanceof Sale);
    }

    public void testEnterItemIDWithItemNotAvailableExc () throws ItemNotAvailableException {
        ItemRegistry itemReg = new ItemRegistry();
        try {
            itemReg.findItemByRegNo("ldk938");
            
        }
        catch(ItemNotAvailableException e){
            String expResult = "varan med ID :    " + "oiu943" + "     hittades ej. Vänligen försök igen.";
            String result = e.getMessage();
            assertTrue(result.equals(expResult), " varan hittades ej");
        }
        catch(ItemRegistryException e) {
            fail("this is not expected...");
        }
    }
}
