package org.diego.business.bookcatalog;

import org.diego.business.commons.EventsRepository;
import org.diego.business.commons.UserCaseForCommand;
import org.diego.domain.bookcatalog.BookCatalog;
import org.diego.domain.bookcatalog.commands.ChangeStateBookCommand;
import org.diego.domain.commonvalues.BookCatalogId;
import org.diego.generic.DomainEvent;

import java.util.List;

public class BookStateChangeUseCase implements UserCaseForCommand<ChangeStateBookCommand> {

    private final EventsRepository eventsRepository;

    public BookStateChangeUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ChangeStateBookCommand command) {

        List<DomainEvent> bookCatalogEvents =  eventsRepository.findByAggregatedRootId(command.getBookCatalogId());
        BookCatalog bookCatalog = BookCatalog.from(BookCatalogId.of(command.getBookId()),bookCatalogEvents);
        bookCatalog.changeStateBook(command.getBookId());
        return bookCatalog.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
