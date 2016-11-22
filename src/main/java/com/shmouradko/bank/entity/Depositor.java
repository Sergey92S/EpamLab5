package com.shmouradko.bank.entity;

/**
 * Created by Revotech on 21.11.2016.
 */
public class Depositor extends Component {
    private String firstName, surname;

    public Depositor() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "[ID: " + getId() + "] [FirstName: " + firstName + "] [Surname: "
                + surname + "]\n";
    }

}
