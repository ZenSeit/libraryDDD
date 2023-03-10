package org.diego.business.loanorder.mocks;

import org.diego.domain.loanorder.events.LibrarianAssigned;
import org.diego.domain.loanorder.events.LoanOrderCreated;
import org.diego.generic.DomainEvent;

public class LoanOrderMocks {

    public static LoanOrderCreated loanOrder (){
        return new LoanOrderCreated("branchId",
                "San Diego","apple","st pow",8,"5632896","Morelos",
                "userId","bookId");
    }

    public static DomainEvent assignLibrarian(){
        return new LibrarianAssigned("librarianId","Charlie","Brown","8:30","17:00");
    }
}
