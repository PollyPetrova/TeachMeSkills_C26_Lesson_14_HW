package com.teachmeskills.lesson_14.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {

    public static void writeToFile(String fileName, String str) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(str);
            writer.newLine();
        } catch (IOException e) {

        }
    }
}
