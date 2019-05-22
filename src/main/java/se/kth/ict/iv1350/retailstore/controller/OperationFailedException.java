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
public class OperationFailedException extends Exception{
    
    public OperationFailedException(String msg, Exception e) {
        super(msg, e);
    }
}
