package com.teachmeskills.lesson_14;

import com.teachmeskills.lesson_14.service.ValidationService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Допустим есть файл с номерами документов.
 * Номером документа является строка, состоящая из букв и цифр(без служебных символов).
 * Пусть этот файл содержит каждый номер документа с новой строки и в строке никакой
 * другой информации, только номер документа.
 * Валидный номер документа должен иметь длину 15 символов и начинаться с последовательности
 * docnum(далее любая последовательность букв/цифр) или сontract(далее любая последовательность букв/цифр).
 * Написать программу для чтения информации из входного файла - путь к входному
 * файлу должне задаваться через консоль.
 * Программа должна проверять номера документов на валидность.
 * Валидные номера документов docnum следует записать в один файл-отчет.
 * Валидные номера контрактов сontract следует записать в другой файл-отчет.
 * Ошикби, если они возникнут, следует записывать в файл error_log.txt
 * Логи следует записывать в файл execution_log.txt
 * Невалидные номера документов следует записать в другой файл-отчет, но после номеров
 * документов следует добавить ифнформацию о том, почему этот документ
 * невалиден (неправильная последовательность символов в начале/есть служебные символы в имени документа и другое).
 */

public class Runner {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path of file for documents!");
        String pathToFile = scanner.nextLine();
        File file = new File(pathToFile);

        String[] arrays= Files.readString(Path.of(file.getAbsolutePath())).split("\n");
        for (String array: arrays) {
            System.out.println(array+" "+array.length());
        }

        if (!file.exists()) {
            System.out.println("File doesn't exist!");
            return;
        }
        try {
            ValidationService.validationService(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
