/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Class responsible for notifying customers about eventual errors, by printing
 * a message containing the error.
 * 
 */
public class ErrorMessageHandler {
    
    /**
     * Assembles a string containing timestamp, error and prints.
     * @param msg the message to be visible for customers.
     */
    
    void errorMsg(String msg) {
        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append(createTime() + "\n");
        msgBuilder.append("ERROR: ");
        msgBuilder.append(msg + "\n");
        System.out.println(msgBuilder.toString());
    }
    
    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
