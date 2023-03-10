package org.diego.business.reader;

import org.diego.business.commons.EventsRepository;
import org.diego.business.commons.UserCaseForCommand;
import org.diego.domain.commonvalues.ReaderId;
import org.diego.domain.reader.Reader;
import org.diego.domain.reader.commands.AddLenBookCommand;
import org.diego.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BorrowedBooksAddedUseCase implements UserCaseForCommand<AddLenBookCommand> {

    private final EventsRepository eventsRepository;

    public BorrowedBooksAddedUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AddLenBookCommand command) {
        List<DomainEvent> readerEvents =  eventsRepository.findByAggregatedRootId(command.getReaderId());
        Reader reader = Reader.from(ReaderId.of(command.getReaderId()),readerEvents);
        reader.addBorrowBook();
        return reader.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
