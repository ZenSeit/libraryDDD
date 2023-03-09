package org.diego.business.bookcatalog;

import org.diego.business.commons.EventsRepository;
import org.diego.business.commons.UserCaseForCommand;
import org.diego.domain.bookcatalog.BookCatalog;
import org.diego.domain.bookcatalog.commands.CreateBookCatalogCommand;
import org.diego.domain.commonvalues.BookCatalogId;
import org.diego.generic.DomainEvent;

import java.util.List;

public class BookCatalogCreatedUseCase implements UserCaseForCommand<CreateBookCatalogCommand> {

    private final EventsRepository eventsRepository;

    public BookCatalogCreatedUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateBookCatalogCommand command) {
        BookCatalog bookCatalog = new BookCatalog(BookCatalogId.of(command.getBookCatalogId()), command.getName());
        return bookCatalog.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
