package com.shmouradko.bank.handler;

import com.shmouradko.bank.entity.Bank;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 21.11.2016.
 */
public class BankSAXHandler extends DefaultHandler {
    private List<Bank> bankList = new ArrayList<>();
    private Bank bank = null;
    private String tagContent = null;

    public void startElement(String uri, String localName, String qname, Attributes attr){
        switch(qname){
            case "bank":
                bank = new Bank();
                break;

            case "depositor":
                bank.defineIdFromDepositor(attr.getValue(0));
                break;

            case "name":
                for(int i = 0; i < attr.getLength(); i++) {
                    switch (attr.getLocalName(i)) {
                        case "firstname":
                            bank.defineFirstNameFromDepositor(attr.getValue(i));
                            break;

                        case "surname":
                            bank.defineSurnameNameFromDepositor(attr.getValue(i));
                            break;

                        default:
                            break;
                    }
                }
                break;

            case "bank-deposit":
                bank.createNewInstanceOfBankDeposit();
                bank.defineIdFromBankDeposit(attr.getValue(0));
                break;

            default:
                break;

        }
    }

    public void characters(char[] ch, int start, int length){
        tagContent = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qname){
        switch(qname){
            case "bank":{
                bankList.add(bank);
                bank = null;
                break;
            }
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
    }

    public List<Bank> getBank() {
        return bankList;
    }

}
