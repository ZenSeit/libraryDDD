package org.diego.business.eventUseCases;

import org.diego.business.bookcatalog.mocks.BookCatalogMocks;
import org.diego.business.commons.EventsRepository;
import org.diego.business.loanorder.mocks.LoanOrderMocks;
import org.diego.domain.bookcatalog.events.BookStateChanged;
import org.diego.domain.loanorder.events.LoanOrderCreated;
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
class BookStateChangedUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private BookStateChangedUseCase bookStateChangedUseCase;

    @BeforeEach
    void setup(){
        bookStateChangedUseCase = new BookStateChangedUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        LoanOrderCreated triggerEvent = LoanOrderMocks.loanOrder();

        Mockito.when(eventsRepository.findByAggregatedRootId(triggerEvent.getBookCatalogId())).thenAnswer(invocationOnMock -> {
            return List.of(BookCatalogMocks.bookCatalog(),BookCatalogMocks.addBookToCatalog());});

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(BookStateChanged.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = bookStateChangedUseCase.apply(triggerEvent);

        Assertions.assertEquals("org.diego.bookstatechanged",domainEventList.get(0).type);
    }

}