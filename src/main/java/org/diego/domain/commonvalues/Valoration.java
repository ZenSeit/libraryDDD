package org.diego.domain.commonvalues;

import org.diego.generic.ValueObject;

public class Valoration implements ValueObject<Double> {

    private double valoration;

    public Valoration(double valoration) {
        this.valoration = valoration;
    }

    @Override
    public Double value() {
        return valoration;
    }
}
