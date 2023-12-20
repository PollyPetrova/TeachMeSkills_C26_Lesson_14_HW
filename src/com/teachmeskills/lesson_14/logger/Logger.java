package com.teachmeskills.lesson_14.logger;

import com.teachmeskills.lesson_14.utils.Utils;

import java.io.IOException;
import java.nio.file.*;
import java.util.Date;

public class Logger {

    public static void logInfo(Date date,String logMessage){
        try {
            String message=date+" -> "+logMessage+" \n";
            Files.write(Paths.get(Utils.LOG_INFO), message.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {

        }
    }

    public static void errorInfo(Date date,String errorMessage, Exception exception){
        try {
            StringBuilder sb=new StringBuilder();
            sb.append(date+" -> "+errorMessage+" \n");

            StackTraceElement[] traceElements= exception.getStackTrace();
            for (StackTraceElement element: traceElements) {
                sb.append(element.toString());
                sb.append("\n");
            }

            Files.write(Paths.get(Utils.ERROR_INFO), sb.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {

        }
    }

}
