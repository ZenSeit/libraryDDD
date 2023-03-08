package org.diego.domain.bookcatalog.values;

import org.diego.generic.ValueObject;

import java.time.LocalDate;
import java.util.Date;

public class DebutYear implements ValueObject<Date> {

    private Date value;

    public DebutYear(String value) {
        this.value = new Date(value);
    }

    @Override
    public Date value() {
        return value;
    }
}
