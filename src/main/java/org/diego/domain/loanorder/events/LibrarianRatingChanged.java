package org.diego.domain.loanorder.events;

import org.diego.generic.DomainEvent;

public class LibrarianRatingChanged extends DomainEvent {

    private final double rating;


    public LibrarianRatingChanged(double rating) {
        super("org.diego.librarianvalidationchanged");
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }
}
