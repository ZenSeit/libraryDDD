package org.diego.domain.reader.events;

import org.diego.generic.DomainEvent;

public class ValorationChanged extends DomainEvent {

    private final double valoration;

    public ValorationChanged(double valoration) {
        super("org.diego.changevaloration");
        this.valoration = valoration;
    }

    public double getValoration() {
        return valoration;
    }
}
