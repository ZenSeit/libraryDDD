package org.diego.business.bookcatalog;

import org.diego.business.commons.EventsRepository;
import org.diego.business.commons.UserCaseForCommand;
import org.diego.domain.bookcatalog.BookCatalog;
import org.diego.domain.bookcatalog.commands.RemoveBookCommand;
import org.diego.domain.commonvalues.BookCatalogId;
import org.diego.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookRemoveUseCase implements UserCaseForCommand<RemoveBookCommand> {

    private final EventsRepository eventsRepository;

    public BookRemoveUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(RemoveBookCommand command) {
        List<DomainEvent> bookCatalogEvents =  eventsRepository.findByAggregatedRootId(command.getBookCatalogId());
        BookCatalog bookCatalog = BookCatalog.from(BookCatalogId.of(command.getBookId()),bookCatalogEvents);
        bookCatalog.removeBook(command.getBookId());
        return bookCatalog.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
