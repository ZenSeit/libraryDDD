package org.diego.business.reader.mocks;

import org.diego.domain.reader.events.ReaderRegistered;
import org.diego.generic.DomainEvent;

public class ReaderMocks {

    public static DomainEvent readerRegisteredMock (){
        return new ReaderRegistered("accountId",
                "Diego","Becerra","diego@correo.com",
                "peter st","johns",5,"5632889");
    }
}
