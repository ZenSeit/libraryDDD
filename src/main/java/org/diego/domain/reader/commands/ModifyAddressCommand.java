package org.diego.domain.reader.commands;

import org.diego.generic.Command;

public class ModifyAddressCommand extends Command {

    private String readerId;
    private String street;
    private String avenue;
    private int houseNumber;

    public ModifyAddressCommand(String readerId, String street, String avenue, int houseNumber) {
        this.readerId = readerId;
        this.street = street;
        this.avenue = avenue;
        this.houseNumber = houseNumber;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAvenue() {
        return avenue;
    }

    public void setAvenue(String avenue) {
        this.avenue = avenue;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
}
