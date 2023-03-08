package org.diego.domain.bookcatalog.commands;

import org.diego.generic.Command;

public class removeBookCommand extends Command {

    private String bookCatalogId;
    private String bookId;

    public removeBookCommand(String bookCatalogId, String bookId) {
        this.bookCatalogId = bookCatalogId;
        this.bookId = bookId;
    }

    public String getBookCatalogId() {
        return bookCatalogId;
    }

    public void setBookCatalogId(String bookCatalogId) {
        this.bookCatalogId = bookCatalogId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
