package org.diego.domain.bookcatalog.events;

import org.diego.generic.DomainEvent;

public class BookStateChanged extends DomainEvent {

    private final String bookId;

    public BookStateChanged(String bookId) {
        super("org.diego.bookstatechanged");
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }
}
