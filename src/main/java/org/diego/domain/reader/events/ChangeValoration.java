package org.diego.domain.reader.events;

import org.diego.generic.DomainEvent;

public class ChangeValoration extends DomainEvent {

    private final double valoration;

    public ChangeValoration(double valoration) {
        super("org.diego.changevaloration");
        this.valoration = valoration;
    }

    public double getValoration() {
        return valoration;
    }
}
