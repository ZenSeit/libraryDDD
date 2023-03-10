package org.diego.business.eventUseCases;

import org.diego.business.commons.EventsRepository;
import org.diego.business.commons.UseCaseForEvent;
import org.diego.domain.commonvalues.ReaderId;
import org.diego.domain.loanorder.events.LoanOrderCreated;
import org.diego.domain.reader.Reader;
import org.diego.generic.DomainEvent;

import java.util.List;

public class UpdateReaderAccountStateUseCase implements UseCaseForEvent<LoanOrderCreated> {

    private final EventsRepository eventsRepository;

    public UpdateReaderAccountStateUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(LoanOrderCreated event) {
        List<DomainEvent> readerEvents =  eventsRepository.findByAggregatedRootId(event.getReaderId());
        Reader reader = Reader.from(ReaderId.of(event.getReaderId()),readerEvents);
        reader.addBorrowBook();//this
        return reader.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
