package com.teachmeskills.lesson_14.service;

import com.teachmeskills.lesson_14.exception.CheckContractNumberException;
import com.teachmeskills.lesson_14.exception.CheckDocumentNumberException;
import com.teachmeskills.lesson_14.logger.Logger;
import com.teachmeskills.lesson_14.utils.Utils;
import com.teachmeskills.lesson_14.validation.Validation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

public class ValidationService {

    public static void validationService(File file) throws IOException {

        Path path = file.toPath();
        String[] arrays = Files.readAllLines(path).toArray(new String[0]);

        for (String array: arrays) {

            if (array.startsWith(Utils.DOCNUM)) {
                try {
                    Logger.logInfo(new Date(),"Document number on validation");
                    Validation.checkValidationOfDocumentNumber(array);
                    Logger.logInfo(new Date(),"Your document number was checked");
                } catch (CheckDocumentNumberException e) {
                    Logger.errorInfo(new Date(), e.getMessage(), e);
                }
            } else if (array.startsWith(Utils.CONTRACT)) {
                try {
                    Logger.logInfo(new Date(), "Contact number on validation");
                    Validation.checkValidationOfContract(array);
                    Logger.logInfo(new Date(),"Your contact number was checked");
                } catch (CheckContractNumberException e) {
                    Logger.errorInfo(new Date(), e.getMessage(), e);
                }
            }

        }

    }

}
