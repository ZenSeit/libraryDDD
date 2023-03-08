package org.diego.domain.bookcatalog.events;

import org.diego.generic.DomainEvent;

public class BookAdded extends DomainEvent {

    private final String bookId;
    private final String name;
    private final String authorId;
    private final String authorName;
    private final String authorLastName;
    private final String authorCountry;
    private final String authorDebutYear;
    private final String releaseYear;
    private final String genre;

    public BookAdded(String bookId, String name, String authorId, String authorName, String authorLastName, String authorCountry, String authorDebutYear, String releaseYear, String genre) {
        super("org.diego.bookaddedtocatalog");
        this.bookId = bookId;
        this.name = name;
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorLastName = authorLastName;
        this.authorCountry = authorCountry;
        this.authorDebutYear = authorDebutYear;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public String getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getAuthorCountry() {
        return authorCountry;
    }

    public String getAuthorDebutYear() {
        return authorDebutYear;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }
}
