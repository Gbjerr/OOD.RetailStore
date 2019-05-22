/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.retailstore.loghandler;

import se.kth.ict.iv1350.retailstore.controller.UnsuccesfulOperationException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author gurra
 */
public class LogHandler {
    private static final String LOG_FILE_NAME = "sale-log.txt";
    private PrintWriter logFile;
    private static final LogHandler LOG_HANDLER;

    static {
        LogHandler tmp = null;
        try {
            tmp = new LogHandler();
        }
        catch(IOException e) {
            tmp.logException(e);
        }
        LOG_HANDLER = tmp;
    }
    
    public static LogHandler getLogger() {
        return LOG_HANDLER;
    }
    
    public LogHandler() throws IOException {
        logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
    }
    
    public void logException(Exception exception){
        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append(createTime() + ", ");
        msgBuilder.append("Exception was thrown: ");
        msgBuilder.append(exception.getMessage());
        logFile.println(msgBuilder);
        exception.printStackTrace(logFile);
    }
    
    
    
    public String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
