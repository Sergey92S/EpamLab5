package com.shmouradko.bank.runner;

import com.shmouradko.bank.builder.AbstractBankBuilder;
import com.shmouradko.bank.builder.HTMLBuilder;
import com.shmouradko.bank.factory.BankBuilderFactory;
import com.shmouradko.bank.report.ParsersReports;
import com.shmouradko.bank.validator.XMLValidator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Revotech on 21.11.2016.
 */
public class BankRunner {
    private static final String DOM = "dom";
    private static final String SAX = "sax";
    private static final String STAX = "stax";
    private static final String XML_PATH = System.getProperty("user.dir") + "\\xml\\bank.xml";
    private static final String XSL_PATH = System.getProperty("user.dir") + "\\xml\\bank.xsl";
    private static final String XSD_PATH = System.getProperty("user.dir") + "\\xml\\bank.xsd";
    private static final String HTML_PATH = System.getProperty("user.dir") + "\\xml\\bank.html";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        XMLValidator validator = new XMLValidator();
        validator.validate(XSD_PATH, XML_PATH);

        AbstractBankBuilder abstractBankBuilder;
        BankBuilderFactory bankBuilderFactory = new BankBuilderFactory();

        abstractBankBuilder = bankBuilderFactory.createBankBuilder(DOM);
        abstractBankBuilder.buildSetBank(XML_PATH);
        ParsersReports.report(DOM.toUpperCase(), abstractBankBuilder.getBank());

        abstractBankBuilder = bankBuilderFactory.createBankBuilder(SAX);
        abstractBankBuilder.buildSetBank(XML_PATH);
        ParsersReports.report(SAX.toUpperCase(), abstractBankBuilder.getBank());

        abstractBankBuilder = bankBuilderFactory.createBankBuilder(STAX);
        abstractBankBuilder.buildSetBank(XML_PATH);
        ParsersReports.report(STAX.toUpperCase(), abstractBankBuilder.getBank());

        HTMLBuilder builder = new HTMLBuilder();
        builder.build(XSL_PATH, XML_PATH, HTML_PATH);

    }
}
