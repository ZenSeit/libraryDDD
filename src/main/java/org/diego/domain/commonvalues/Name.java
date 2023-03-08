package org.diego.domain.commonvalues;

import org.diego.generic.ValueObject;

public class Name implements ValueObject<String> {

    private String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public String value() {
        return null;
    }
}
