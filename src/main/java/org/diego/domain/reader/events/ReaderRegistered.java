package org.diego.domain.reader.events;

import org.diego.generic.DomainEvent;

public class ReaderRegistered extends DomainEvent {

    public ReaderRegistered() {
        super("org.diego.readercreated");
    }
}
