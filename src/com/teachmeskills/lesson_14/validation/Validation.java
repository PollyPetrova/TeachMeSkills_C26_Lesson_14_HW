package com.teachmeskills.lesson_14.validation;

import com.teachmeskills.lesson_14.exception.CheckContractNumberException;
import com.teachmeskills.lesson_14.exception.CheckDocumentNumberException;
import com.teachmeskills.lesson_14.service.WriterToFile;
import com.teachmeskills.lesson_14.utils.Utils;


public class Validation {

    public static void checkValidationOfDocumentNumber(String str) throws CheckDocumentNumberException {

        if(!str.startsWith("docnum") || !str.matches("[A-Za-z0-9]+")){
            WriterToFile.writeToFile(Utils.INVALID_INFO, str);
            throw new CheckDocumentNumberException("Document number need to start with 'docnum' and then any sequence of letters/numbers!");
        }

        else if(str.length()!= Utils.RIGHT_LENGTH){
            WriterToFile.writeToFile(Utils.INVALID_INFO, str);
            throw new CheckDocumentNumberException("The length of the document number must be equal to 15 characters");
        } else {
            WriterToFile.writeToFile(Utils.DOC_NUM, str);
        }

    }

    public static void checkValidationOfContract(String str) throws CheckContractNumberException {

        if(!str.startsWith("contract") || !str.matches("[A-Za-z0-9]+")){
            WriterToFile.writeToFile(Utils.INVALID_INFO, str);
            throw new CheckContractNumberException("Contract number need to start with 'contract' and then any sequence of letters/numbers!");
        }

        else if(str.length()!= Utils.RIGHT_LENGTH){
            WriterToFile.writeToFile(Utils.INVALID_INFO, str);
            throw new CheckContractNumberException("The length of the contract number must be equal to 15 characters");
        } else {
            WriterToFile.writeToFile(Utils.CONTRACT_NUM, str);
        }

    }

}
