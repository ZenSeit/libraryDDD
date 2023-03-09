package org.diego.business.bookcatalog;

import org.diego.business.bookcatalog.mocks.BookCatalogMocks;
import org.diego.business.commons.EventsRepository;
import org.diego.business.reader.mocks.ReaderMocks;
import org.diego.domain.bookcatalog.commands.RemoveBookCommand;
import org.diego.domain.bookcatalog.events.BookRemoved;
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
class BookRemoveUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private BookRemoveUseCase bookRemoveUseCase;

    @BeforeEach
    void setup(){
        bookRemoveUseCase = new BookRemoveUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){
        RemoveBookCommand removeBookCommand = new RemoveBookCommand("bookCatalogId","bookId");

        Mockito.when(eventsRepository.findByAggregatedRootId(removeBookCommand.getBookCatalogId())).thenAnswer(invocationOnMock -> {
            return List.of(BookCatalogMocks.bookCatalog(),BookCatalogMocks.addBookToCatalog());});

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(BookRemoved.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = bookRemoveUseCase.apply(removeBookCommand);

        Assertions.assertEquals("org.diego.bookdeleted",domainEventList.get(0).type);
    }


    }