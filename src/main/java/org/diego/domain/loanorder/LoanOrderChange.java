package org.diego.domain.loanorder;

import org.diego.domain.commonvalues.*;
import org.diego.domain.loanorder.events.LibrarianAssigned;
import org.diego.domain.loanorder.events.LibrarianRatingChanged;
import org.diego.domain.loanorder.events.LoanOrderCreated;
import org.diego.domain.loanorder.values.City;
import org.diego.domain.loanorder.values.Phone;
import org.diego.domain.loanorder.values.WorkSchedule;
import org.diego.generic.EventChange;

public class LoanOrderChange extends EventChange {
    public LoanOrderChange(LoanOrder loanOrder) {
        apply((LoanOrderCreated event)->{
            loanOrder.branch = new Branch(
                    BranchId.of(event.getBranchId()),
                    new Name(event.getNameBranch()),
                    new Address(event.getStreetBranch(), event.getAvenueBranch(), event.getHouseNumberBranch()),
                    new Phone(event.getPhone()),
                    new City(event.getCity())
            );
            loanOrder.bookId = BookId.of(event.getBookId());
            loanOrder.readerId = ReaderId.of(event.getReaderId());
        });

        apply((LibrarianAssigned event)->{
            loanOrder.librarian = new Librarian(
                    LibrarianId.of(event.getLibrarianId()),
                    new FullName(event.getName(), event.getLastName()),
                    new WorkSchedule(event.getFromHour(), event.getToHour())
            );
        });

        apply((LibrarianRatingChanged event)->{
            loanOrder.librarian.changeRating((loanOrder.librarian.Rating().value()+ event.getRating())/2);
        });

    }
}
