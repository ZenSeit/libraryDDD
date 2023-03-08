package org.diego.domain.reader;

import org.diego.domain.commonvalues.ReaderId;
import org.diego.domain.commonvalues.Valoration;
import org.diego.domain.reader.events.ChangeValoration;
import org.diego.domain.reader.events.EditEmail;
import org.diego.domain.reader.events.ReaderRegistered;
import org.diego.generic.AggregateRoot;
import org.diego.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Reader extends AggregateRoot<ReaderId> {

    protected Account account;
    protected AccountState accountState;
    protected Valoration valoration;

    //(ReaderId id, Name name,String lastName,String email,String dni,String street,String avenue,int houseNumber)
    public Reader(ReaderId id,String accountId, String name,String lastName,String email,String dni,String street,String avenue,int houseNumber) {
        super(id);
        subscribe(new ReaderChange(this));
        appendChange(new ReaderRegistered(accountId,name,lastName,email,avenue,street,houseNumber,dni)).apply();
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

    public void editEmail(String email){
        Objects.requireNonNull(email);
        appendChange(new EditEmail(email)).apply();
    }

    public void changeValoration(double valoration){
        appendChange(new ChangeValoration(valoration)).apply();
    }

}
