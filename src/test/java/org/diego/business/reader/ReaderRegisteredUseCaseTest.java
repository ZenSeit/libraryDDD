package org.diego.business.reader;

import org.diego.business.commons.EventsRepository;
import org.diego.domain.reader.commands.RegisterReaderCommand;
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
class ReaderRegisteredUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private ReaderRegisteredUseCase readerRegisteredUseCase;

    @BeforeEach
    void setup(){
        readerRegisteredUseCase = new ReaderRegisteredUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        RegisterReaderCommand registerReaderCommand = new RegisterReaderCommand("readerId","accountId",
                "Diego","Becerra","diego@correo.com","peter st","johns",5,"563288963");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(ReaderRegistered.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = readerRegisteredUseCase.apply(registerReaderCommand);

        Assertions.assertEquals(1,domainEventList.size());
        Assertions.assertEquals("org.diego.readercreated",domainEventList.get(0).type);
    }

}