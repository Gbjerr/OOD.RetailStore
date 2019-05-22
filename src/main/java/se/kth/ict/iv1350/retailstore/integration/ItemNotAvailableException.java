/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.integration;

/**
 *
 * @author gurra
 */
public class ItemNotAvailableException extends Exception {
    
    public ItemNotAvailableException(String regNo) {
        super("varan med ID :   ~~~~" + regNo + "~~~~   hittades ej, vänligen försök igen.");
    }
    
}
