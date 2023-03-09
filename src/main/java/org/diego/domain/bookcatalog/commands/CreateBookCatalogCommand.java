package org.diego.domain.bookcatalog.commands;

import org.diego.generic.Command;

public class CreateBookCatalogCommand extends Command {

    private String bookCatalogId;
    private String name;

    public CreateBookCatalogCommand(String bookCatalogId, String name) {
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
