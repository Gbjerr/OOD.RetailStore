/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.controller;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.ict.iv1350.retailstore.integration.DatabaseFailureException;
import se.kth.ict.iv1350.retailstore.integration.IdentifierWasNotFoundException;
import se.kth.ict.iv1350.retailstore.integration.Printer;
import se.kth.ict.iv1350.retailstore.integration.ItemRegistry;
import se.kth.ict.iv1350.retailstore.integration.RegistryCreator;
import se.kth.ict.iv1350.retailstore.model.TotalRevenueObserver;
import se.kth.ict.iv1350.retailstore.model.Sale;

/**
 *
 * @author gurra
 */
public class ControllerTest {
    
    public ControllerTest() {
    }
    PrintStream OriginalSysOut;
    private ByteArrayOutputStream contentOut;
    
    @BeforeEach
    public void setUp() {
        OriginalSysOut = System.out;
        contentOut = new ByteArrayOutputStream();
    }
    
    @AfterEach
    public void tearDown() {
        contentOut = null;
        System.setOut(OriginalSysOut);
    }

    @Test
    public void testStartNewSale() {
       
    }

    @Test
    public void testEnterItemID() throws Exception {
        System.out.println("enterItemID" + "\n");
        String itemIDfier = "abc123";
        int quantity = 3;
        Printer printer;
        RegistryCreator creator;
        Controller instance = new Controller(creator, printer);
        instance.enterItemID(itemIDfier, quantity);
        
        assertTrue(result instanceof Controller, "fail");
    }
    
    void testEnterItemIDWithIdentifierNotFoundExc() throws IdentifierWasNotFoundException {
        try {
            ItemRegistry registry = new ItemRegistry();
            
            registry.findItemByRegNo("143mfj");
        }
        catch (IdentifierWasNotFoundException exc) {
            String result = exc.getMessage() + " ";
            String failResult = "failed ID: " + "132mfj";
            assertTrue(result.contains(failResult), "ERROR: could not be found in registry :( ");
        }
    }

    void testEnterItemIDwithDatabaseFailExc() throws DatabaseFailureException {
        
        try {
        ItemRegistry registry = new ItemRegistry();
        
        registry.findItemByRegNo("äääää");
        }
        catch(DatabaseFailureException exc) {
            String result = exc.getMessage();
            String failResult = "Database crashed fail" + "äääää";
            assertTrue(result.contains(failResult),"database crashed as result from search");
        }
    }
    
    
}
