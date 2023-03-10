package org.diego.business.eventUseCases;

import org.diego.business.commons.EventsRepository;
import org.diego.business.loanorder.mocks.LoanOrderMocks;
import org.diego.business.reader.mocks.ReaderMocks;
import org.diego.domain.loanorder.events.LoanOrderCreated;
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
class UpdateReaderAccountStateUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private UpdateReaderAccountStateUseCase updateReaderAccountStateUseCase;

    @BeforeEach
    void setup(){
        updateReaderAccountStateUseCase = new UpdateReaderAccountStateUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        LoanOrderCreated triggerEvent = LoanOrderMocks.loanOrder();

        Mockito.when(eventsRepository.findByAggregatedRootId(triggerEvent.getReaderId())).thenAnswer(invocationOnMock -> {
            return List.of(ReaderMocks.readerRegisteredMock());});

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(BorrowedBookAdded.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = updateReaderAccountStateUseCase.apply(triggerEvent);

        Assertions.assertEquals("org.diego.borrowedbookadded",domainEventList.get(0).type);

    }

}