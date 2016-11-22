package com.shmouradko.bank.builder;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by test on 22.11.2016.
 */
public class HTMLBuilder {
    static Logger logger = LogManager.getLogger();

    public void build(String xsl, String xml, String output){
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsl));
            transformer.transform(new StreamSource(xml), new StreamResult(output));
        } catch (TransformerException e) {
            logger.log(Level.ERROR, "ERROR: " + e);
            throw new RuntimeException();
        }
    }

}
