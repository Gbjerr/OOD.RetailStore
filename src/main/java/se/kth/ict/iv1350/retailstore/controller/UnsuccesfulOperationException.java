/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.controller;

/**
 *
 * @author gurra
 */
public class UnsuccesfulOperationException extends Exception {
    
    public UnsuccesfulOperationException(String errorMessage, Exception e) {
        super(errorMessage);
    }
}
