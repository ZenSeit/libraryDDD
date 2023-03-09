package org.diego.domain.loanorder;

import org.diego.domain.commonvalues.Address;
import org.diego.domain.commonvalues.BranchId;
import org.diego.domain.commonvalues.Name;
import org.diego.domain.loanorder.values.City;
import org.diego.domain.loanorder.values.Phone;
import org.diego.generic.Entity;

public class Branch extends Entity<BranchId> {

    private Name name;
    private Address address;
    private Phone phone;
    private City city;

    public Branch(BranchId id, Name name, Address address, Phone phone, City city) {
        super(id);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.city = city;
    }

    public Name Name() {
        return name;
    }

    public Address Address() {
        return address;
    }

    public Phone Phone() {
        return phone;
    }

    public City City() {
        return city;
    }
}
