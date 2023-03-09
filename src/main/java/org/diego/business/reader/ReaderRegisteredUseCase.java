package org.diego.business.reader;

import org.diego.business.commons.EventsRepository;
import org.diego.business.commons.UserCaseForCommand;
import org.diego.domain.commonvalues.ReaderId;
import org.diego.domain.reader.Reader;
import org.diego.domain.reader.commands.RegisterReaderCommand;
import org.diego.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReaderRegisteredUseCase implements UserCaseForCommand<RegisterReaderCommand> {

    private final EventsRepository eventsRepository;

    public ReaderRegisteredUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(RegisterReaderCommand command) {
        Reader reader = new Reader(ReaderId.of(command.getReaderId()), command.getAccountId(), command.getName(), command.getLastName(), command.getEmail(),
                command.getDni(), command.getStreet(), command.getAvenue(), command.getHouseNumber());

        return reader.getUncommittedChanges().stream()
                .map(eventsRepository::saveEvent).toList();
    }
}
