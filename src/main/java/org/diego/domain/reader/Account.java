package org.diego.domain.reader;

import org.diego.domain.commonvalues.AccountId;
import org.diego.domain.commonvalues.Address;
import org.diego.domain.commonvalues.FullName;
import org.diego.domain.reader.values.Dni;
import org.diego.domain.reader.values.Email;
import org.diego.generic.Entity;

public class Account extends Entity<AccountId> {

    private FullName fullName;
    private Address address;
    private Email email;
    private Dni dni;

    public Account(AccountId id, FullName fullName, Address address, Email email, Dni dni) {
        super(id);
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.dni = dni;
    }

    public FullName FullName() {
        return fullName;
    }

    public Address Address() {
        return address;
    }

    public Email Email() {
        return email;
    }

    public Dni Dni() {
        return dni;
    }

    //put methods here
}
