package org.diego.domain.bookcatalog.events;

import org.diego.generic.DomainEvent;

public class BookRemoved extends DomainEvent {

    private final String bookId;

    public BookRemoved(String bookId) {
        super("org.diego.bookdeleted");
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }
}
