package org.diego.domain.reader.events;

import org.diego.generic.DomainEvent;

public class ReaderRegistered extends DomainEvent {

    private final String accountId;
    private final String name;
    private final String lastName;
    private final String email;
    private final String avenue;
    private final String street;
    private final int houseNumber;
    private final String dni;

    public ReaderRegistered(String accountId, String name, String lastName, String email, String avenue, String street, int houseNumber, String dni) {
        super("org.diego.readercreated");
        this.accountId = accountId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.avenue = avenue;
        this.street = street;
        this.houseNumber = houseNumber;
        this.dni = dni;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAvenue() {
        return avenue;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getDni() {
        return dni;
    }
}
