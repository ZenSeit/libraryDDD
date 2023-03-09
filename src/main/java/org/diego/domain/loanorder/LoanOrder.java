package org.diego.domain.loanorder;

import org.diego.domain.commonvalues.BookId;
import org.diego.domain.commonvalues.LoanOrderId;
import org.diego.domain.commonvalues.ReaderId;
import org.diego.domain.loanorder.events.LibrarianAssigned;
import org.diego.domain.loanorder.events.LoanOrderCreated;
import org.diego.generic.AggregateRoot;
import org.diego.generic.DomainEvent;

import java.util.List;

public class LoanOrder extends AggregateRoot<LoanOrderId> {

    protected Librarian librarian;
    protected Branch branch;
    protected ReaderId readerId;
    protected BookId bookId;

    public LoanOrder(LoanOrderId id,String branchId,String nameBranch,String streetBranch,String avenueBranch,int houseNumberBranch,String phone,
                     String city,String readerId,String bookId){
        super(id);
        subscribe(new LoanOrderChange(this));
        appendChange(new LoanOrderCreated(branchId,nameBranch,streetBranch,avenueBranch,houseNumberBranch,phone,city,readerId,bookId)).apply();
    }

    private LoanOrder(LoanOrderId id){
        super(id);
        subscribe(new LoanOrderChange(this));
    }

    public static LoanOrder from(LoanOrderId id, List<DomainEvent> events){
        LoanOrder loanOrder = new LoanOrder(id);
        events.forEach(event -> loanOrder.applyEvent(event));
        return loanOrder;
    }

    public void AssignLibrarian(String id,String name,String lastName,String fromHour,String toHour){
        appendChange(new LibrarianAssigned(id,name,lastName,fromHour,toHour)).apply();
    }
}
