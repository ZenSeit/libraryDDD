package org.diego.domain.bookcatalog.values;

import org.diego.generic.ValueObject;

public class isBorrow implements ValueObject<Boolean> {

    private boolean value;

    public isBorrow(boolean value) {
        this.value = value;
    }

    @Override
    public Boolean value() {
        return value;
    }
}
