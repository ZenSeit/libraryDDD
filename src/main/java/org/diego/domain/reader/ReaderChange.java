package org.diego.domain.reader;

import org.diego.domain.commonvalues.*;
import org.diego.domain.reader.events.LenBookAdded;
import org.diego.domain.reader.events.ValorationChanged;
import org.diego.domain.reader.events.EmailEdited;
import org.diego.domain.reader.events.ReaderRegistered;
import org.diego.domain.reader.values.Dni;
import org.diego.domain.reader.values.Email;
import org.diego.generic.EventChange;

public class ReaderChange extends EventChange {

    public ReaderChange(Reader reader) {
        apply((ReaderRegistered event) -> {
            reader.account = new Account(
                    AccountId.of(event.getAccountId()),
                    new FullName(event.getName(),event.getLastName()),
                    new Address(event.getStreet(), event.getAvenue(), event.getHouseNumber()),
                    new Email(event.getEmail()),
                    new Dni(event.getDni())

            );
            reader.accountState = new AccountState(AccountStateId.of("accountStateId"));
            reader.valoration = new Valoration(5.0);
        });

        apply((EmailEdited event) ->{
            reader.account.editEmail(event.getEmail());
        });

        apply((ValorationChanged event) ->{
            reader.valoration = new Valoration((reader.valoration.value()+event.getValoration())/2);
        });

        apply((LenBookAdded event) ->{
            reader.accountState.addLenBook();
        });

    }
}
