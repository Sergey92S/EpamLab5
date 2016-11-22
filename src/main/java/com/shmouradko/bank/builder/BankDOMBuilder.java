package com.shmouradko.bank.builder;

import com.shmouradko.bank.parser.BankDOMParser;
import org.apache.logging.log4j.Level;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Revotech on 21.11.2016.
 */
public class BankDOMBuilder extends AbstractBankBuilder {
    private DocumentBuilderFactory factory;
    private DocumentBuilder docBuilder;
    private Document doc;

    public BankDOMBuilder() {

    }

    @Override
    public void buildSetBank(String fileName) {
        try {
            BankDOMParser parser = new BankDOMParser();
            factory = DocumentBuilderFactory.newInstance();
            docBuilder = factory.newDocumentBuilder();
            doc = docBuilder.parse(fileName);
            parser.parse(doc);
            bank = parser.getBank();
        }catch (ParserConfigurationException | SAXException | IOException e){
            logger.log(Level.ERROR, "ERROR: " + e);
            throw new RuntimeException();
        }
    }
}
