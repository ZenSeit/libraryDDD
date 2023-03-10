package org.diego.business.reader;

import org.diego.business.commons.EventsRepository;
import org.diego.business.reader.mocks.ReaderMocks;
import org.diego.domain.reader.commands.ModifyAddressCommand;
import org.diego.domain.reader.events.AddressModified;
import org.diego.domain.reader.events.EmailEdited;
import org.diego.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddressModifiedUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private AddressModifiedUseCase addressModifiedUseCase;

    @BeforeEach
    void setup(){
        addressModifiedUseCase = new AddressModifiedUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        ModifyAddressCommand modifyAddressCommand = new ModifyAddressCommand("readerId","new street",
                "new avenue",6);

        Mockito.when(eventsRepository.findByAggregatedRootId(modifyAddressCommand.getReaderId())).thenAnswer(invocationOnMock -> {
            return List.of(ReaderMocks.readerRegisteredMock());});

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(AddressModified.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = addressModifiedUseCase.apply(modifyAddressCommand);

        Assertions.assertEquals("org.diego.addressmodified",domainEventList.get(0).type);

    }

}