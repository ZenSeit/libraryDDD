package org.diego.business.loanorder;

import org.diego.business.commons.EventsRepository;
import org.diego.business.commons.UserCaseForCommand;
import org.diego.domain.commonvalues.LoanOrderId;
import org.diego.domain.loanorder.LoanOrder;
import org.diego.domain.loanorder.commands.ChangeLibrarianRatingCommand;
import org.diego.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibrarianRatingChangedUseCase implements UserCaseForCommand<ChangeLibrarianRatingCommand> {

    private final EventsRepository eventsRepository;

    public LibrarianRatingChangedUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ChangeLibrarianRatingCommand command) {
        List<DomainEvent> loanOrderEvents =  eventsRepository.findByAggregatedRootId(command.getLoanOrderId());
        LoanOrder loanOrder = LoanOrder.from(LoanOrderId.of(command.getLoanOrderId()),loanOrderEvents);
        loanOrder.modifyLibrarianValoration(command.getValidation());
        return loanOrder.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
