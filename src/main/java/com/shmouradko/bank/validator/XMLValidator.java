package com.shmouradko.bank.validator;

import com.shmouradko.bank.handler.BankErrorHandler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by test on 22.11.2016.
 */
public class XMLValidator {
    static Logger logger = LogManager.getLogger();

    public void validate(String xsd, String xml){
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsd));
            Validator validator = schema.newValidator();
            validator.setErrorHandler(new BankErrorHandler());
            validator.validate(new StreamSource(new File(xml)));
        } catch (SAXException | IOException e) {
            logger.log(Level.ERROR, "ERROR: " + e);
            throw new RuntimeException();
        }
    }

}
