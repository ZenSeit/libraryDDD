package org.diego.business.reader;

import org.diego.business.commons.EventsRepository;
import org.diego.business.reader.mocks.ReaderMocks;
import org.diego.domain.reader.commands.EditEmailCommand;
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
class EmailEditedUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private EmailEditedUseCase emailEditedUseCase;

    @BeforeEach
    void setup(){
        emailEditedUseCase = new EmailEditedUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        EditEmailCommand editEmailCommand = new EditEmailCommand("readerId","cambio@correo.com");

        Mockito.when(eventsRepository.findByAggregatedRootId(editEmailCommand.getReaderId())).thenAnswer(invocationOnMock -> {
            return List.of(ReaderMocks.readerRegisteredMock());});

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(EmailEdited.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = emailEditedUseCase.apply(editEmailCommand);

        Assertions.assertEquals("org.diego.editemail",domainEventList.get(0).type);

    }

}