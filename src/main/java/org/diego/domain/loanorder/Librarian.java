package org.diego.domain.loanorder;

import org.diego.domain.commonvalues.FullName;
import org.diego.domain.commonvalues.LibrarianId;
import org.diego.domain.commonvalues.Rating;
import org.diego.domain.loanorder.values.WorkSchedule;
import org.diego.generic.Entity;

public class Librarian extends Entity<LibrarianId> {

    private FullName fullName;
    private Rating rating;
    private WorkSchedule workSchedule;

    public Librarian(LibrarianId id, FullName fullName, WorkSchedule workSchedule) {
        super(id);
        this.fullName = fullName;
        this.rating = new Rating(5.0);
        this.workSchedule = workSchedule;
    }

    public FullName FullName() {
        return fullName;
    }

    public Rating Rating() {
        return rating;
    }

    public WorkSchedule WorkSchedule() {
        return workSchedule;
    }

    public void changeRating(double value){
        this.rating = new Rating(value);
    }
}
