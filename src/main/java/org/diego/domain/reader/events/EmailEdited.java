package org.diego.domain.reader.events;

import org.diego.generic.DomainEvent;

public class EmailEdited extends DomainEvent {

    private final String email;

    public EmailEdited(String email) {
        super("org.diego.editemail");
        this.email = email;
    }


    public String getEmail() {
        return email;
    }
}
