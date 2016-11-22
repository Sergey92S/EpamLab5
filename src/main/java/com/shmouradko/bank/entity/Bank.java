package com.shmouradko.bank.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Revotech on 21.11.2016.
 */
public class Bank {
    public Depositor depositor = new Depositor();
    public List<BankDeposit> bankDepositList = new ArrayList<>();

    public Bank() {

    }

    public void createNewInstanceOfBankDeposit() {
        bankDepositList.add(new BankDeposit());
    }

    public Bank defineIdFromDepositor(String id) {
        depositor.setId(id);
        return this;
    }

    public Bank defineIdFromBankDeposit(String id) {
        bankDepositList.get(bankDepositList.size() - 1).setId(id);
        return this;
    }

    public Bank defineFirstNameFromDepositor(String name) {
        depositor.setFirstName(name);
        return this;
    }

    public Bank defineSurnameNameFromDepositor(String name) {
        depositor.setSurname(name);
        return this;
    }

    public Bank defineNameFromBankDeposit(String name) {
        bankDepositList.get(bankDepositList.size() - 1).setName(name);
        return this;
    }

    public Bank defineCountryFromBankDeposit(String country) {
        bankDepositList.get(bankDepositList.size() - 1).setCountry(country);
        return this;
    }

    public Bank defineTypeFromBankDeposit(String type) {
        bankDepositList.get(bankDepositList.size() - 1).setType(type);
        return this;
    }

    public Bank defineProfitabilityFromBankDeposit(int profitability) {
        bankDepositList.get(bankDepositList.size() - 1).setProfitability(
                profitability);
        return this;
    }

    public Bank defineTimeConstraintFromBankDeposit(int timeConstraint) {
        bankDepositList.get(bankDepositList.size() - 1).setTimeConstraint(
                timeConstraint);
        return this;
    }

    public Bank defineAccountIdFromBankDeposit(int accountId) {
        bankDepositList.get(bankDepositList.size() - 1).setAccountId(accountId);
        return this;
    }

}
