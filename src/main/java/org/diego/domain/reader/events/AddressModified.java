package org.diego.domain.reader.events;

import org.diego.generic.DomainEvent;

public class AddressModified extends DomainEvent {

    private final String street;

    private final String avenue;

    private final int houseNumber;

    public AddressModified(String street, String avenue, int houseNumber) {
        super("org.diego.addressmodified");
        this.street = street;
        this.avenue = avenue;
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getAvenue() {
        return avenue;
    }

    public int getHouseNumber() {
        return houseNumber;
    }
}
