package org.diego.business.bookcatalog;

import org.diego.business.bookcatalog.mocks.BookCatalogMocks;
import org.diego.business.commons.EventsRepository;
import org.diego.domain.bookcatalog.commands.ChangeStateBookCommand;
import org.diego.domain.bookcatalog.events.BookStateChanged;
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
class BookStateChangeUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private BookStateChangeUseCase bookStateChangeUseCase;

    @BeforeEach
    void setup(){
        bookStateChangeUseCase = new BookStateChangeUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        ChangeStateBookCommand changeStateBookCommand = new ChangeStateBookCommand("bookCatalogId","bookId");

        Mockito.when(eventsRepository.findByAggregatedRootId(changeStateBookCommand.getBookCatalogId())).thenAnswer(invocationOnMock -> {
            return List.of(BookCatalogMocks.bookCatalog(),BookCatalogMocks.addBookToCatalog());});

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(BookStateChanged.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = bookStateChangeUseCase.apply(changeStateBookCommand);

        Assertions.assertEquals("org.diego.bookstatechanged",domainEventList.get(0).type);

    }

}