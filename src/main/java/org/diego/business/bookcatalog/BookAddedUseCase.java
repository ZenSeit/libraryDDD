package org.diego.business.bookcatalog;

import org.diego.business.commons.EventsRepository;
import org.diego.business.commons.UserCaseForCommand;
import org.diego.domain.bookcatalog.BookCatalog;
import org.diego.domain.bookcatalog.commands.AddBookCommand;
import org.diego.domain.commonvalues.BookCatalogId;
import org.diego.generic.DomainEvent;

import java.util.List;

public class BookAddedUseCase implements UserCaseForCommand<AddBookCommand> {

    private final EventsRepository eventsRepository;

    public BookAddedUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AddBookCommand command) {
        List<DomainEvent> bookCatalogEvents =  eventsRepository.findByAggregatedRootId(command.getBookCatalogId());
        BookCatalog bookCatalog = BookCatalog.from(BookCatalogId.of(command.getBookId()),bookCatalogEvents);
        bookCatalog.AddBook(command.getBookId(), command.getBookName(), command.getAuthorId(), command.getAuthorName(),
                command.getAuthorLastName(), command.getCountry(), command.getAuthorDebutYear(), command.getReleaseYear(),
                command.getGenre());
        return bookCatalog.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
