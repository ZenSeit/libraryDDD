package org.diego.business.reader;

import org.diego.business.commons.EventsRepository;
import org.diego.business.commons.UserCaseForCommand;
import org.diego.domain.commonvalues.ReaderId;
import org.diego.domain.reader.Reader;
import org.diego.domain.reader.commands.ModifyAddressCommand;
import org.diego.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressModifiedUseCase implements UserCaseForCommand<ModifyAddressCommand> {

    private final EventsRepository eventsRepository;

    public AddressModifiedUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ModifyAddressCommand command) {
        List<DomainEvent> readerEvents =  eventsRepository.findByAggregatedRootId(command.getReaderId());
        Reader reader = Reader.from(ReaderId.of(command.getReaderId()),readerEvents);
        reader.updatedAddress(command.getStreet(), command.getAvenue(), command.getHouseNumber());
        return reader.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
