package org.diego.domain.commonvalues;

import org.diego.generic.ValueObject;

import java.time.LocalDate;

public class CreatedAt implements ValueObject<LocalDate> {

    private LocalDate value;

    public CreatedAt() {
        this.value = LocalDate.now();
    }

    @Override
    public LocalDate value() {
        return value;
    }
}
