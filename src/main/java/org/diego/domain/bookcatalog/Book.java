package org.diego.domain.bookcatalog;

import org.diego.domain.bookcatalog.values.Genre;
import org.diego.domain.bookcatalog.values.IsBorrow;
import org.diego.domain.bookcatalog.values.ReleaseYear;
import org.diego.domain.commonvalues.BookId;
import org.diego.domain.commonvalues.Name;
import org.diego.generic.Entity;

public class Book extends Entity<BookId> {

    private Name name;
    private Author author;
    private ReleaseYear releaseYear;
    private Genre genre;
    private IsBorrow isBorrow;

    public Book(BookId id, Name name, Author author, ReleaseYear releaseYear, Genre genre) {
        super(id);
        this.name = name;
        this.author = author;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.isBorrow = new IsBorrow(false);
    }

    public Name Name() {
        return name;
    }

    public Author Author() {
        return author;
    }

    public ReleaseYear ReleaseYear() {
        return releaseYear;
    }

    public Genre Genre() {
        return genre;
    }

    public IsBorrow IsBorrow() {
        return isBorrow;
    }

    public void changeIsBorrow(boolean value){
        this.isBorrow=new IsBorrow(value);
    }
}
