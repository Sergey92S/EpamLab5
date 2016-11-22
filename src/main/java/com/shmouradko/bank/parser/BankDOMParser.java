package com.shmouradko.bank.parser;

import com.shmouradko.bank.entity.Bank;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 22.11.2016.
 */
public class BankDOMParser {
    private Bank currentBank;
    private List<Bank> bank = new ArrayList<>();
    private String bankName;
    private String type;
    private String country;
    private String firstName;
    private String surname;
    private String bankDepositId;
    private String depositorId;
    private int profitability;
    private int timeConstraints;
    private int accountId;

    public void parse(Document doc){
        NodeList depositorBankNodes = doc.getElementsByTagName("depositor-bank");

        for (int i = 0; i < depositorBankNodes.getLength(); i++) {
            bank.add(currentBank = new Bank());
            Element depositorBankElement = (Element) depositorBankNodes.item(i);
            NodeList depositorNodeList = depositorBankElement.getElementsByTagName("depositor");
            Element depositorElement = (Element) depositorNodeList.item(0);
            depositorId = depositorElement.getAttribute("id");
            NodeList nameNodeList = depositorElement.getElementsByTagName("name");
            Element nameElement = (Element) nameNodeList.item(0);
            firstName = nameElement.getAttribute("firstname");
            surname = nameElement.getAttribute("surname");
            NodeList bankDepositsNodeList = depositorBankElement.getElementsByTagName("bank-deposits");
            Element bankDepositsElement = (Element) bankDepositsNodeList.item(0);
            NodeList bankDepositNodeList = bankDepositsElement.getElementsByTagName("bank-deposit");
            currentBank.defineFirstNameFromDepositor(firstName).defineSurnameNameFromDepositor(surname).defineIdFromDepositor(depositorId);
            for (int j = 0; j < bankDepositNodeList.getLength(); j++) {
                currentBank.createNewInstanceOfBankDeposit();
                Element bankDepositElement = (Element) bankDepositNodeList.item(j);
                bankDepositId = bankDepositElement.getAttribute("id");
                bankName = bankDepositElement.getElementsByTagName("bankname").item(0).getChildNodes().item(0).getNodeValue();
                profitability = Integer.parseInt(bankDepositElement.getElementsByTagName("profitability").item(0).getChildNodes().item(0).getNodeValue());
                timeConstraints = Integer.parseInt(bankDepositElement.getElementsByTagName("timeconstraints").item(0).getChildNodes().item(0).getNodeValue());
                type = bankDepositElement.getElementsByTagName("type").item(0).getChildNodes().item(0).getNodeValue();
                country = bankDepositElement.getElementsByTagName("country").item(0).getChildNodes().item(0).getNodeValue();
                accountId = Integer.parseInt(bankDepositElement.getElementsByTagName("accountid").item(0).getChildNodes().item(0).getNodeValue());
                currentBank.defineIdFromBankDeposit(bankDepositId).defineNameFromBankDeposit(bankName).defineAccountIdFromBankDeposit(accountId).defineCountryFromBankDeposit(country).defineProfitabilityFromBankDeposit(profitability).defineTimeConstraintFromBankDeposit(timeConstraints).defineTypeFromBankDeposit(type);
            }
        }
    }

    public List<Bank> getBank() {
        return bank;
    }

}
