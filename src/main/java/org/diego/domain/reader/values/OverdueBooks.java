package org.diego.domain.reader.values;

import org.diego.generic.ValueObject;

public class OverdueBooks implements ValueObject<Integer> {

    private int overdueBooks;

    public OverdueBooks(int overdueBooks) {
        this.overdueBooks = overdueBooks;
    }

    @Override
    public Integer value() {
        return overdueBooks;
    }
}
