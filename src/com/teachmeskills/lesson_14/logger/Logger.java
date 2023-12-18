package com.teachmeskills.lesson_14.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.Date;

public class Logger {

    private static final String DOC_NUM="D:\\JAVA\\Lesson_14\\Lesson_14\\log\\contract\\docnum_log.txt";
    private static final String CONTRACT_NUM="D:\\JAVA\\Lesson_14\\Lesson_14\\log\\contract\\docnum_log.txt";

    private static final String LOG_INFO="D:\\JAVA\\Lesson_14\\Lesson_14\\log\\excecution_log.txt";
    private static final String ERROR_INFO="D:\\JAVA\\Lesson_14\\Lesson_14\\error\\error_log.txt";
    private static final String INVALID_INFO="D:\\JAVA\\Lesson_14\\Lesson_14\\invalid_info\\invalid.txt";


    public static void logInfo(Date date,String logMessage){
        try {
            String message=date+" -> "+logMessage+" \n";
            Files.write(Paths.get(LOG_INFO), message.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {

        }
    }

    public static void docNumInfo(File file){
        try(FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            FileOutputStream fos = new FileOutputStream(DOC_NUM)) {
            int i;
            while((i = fis.read()) != -1){
                fos.write(i);
            }
        } catch(IOException e){

        }
    }

    public static void contactNumInfo(File file){
        try(FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            FileOutputStream fos = new FileOutputStream(CONTRACT_NUM)) {

            int i;
            while((i = fis.read()) != -1){
                fos.write(i);
            }
        } catch(IOException e){

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

            Files.write(Paths.get(ERROR_INFO), sb.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {

        }
    }

    public static void invalidInfo(File file){
        try(FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            FileOutputStream fos = new FileOutputStream(INVALID_INFO)) {
            int i;
            while((i = fis.read()) != -1){
                fos.write(i);
            }
        } catch(IOException e){

        }
    }

}
