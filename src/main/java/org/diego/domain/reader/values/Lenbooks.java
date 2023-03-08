package org.diego.domain.reader.values;

import org.diego.generic.ValueObject;

public class Lenbooks implements ValueObject<Integer> {

    private int lenbooks;

    public Lenbooks(int lenbooks) {
        this.lenbooks = lenbooks;
    }

    @Override
    public Integer value() {
        return lenbooks;
    }
}
