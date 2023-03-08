package org.diego.domain.reader;

import org.diego.domain.commonvalues.ReaderId;
import org.diego.domain.commonvalues.Valoration;
import org.diego.domain.reader.events.ReaderRegistered;
import org.diego.generic.AggregateRoot;
import org.diego.generic.DomainEvent;

import java.util.List;

public class Reader extends AggregateRoot<ReaderId> {

    protected Account account;
    protected AccountState accountState;
    protected Valoration valoration;

    public Reader(ReaderId id,Valoration valoration) {
        super(id);
        subscribe(new ReaderChange(this));
        appendChange(new ReaderRegistered());
    }

    private Reader(ReaderId id) {
        super(id);
        subscribe(new ReaderChange(this));
    }

    public static Reader from(ReaderId id, List<DomainEvent> events){
        Reader reader = new Reader(id);
        events.forEach(event -> reader.applyEvent(event));
        return reader;
    }
}
