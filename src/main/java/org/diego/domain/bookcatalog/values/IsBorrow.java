package org.diego.domain.bookcatalog.values;

import org.diego.generic.ValueObject;

public class IsBorrow implements ValueObject<Boolean> {

    private boolean value;

    public IsBorrow(boolean value) {
        this.value = value;
    }

    @Override
    public Boolean value() {
        return value;
    }
}
