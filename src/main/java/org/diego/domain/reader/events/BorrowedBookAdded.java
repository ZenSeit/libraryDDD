package org.diego.domain.reader.events;

import org.diego.generic.DomainEvent;

public class BorrowedBookAdded extends DomainEvent {

    public BorrowedBookAdded() {
        super("org.diego.borrowedbookadded");
    }
}
