package org.diego.domain.bookcatalog;

import org.diego.domain.bookcatalog.values.Country;
import org.diego.domain.bookcatalog.values.DebutYear;
import org.diego.domain.commonvalues.AuthorId;
import org.diego.domain.commonvalues.FullName;
import org.diego.generic.Entity;

public class Author extends Entity<AuthorId> {

    private FullName fullName;
    private Country country;
    private DebutYear debutYear;

    public Author(AuthorId id, FullName fullName, Country country, DebutYear debutYear) {
        super(id);
        this.fullName = fullName;
        this.country = country;
        this.debutYear = debutYear;
    }

    public FullName FullName() {
        return fullName;
    }

    public Country Country() {
        return country;
    }

    public DebutYear DebutYear() {
        return debutYear;
    }
}
