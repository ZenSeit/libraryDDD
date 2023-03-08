package org.diego.domain.bookcatalog.values;

import org.diego.generic.ValueObject;

import java.util.Date;

public class ReleaseYear implements ValueObject<Date> {


    private Date value;

    public ReleaseYear(String value) {
        this.value = new Date(value);
    }

    @Override
    public Date value() {
        return value;
    }
}
