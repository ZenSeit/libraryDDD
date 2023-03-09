package org.diego.domain.loanorder.commands;

import org.diego.generic.Command;

public class AssignLibrarianCommand extends Command {

    private String loanOrderId;
    private String librarianId;
    private String name;
    private String lastName;
    private String fromHour;
    private String toHour;

    public AssignLibrarianCommand(String loanOrderId, String librarianId, String name, String lastName, String fromHour, String toHour) {
        this.loanOrderId = loanOrderId;
        this.librarianId = librarianId;
        this.name = name;
        this.lastName = lastName;
        this.fromHour = fromHour;
        this.toHour = toHour;
    }

    public String getLoanOrderId() {
        return loanOrderId;
    }

    public void setLoanOrderId(String loanOrderId) {
        this.loanOrderId = loanOrderId;
    }

    public String getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(String librarianId) {
        this.librarianId = librarianId;
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

    public String getFromHour() {
        return fromHour;
    }

    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    public String getToHour() {
        return toHour;
    }

    public void setToHour(String toHour) {
        this.toHour = toHour;
    }
}
