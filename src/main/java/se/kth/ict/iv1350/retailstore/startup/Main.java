/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.startup;

import se.kth.ict.iv1350.retailstore.view.View;
import se.kth.ict.iv1350.retailstore.view.ErrorMessageHandler;
import se.kth.ict.iv1350.retailstore.controller.Controller;
import se.kth.ict.iv1350.retailstore.integration.Printer;
import se.kth.ict.iv1350.retailstore.integration.RegistryCreator;
/**
 *
 * @author gurra
 */
public class Main {
        
    public static void main(String[] args) {
        RegistryCreator creator = new RegistryCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(creator, printer);
        ErrorMessageHandler handler = new ErrorMessageHandler();
        new View(controller).sampleExecution();
    }
}
