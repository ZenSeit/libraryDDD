package org.diego.business.loanorder.mocks;

import org.diego.domain.loanorder.events.LoanOrderCreated;
import org.diego.generic.DomainEvent;

public class LoanOrderMocks {

    public static DomainEvent loanOrder (){
        return new LoanOrderCreated("branchId",
                "San Diego","apple","st pow",8,"5632896","Morelos",
                "userId","bookId");
    }
}
