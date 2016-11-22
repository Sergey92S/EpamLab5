package com.shmouradko.bank.builder;

import com.shmouradko.bank.handler.BankSAXHandler;
import org.apache.logging.log4j.Level;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by test on 21.11.2016.
 */
public class BankSaxBuilder extends AbstractBankBuilder {

    @Override
    public void buildSetBank(String fileName) {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            BankSAXHandler handler = new BankSAXHandler();
            parser.parse(fileName, handler);
            bank = handler.getBank();
        }catch (ParserConfigurationException | SAXException | IOException e){
            logger.log(Level.ERROR, "ERROR: " + e);
            throw new RuntimeException();
        }
    }

}
