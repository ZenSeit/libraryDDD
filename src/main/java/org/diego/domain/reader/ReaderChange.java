package org.diego.domain.reader;

import org.diego.domain.commonvalues.*;
import org.diego.domain.reader.events.*;
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
            reader.rating = new Rating(5.0);
        });

        apply((EmailEdited event) ->{
            reader.account.editEmail(event.getEmail());
        });

        apply((ValorationChanged event) ->{
            reader.rating = new Rating((reader.rating.value()+event.getValoration())/2);
        });

        apply((BorrowedBookAdded event) ->{
            reader.accountState.addLoanedBook();
        });

        apply((AddressModified event) ->{
            reader.account.modifyAddress(event.getStreet(), event.getAvenue(), event.getHouseNumber());
        });

    }
}
