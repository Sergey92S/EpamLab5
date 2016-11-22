package com.shmouradko.bank.handler;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by test on 22.11.2016.
 */
public class BankErrorHandler implements ErrorHandler {
    static Logger logger = LogManager.getLogger();

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        logger.log(Level.WARN, "WARNING: " + exception);
        logger.log(Level.WARN, "line = " + exception.getLineNumber() + "  col = "
                + exception.getColumnNumber());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        logger.log(Level.ERROR, "ERROR: " + exception);
        logger.log(Level.ERROR, "line = " + exception.getLineNumber() + "  col = "
                + exception.getColumnNumber());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        logger.log(Level.FATAL, "FATAL: " + exception);
        logger.log(Level.FATAL, "line = " + exception.getLineNumber() + "  col = "
                + exception.getColumnNumber());
    }
}
