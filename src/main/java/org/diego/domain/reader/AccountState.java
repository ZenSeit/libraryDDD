package org.diego.domain.reader;

import org.diego.domain.commonvalues.AccountStateId;
import org.diego.domain.reader.values.Lenbooks;
import org.diego.domain.reader.values.OverdueBooks;
import org.diego.generic.Entity;

public class AccountState extends Entity<AccountStateId> {

    private Lenbooks lenbooks;
    private OverdueBooks overdueBooks;

    public AccountState(AccountStateId id) {
        super(id);
        this.lenbooks = new Lenbooks(0);
        this.overdueBooks = new OverdueBooks(0);
    }

    public Lenbooks Lenbooks() {
        return lenbooks;
    }

    public OverdueBooks OverdueBooks() {
        return overdueBooks;
    }
}
