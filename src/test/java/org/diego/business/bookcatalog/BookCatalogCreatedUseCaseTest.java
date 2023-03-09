package org.diego.business.bookcatalog;

import org.diego.business.commons.EventsRepository;
import org.diego.domain.bookcatalog.commands.CreateBookCatalogCommand;
import org.diego.domain.bookcatalog.events.BookCatalogCreated;
import org.diego.domain.reader.events.ReaderRegistered;
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
class BookCatalogCreatedUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private BookCatalogCreatedUseCase bookCatalogCreatedUseCase;

    @BeforeEach
    void setup(){
        bookCatalogCreatedUseCase = new BookCatalogCreatedUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        CreateBookCatalogCommand createBookCatalogCommand = new CreateBookCatalogCommand("bookCatalogId","Main");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(BookCatalogCreated.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = bookCatalogCreatedUseCase.apply(createBookCatalogCommand);

        Assertions.assertEquals(1,domainEventList.size());
        Assertions.assertEquals("org.diego.bookcatalogcreated",domainEventList.get(0).type);

    }

}