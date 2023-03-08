package org.diego.domain.loanorder.values;

import org.diego.generic.ValueObject;

public class City implements ValueObject<String> {

    private String value;

    public City(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
