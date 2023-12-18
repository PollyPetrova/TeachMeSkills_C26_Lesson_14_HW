package com.teachmeskills.lesson_14.service;

import com.teachmeskills.lesson_14.exception.CheckContractNumberException;
import com.teachmeskills.lesson_14.exception.CheckDocumentNumberException;
import com.teachmeskills.lesson_14.logger.Logger;
import com.teachmeskills.lesson_14.validation.Validation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

public class ValidationService {

    public static void validationService(File file) throws IOException {

        String[] arrays= Files.readString(Path.of(file.getAbsolutePath())).split("\n");
        for (String array: arrays) {

            try {
                Logger.logInfo(new Date(),"Document number on validation");
                Validation.checkValidationOfDocumentNumber(file);
                Logger.logInfo(new Date(),"Your document number was checked");
            }catch (CheckDocumentNumberException e){
                Logger.errorInfo(new Date(),e.getMessage(), e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                Logger.logInfo(new Date(),"Contact number on validation");
                Validation.checkValidationOfContract(file);
                Logger.logInfo(new Date(),"Your contact number was checked");
            } catch (CheckContractNumberException e) {
                Logger.errorInfo(new Date(),e.getMessage(), e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
