package com.shmouradko.bank.builder;

import com.shmouradko.bank.parser.BankStAXParser;
import org.apache.logging.log4j.Level;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by test on 21.11.2016.
 */
public class BankStAXBuilder extends AbstractBankBuilder {

    @Override
    public void buildSetBank(String fileName){
        BankStAXParser parser = new BankStAXParser();
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(fileName);
            parser.parse(inputStream);
            bank = parser.getBank();
        } catch (FileNotFoundException e) {
            logger.log(Level.ERROR, "ERROR: " + e);
            throw new RuntimeException();
        }
    }

}
