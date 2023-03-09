package org.diego.business.reader;

import org.diego.business.commons.EventsRepository;
import org.diego.business.reader.mocks.ReaderMocks;
import org.diego.domain.reader.commands.AddLenBookCommand;
import org.diego.domain.reader.events.EmailEdited;
import org.diego.domain.reader.events.LenBookAdded;
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
class LenBookAddedUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private LenBookAddedUseCase lenBookAddedUseCase;

    @BeforeEach
    void setup(){
        lenBookAddedUseCase = new LenBookAddedUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        AddLenBookCommand addLenBookCommand = new AddLenBookCommand("readerId");

        Mockito.when(eventsRepository.findByAggregatedRootId(addLenBookCommand.getReaderId())).thenAnswer(invocationOnMock -> {
            return List.of(ReaderMocks.readerRegisteredMock());});

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(LenBookAdded.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = lenBookAddedUseCase.apply(addLenBookCommand);

        Assertions.assertEquals("org.diego.editemail",domainEventList.get(0).type);
    }

}