package org.diego.domain.bookcatalog.events;

import org.diego.generic.DomainEvent;

public class BookCatalogCreated extends DomainEvent {

    private final String name;

    public BookCatalogCreated(String name) {
        super("org.diego.bookcatalogcreated");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
