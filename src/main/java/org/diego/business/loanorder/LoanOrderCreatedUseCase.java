package org.diego.business.loanorder;

import org.diego.business.commons.EventsRepository;
import org.diego.business.commons.UserCaseForCommand;
import org.diego.domain.commonvalues.LoanOrderId;
import org.diego.domain.loanorder.LoanOrder;
import org.diego.domain.loanorder.commands.CreateLoanOrderCommand;
import org.diego.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoanOrderCreatedUseCase implements UserCaseForCommand<CreateLoanOrderCommand> {

    private final EventsRepository eventsRepository;

    public LoanOrderCreatedUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateLoanOrderCommand command) {
        LoanOrder loanOrder = new LoanOrder(LoanOrderId.of(command.getLoanOrderId()), command.getBranchId(), command.getNameBranch(), command.getStreetBranch(),
                command.getAvenueBranch(), command.getHouseNumberBranch(), command.getPhone(), command.getCity(), command.getReaderId(),
                command.getBookId(), command.getBookCatalogId());
        return loanOrder.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
