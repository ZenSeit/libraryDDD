package org.diego.business.reader;

import org.diego.business.commons.EventsRepository;
import org.diego.business.commons.UserCaseForCommand;
import org.diego.domain.commonvalues.ReaderId;
import org.diego.domain.reader.Reader;
import org.diego.domain.reader.commands.ChangeValorationCommand;
import org.diego.generic.DomainEvent;

import java.util.List;

public class ValorationChangedUseCase implements UserCaseForCommand<ChangeValorationCommand> {

    private final EventsRepository eventsRepository;

    public ValorationChangedUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ChangeValorationCommand command) {
        List<DomainEvent> readerEvents =  eventsRepository.findByAggregatedRootId(command.getReaderId());
        Reader reader = Reader.from(ReaderId.of(command.getReaderId()),readerEvents);
        reader.changeValoration(command.getValoration());
        return reader.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
