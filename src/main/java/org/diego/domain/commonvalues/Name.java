package org.diego.domain.commonvalues;

import org.diego.generic.ValueObject;

public class Name implements ValueObject<String> {

    private String name;

    public Name(String name) {
        if (name.length()<2) throw new IllegalArgumentException("Type a valid name");
        this.name = name;
    }

    @Override
    public String value() {
        return null;
    }
}
