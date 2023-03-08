package org.diego.domain.reader.values;

import org.diego.generic.ValueObject;

public class Email implements ValueObject<String> {

    private String email;

    public Email(String email) {
        this.email = email;
    }

    @Override
    public String value() {
        return email;
    }
}
