package org.diego.domain.bookcatalog;

import org.diego.domain.bookcatalog.events.BookAdded;
import org.diego.domain.bookcatalog.events.BookCatalogCreated;
import org.diego.domain.bookcatalog.events.BookRemoved;
import org.diego.domain.bookcatalog.values.Country;
import org.diego.domain.bookcatalog.values.DebutYear;
import org.diego.domain.bookcatalog.values.Genre;
import org.diego.domain.bookcatalog.values.ReleaseYear;
import org.diego.domain.commonvalues.*;
import org.diego.generic.EventChange;

import java.util.ArrayList;

public class BookCatalogChange extends EventChange {

    public BookCatalogChange(BookCatalog bookCatalog) {
        apply((BookCatalogCreated event) ->{
            bookCatalog.name = new Name(event.getName());
            bookCatalog.book = new ArrayList<Book>();
            bookCatalog.createdAt = new CreatedAt();
        });

        apply((BookAdded event)->{
            Book book = new Book(
                    BookId.of(event.getBookId()),
                    new Name(event.getName()),
                    new Author(
                            AuthorId.of(event.getAuthorId()),
                            new FullName(event.getAuthorName(), event.getAuthorLastName()),
                            new Country(event.getAuthorCountry()),
                            new DebutYear(event.getAuthorDebutYear())
                    ),
                    new ReleaseYear(event.getReleaseYear()),
                    new Genre(event.getGenre())
            );
            bookCatalog.book.add(book);
        });

        apply((BookRemoved event)->{
            bookCatalog.book = bookCatalog.book.stream()
                    .filter(bk->!bk.identity().value().equalsIgnoreCase(event.getBookId()))
                    .toList();
        });

        //apply(()->{});
    }
}
