package org.diego.business.bookcatalog.mocks;

import org.diego.domain.bookcatalog.events.BookAdded;
import org.diego.domain.bookcatalog.events.BookCatalogCreated;
import org.diego.generic.DomainEvent;

public class BookCatalogMocks {

    public static DomainEvent bookCatalog (){
        return new BookCatalogCreated("Main");
    }

    public static DomainEvent addBookToCatalog(){
        return new BookAdded("bookId","bookTest",
                "authorId","yakuzuko","Torika","Peru","12/09/1989",
                "06/07/2001","genreTest");
    }
}
