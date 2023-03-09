package org.diego.domain.loanorder.events;

import org.diego.generic.DomainEvent;

public class LibrarianAssigned extends DomainEvent {

    private final String librarianId;
    private final String name;
    private final String lastName;
    private final String fromHour;
    private final String toHour;

    public LibrarianAssigned(String librarianId, String name, String lastName, String fromHour, String toHour) {
        super("org.diego.assignlibrarian");
        this.librarianId = librarianId;
        this.name = name;
        this.lastName = lastName;
        this.fromHour = fromHour;
        this.toHour = toHour;
    }

    public String getLibrarianId() {
        return librarianId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFromHour() {
        return fromHour;
    }

    public String getToHour() {
        return toHour;
    }
}
