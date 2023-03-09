package org.diego.business.bookcatalog;

import org.diego.business.bookcatalog.mocks.BookCatalogMocks;
import org.diego.business.commons.EventsRepository;
import org.diego.business.reader.mocks.ReaderMocks;
import org.diego.domain.bookcatalog.commands.AddBookCommand;
import org.diego.domain.bookcatalog.events.BookAdded;
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
class BookAddedUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private BookAddedUseCase bookAddedUseCase;

    @BeforeEach
    void setup(){
        bookAddedUseCase = new BookAddedUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        AddBookCommand addBookCommand = new AddBookCommand("bookCatalogId","bookId","bookTest",
                "authorId","yakuzuko","Torika","Peru","12/09/1989",
                "06/07/2001","genreTest");

        Mockito.when(eventsRepository.findByAggregatedRootId(addBookCommand.getBookCatalogId())).thenAnswer(invocationOnMock -> {
            return List.of(BookCatalogMocks.bookCatalog());});

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(BookAdded.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = bookAddedUseCase.apply(addBookCommand);

        Assertions.assertEquals("org.diego.bookaddedtocatalog",domainEventList.get(0).type);

    }

}