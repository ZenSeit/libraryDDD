package org.diego.domain.bookcatalog.values;

import org.diego.generic.ValueObject;

public class Country implements ValueObject<String> {

    private String value;

    public Country(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
