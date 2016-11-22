package com.shmouradko.bank.parser;

import com.shmouradko.bank.entity.Bank;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 21.11.2016.
 */
public class BankStAXParser {
    static Logger logger = LogManager.getLogger();
    private List<Bank> bankList = new ArrayList<>();
    private Bank bank = null;
    private String tagContent = null;

    public void parse(InputStream input) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(input);

            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:

                        switch (reader.getLocalName()) {
                            case "bank":
                                bank = new Bank();
                                break;

                            case "depositor":
                                bank.defineIdFromDepositor(reader.getAttributeValue(0));
                                break;

                            case "name":
                                for (int i = 0; i < reader.getAttributeCount(); i++) {
                                    switch (reader.getAttributeLocalName(i)) {
                                        case "firstname":
                                            bank.defineFirstNameFromDepositor(reader.getAttributeValue(i));
                                            break;

                                        case "surname":
                                            bank.defineSurnameNameFromDepositor(reader.getAttributeValue(i));
                                            break;

                                        default:
                                            break;
                                    }
                                }
                                break;

                            case "bank-deposit":
                                bank.createNewInstanceOfBankDeposit();
                                bank.defineIdFromBankDeposit(reader.getAttributeValue(0));
                                break;

                            default:
                                break;

                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        switch (reader.getLocalName()) {
                            case "bank":
                                bankList.add(bank);
                                bank = null;
                                break;

                            case "bankname":
                                bank.defineNameFromBankDeposit(tagContent);
                                break;
                            case "country":
                                bank.defineCountryFromBankDeposit(tagContent);
                                break;
                            case "type":
                                bank.defineTypeFromBankDeposit(tagContent);
                                break;
                            case "accountid":
                                bank.defineAccountIdFromBankDeposit(Integer.parseInt(tagContent));
                                break;
                            case "profitability":
                                bank.defineProfitabilityFromBankDeposit(Integer.parseInt(tagContent));
                                break;
                            case "timeconstraints":
                                bank.defineTimeConstraintFromBankDeposit(Integer.parseInt(tagContent));
                                break;
                            default:
                                break;
                        }
                        break;

                    default:
                        break;

                }
            }
        }catch (XMLStreamException e){
            logger.log(Level.ERROR, "ERROR: " + e);
            throw new RuntimeException();
        }
    }

    public List<Bank> getBank() {
        return bankList;
    }

}
