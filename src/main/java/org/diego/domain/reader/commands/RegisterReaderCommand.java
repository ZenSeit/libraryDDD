package org.diego.domain.reader.commands;

import org.diego.generic.Command;

public class RegisterReaderCommand extends Command {

    private String readerId;
    private String accountId;
    private String name;
    private String lastName;
    private String email;
    private String avenue;
    private String street;
    private int houseNumber;
    private String dni;

    public RegisterReaderCommand(String readerId, String accountId, String name, String lastName, String email, String avenue, String street, int houseNumber, String dni) {
        this.readerId = readerId;
        this.accountId = accountId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.avenue = avenue;
        this.street = street;
        this.houseNumber = houseNumber;
        this.dni = dni;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvenue() {
        return avenue;
    }

    public void setAvenue(String avenue) {
        this.avenue = avenue;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
