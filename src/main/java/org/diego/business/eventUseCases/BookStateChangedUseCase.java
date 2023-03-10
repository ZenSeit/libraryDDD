package org.diego.business.eventUseCases;

import org.diego.business.commons.EventsRepository;
import org.diego.business.commons.UseCaseForEvent;
import org.diego.domain.bookcatalog.BookCatalog;
import org.diego.domain.commonvalues.BookCatalogId;
import org.diego.domain.loanorder.events.LoanOrderCreated;
import org.diego.generic.DomainEvent;

import java.util.List;

public class BookStateChangedUseCase implements UseCaseForEvent<LoanOrderCreated> {

    private final EventsRepository eventsRepository;

    public BookStateChangedUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    @Override
    public List<DomainEvent> apply(LoanOrderCreated domainEvent) {
        List<DomainEvent> bookCatalogEvents =  eventsRepository.findByAggregatedRootId(domainEvent.getBookCatalogId());
        BookCatalog bookCatalog = BookCatalog.from(BookCatalogId.of(domainEvent.getBookCatalogId()),bookCatalogEvents);
        bookCatalog.changeStateBook(domainEvent.getBookId());
        return bookCatalog.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
