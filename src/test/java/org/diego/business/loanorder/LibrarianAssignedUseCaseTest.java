package org.diego.business.loanorder;

import org.diego.business.bookcatalog.mocks.BookCatalogMocks;
import org.diego.business.commons.EventsRepository;
import org.diego.business.loanorder.mocks.LoanOrderMocks;
import org.diego.domain.bookcatalog.events.BookRemoved;
import org.diego.domain.loanorder.commands.AssignLibrarianCommand;
import org.diego.domain.loanorder.events.LibrarianAssigned;
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
class LibrarianAssignedUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private LibrarianAssignedUseCase librarianAssignedUseCase;

    @BeforeEach
    void setup(){
        librarianAssignedUseCase = new LibrarianAssignedUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        AssignLibrarianCommand assignLibrarianCommand = new AssignLibrarianCommand("loanOrderId",
                "librarianId","Charlie","Brown","8:30","17:00");

        Mockito.when(eventsRepository.findByAggregatedRootId(assignLibrarianCommand.getLoanOrderId())).thenAnswer(invocationOnMock -> {
            return List.of(LoanOrderMocks.loanOrder());});

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(LibrarianAssigned.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = librarianAssignedUseCase.apply(assignLibrarianCommand);

        Assertions.assertEquals("org.diego.assignlibrarian",domainEventList.get(0).type);

    }

}