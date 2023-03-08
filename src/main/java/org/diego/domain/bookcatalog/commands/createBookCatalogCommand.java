package org.diego.domain.bookcatalog.commands;

import org.diego.generic.Command;

public class createBookCatalogCommand extends Command {

    private String bookCatalogId;
    private String name;

    public createBookCatalogCommand(String bookCatalogId, String name) {
        this.bookCatalogId = bookCatalogId;
        this.name = name;
    }

    public String getBookCatalogId() {
        return bookCatalogId;
    }

    public void setBookCatalogId(String bookCatalogId) {
        this.bookCatalogId = bookCatalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
