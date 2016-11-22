package com.shmouradko.bank.factory;

import com.shmouradko.bank.builder.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Revotech on 21.11.2016.
 */
public class BankBuilderFactory {
    static Logger logger = LogManager.getLogger();

    public AbstractBankBuilder createBankBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new BankDOMBuilder();
            case STAX:
                return new BankStAXBuilder();
            case SAX:
                return new BankSaxBuilder();
            default:
                logger.log(Level.ERROR, "ERROR PARSER ");
                throw new RuntimeException();
        }
    }

}
