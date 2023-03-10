package org.diego.business.loanorder;

import org.diego.business.commons.EventsRepository;
import org.diego.business.loanorder.mocks.LoanOrderMocks;
import org.diego.business.reader.mocks.ReaderMocks;
import org.diego.domain.loanorder.commands.ChangeLibrarianRatingCommand;
import org.diego.domain.loanorder.events.LibrarianRatingChanged;
import org.diego.domain.reader.events.AddressModified;
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
class LibrarianRatingChangedUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private LibrarianRatingChangedUseCase librarianRatingChangedUseCase;

    @BeforeEach
    void setup(){
        librarianRatingChangedUseCase = new LibrarianRatingChangedUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        ChangeLibrarianRatingCommand changeLibrarianRatingCommand = new ChangeLibrarianRatingCommand("loanOrderId",
                3.0);

        Mockito.when(eventsRepository.findByAggregatedRootId(changeLibrarianRatingCommand.getLoanOrderId())).thenAnswer(invocationOnMock -> {
            return List.of(LoanOrderMocks.loanOrder(),LoanOrderMocks.assignLibrarian());});

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(LibrarianRatingChanged.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = librarianRatingChangedUseCase.apply(changeLibrarianRatingCommand);

        Assertions.assertEquals("org.diego.librarianvalidationchanged",domainEventList.get(0).type);

    }

}