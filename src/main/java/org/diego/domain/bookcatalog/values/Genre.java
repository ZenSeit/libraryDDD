package org.diego.domain.bookcatalog.values;

import org.diego.generic.ValueObject;

public class Genre implements ValueObject<String> {

    private String value;

    public Genre(String genre) {
        this.value = genre;
    }

    @Override
    public String value() {
        return value;
    }
}
