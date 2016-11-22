package com.shmouradko.bank.entity;

/**
 * Created by Revotech on 21.11.2016.
 */
public class BankDeposit extends Component{
    private int profitability, timeConstraint, accountId;
    private String name, country, type;

    public BankDeposit() {

    }

    public int getProfitability() {
        return profitability;
    }

    public void setProfitability(int profitability) {
        this.profitability = profitability;
    }

    public int getTimeConstraint() {
        return timeConstraint;
    }

    public void setTimeConstraint(int timeConstraint) {
        this.timeConstraint = timeConstraint;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "[ID: " + getId() + "] [BankName: " + name + "] [Type: " + type
                + "] [Country: " + country + "] [Profitability: " + profitability
                + "] [TimeConstraint: " + timeConstraint + "] [AccountId: "
                + accountId + "]\n";
    }

}
