package com.teachmeskills.lesson_14.validation;

import com.teachmeskills.lesson_14.exception.CheckContractNumberException;
import com.teachmeskills.lesson_14.exception.CheckDocumentNumberException;
import com.teachmeskills.lesson_14.logger.Logger;
import com.teachmeskills.lesson_14.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Validation {

    public static void checkValidationOfDocumentNumber( File file) throws CheckDocumentNumberException, IOException {

        if(!Files.readString(file.toPath()).startsWith("docnum") && !Files.readString(file.toPath()).matches("[A-Za-z0-9]+")){
            Logger.invalidInfo(file);
            throw new CheckDocumentNumberException("Document number need to start with 'docnum' and then any sequence of letters/numbers!");
        }

        if(Files.readString(file.toPath()).length()!= Utils.RIGHT_LENGTH){
            Logger.invalidInfo(file);
            throw new CheckDocumentNumberException("The length of the document number must be equal to 15 characters");
        }
        Logger.docNumInfo(file);

    }

    public static void checkValidationOfContract(File file) throws CheckContractNumberException, IOException {

        if(!Files.readString(file.toPath()).startsWith("contract") && !Files.readString(file.toPath()).matches("[A-Za-z0-9]+")){
            Logger.invalidInfo(file);
            throw new CheckContractNumberException("Contract number need to start with 'contract' and then any sequence of letters/numbers!");
        }

        if(Files.readString(file.toPath()).length()!= Utils.RIGHT_LENGTH){
            Logger.invalidInfo(file);
            throw new CheckContractNumberException("The length of the contract number must be equal to 15 characters");
        }
        Logger.contactNumInfo(file);

    }

}
