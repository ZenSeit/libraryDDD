package org.diego.domain.commonvalues;

import org.diego.generic.ValueObject;

public class Rating implements ValueObject<Double> {

    private double rating;

    public Rating(double rating) {
        this.rating= rating;
    }

    @Override
    public Double value() {
        return rating;
    }
}
