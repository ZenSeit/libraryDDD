package org.diego.domain.loanorder.values;

import org.diego.generic.ValueObject;

public class Phone implements ValueObject<String> {

    private String value;

    public Phone(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
