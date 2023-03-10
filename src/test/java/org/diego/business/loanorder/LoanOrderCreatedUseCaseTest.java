package org.diego.business.loanorder;

import org.diego.business.commons.EventsRepository;
import org.diego.domain.bookcatalog.events.BookCatalogCreated;
import org.diego.domain.loanorder.commands.CreateLoanOrderCommand;
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
class LoanOrderCreatedUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private LoanOrderCreatedUseCase loanOrderCreatedUseCase;

    @BeforeEach
    void setup(){
        loanOrderCreatedUseCase = new LoanOrderCreatedUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        CreateLoanOrderCommand createLoanOrderCommand = new CreateLoanOrderCommand("loanOrderId","branchId",
                "San Diego","apple","st pow",8,"5632896","Morelos",
                "userId","bookId","bookCatalogId");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(LoanOrderCreated.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = loanOrderCreatedUseCase.apply(createLoanOrderCommand);

        Assertions.assertEquals("org.diego.createleanorder",domainEventList.get(0).type);
    }

}