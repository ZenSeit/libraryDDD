package org.diego.domain.bookcatalog.commands;

import org.diego.generic.Command;

public class AddBookCommand extends Command {

    private String bookCatalogId;
    private String bookId;
    private String bookName;
    private String authorId;
    private String authorName;
    private String authorLastName;
    private String country;
    private String authorDebutYear;
    private String releaseYear;
    private String genre;

    public AddBookCommand(String bookCatalogId, String bookId, String bookName, String authorId, String authorName, String authorLastName, String country, String authorDebutYear, String releaseYear, String genre) {
        this.bookCatalogId = bookCatalogId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorLastName = authorLastName;
        this.country = country;
        this.authorDebutYear = authorDebutYear;
        this.releaseYear = releaseYear;
        this.genre = genre;
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAuthorDebutYear() {
        return authorDebutYear;
    }

    public void setAuthorDebutYear(String authorDebutYear) {
        this.authorDebutYear = authorDebutYear;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
