package org.diego.business.reader;

import org.diego.business.commons.EventsRepository;
import org.diego.business.reader.mocks.ReaderMocks;
import org.diego.domain.reader.commands.AddLenBookCommand;
import org.diego.domain.reader.events.BorrowedBookAdded;
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

@ExtendWith(MockitoExtension.class)
class BorrowedBooksAddedUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private BorrowedBooksAddedUseCase lenBookAddedUseCase;

    @BeforeEach
    void setup(){
        lenBookAddedUseCase = new BorrowedBooksAddedUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        AddLenBookCommand addLenBookCommand = new AddLenBookCommand("readerId");

        Mockito.when(eventsRepository.findByAggregatedRootId(addLenBookCommand.getReaderId())).thenAnswer(invocationOnMock -> {
            return List.of(ReaderMocks.readerRegisteredMock());});

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(BorrowedBookAdded.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = lenBookAddedUseCase.apply(addLenBookCommand);

        Assertions.assertEquals("org.diego.borrowedbookadded",domainEventList.get(0).type);
    }

}