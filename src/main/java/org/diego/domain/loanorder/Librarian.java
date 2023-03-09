package org.diego.domain.loanorder;

import org.diego.domain.commonvalues.FullName;
import org.diego.domain.commonvalues.LibrarianId;
import org.diego.domain.commonvalues.Valoration;
import org.diego.domain.loanorder.values.WorkSchedule;
import org.diego.generic.Entity;

public class Librarian extends Entity<LibrarianId> {

    private FullName fullName;
    private Valoration valoration;
    private WorkSchedule workSchedule;

    public Librarian(LibrarianId id, FullName fullName, WorkSchedule workSchedule) {
        super(id);
        this.fullName = fullName;
        this.valoration = new Valoration(5.0);
        this.workSchedule = workSchedule;
    }

    public FullName FullName() {
        return fullName;
    }

    public Valoration Valoration() {
        return valoration;
    }

    public WorkSchedule WorkSchedule() {
        return workSchedule;
    }
}
