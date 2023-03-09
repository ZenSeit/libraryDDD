package org.diego.business.reader;

import org.diego.business.commons.EventsRepository;
import org.diego.business.reader.mocks.ReaderMocks;
import org.diego.domain.reader.commands.ChangeValorationCommand;
import org.diego.domain.reader.events.EmailEdited;
import org.diego.domain.reader.events.ValorationChanged;
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
class ValorationChangedUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private ValorationChangedUseCase valorationChangedUseCase;

    @BeforeEach
    void setup(){
        valorationChangedUseCase = new ValorationChangedUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        ChangeValorationCommand changeValorationCommand = new ChangeValorationCommand("readerId",3.0);

        Mockito.when(eventsRepository.findByAggregatedRootId(changeValorationCommand.getReaderId())).thenAnswer(invocationOnMock -> {
            return List.of(ReaderMocks.readerRegisteredMock());});

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(ValorationChanged.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = valorationChangedUseCase.apply(changeValorationCommand);

        Assertions.assertEquals("org.diego.changevaloration",domainEventList.get(0).type);
    }

}