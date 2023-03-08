package org.diego.domain.reader.values;

import org.diego.generic.ValueObject;

public class Dni implements ValueObject<String> {

    private String dni;

    public Dni(String dni) {
        this.dni = dni;
    }

    @Override
    public String value() {
        return dni;
    }
}
