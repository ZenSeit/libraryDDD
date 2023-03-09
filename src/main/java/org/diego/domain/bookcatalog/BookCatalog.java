package org.diego.domain.bookcatalog;

import org.diego.domain.bookcatalog.events.BookAdded;
import org.diego.domain.bookcatalog.events.BookCatalogCreated;
import org.diego.domain.bookcatalog.events.BookRemoved;
import org.diego.domain.bookcatalog.events.BookStateChanged;
import org.diego.domain.commonvalues.BookCatalogId;
import org.diego.domain.commonvalues.CreatedAt;
import org.diego.domain.commonvalues.Name;
import org.diego.generic.AggregateRoot;
import org.diego.generic.DomainEvent;

import java.util.List;

public class BookCatalog extends AggregateRoot<BookCatalogId> {

    protected Name name;
    protected List<Book> book;
    protected CreatedAt createdAt;

    public BookCatalog(BookCatalogId id,String name) {
        super(id);
        subscribe(new BookCatalogChange(this));
        appendChange(new BookCatalogCreated(name)).apply();
    }

    private BookCatalog (BookCatalogId id){
        super(id);
        subscribe(new BookCatalogChange(this));
    }

    public static BookCatalog from (BookCatalogId id, List<DomainEvent> events){
        BookCatalog bookCatalog = new BookCatalog(id);
        events.forEach(event ->bookCatalog.applyEvent(event));
        return bookCatalog;
    }

    public void AddBook(String bookId,String name,String authorId,String authorName,String authorLastName,String authorCountry
    ,String authorDebutYear,String releaseYear,String genre){
        appendChange(new BookAdded(bookId,name,authorId,authorName,authorLastName,authorCountry,authorDebutYear,releaseYear,
                genre)).apply();
    }

    public void removeBook(String bookId){
        appendChange(new BookRemoved(bookId)).apply();
    }

    public void changeStateBook(String bookId){
        appendChange(new BookStateChanged(bookId)).apply();
    }


}
