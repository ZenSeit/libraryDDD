package org.diego.business.loanorder;

import org.diego.business.commons.EventsRepository;
import org.diego.business.commons.UserCaseForCommand;
import org.diego.domain.bookcatalog.BookCatalog;
import org.diego.domain.commonvalues.BookCatalogId;
import org.diego.domain.commonvalues.LoanOrderId;
import org.diego.domain.loanorder.LoanOrder;
import org.diego.domain.loanorder.commands.AssignLibrarianCommand;
import org.diego.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibrarianAssignedUseCase implements UserCaseForCommand<AssignLibrarianCommand> {

    private final EventsRepository eventsRepository;

    public LibrarianAssignedUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AssignLibrarianCommand command) {
        List<DomainEvent> loanOrderEvents =  eventsRepository.findByAggregatedRootId(command.getLoanOrderId());
        LoanOrder loanOrder = LoanOrder.from(LoanOrderId.of(command.getLoanOrderId()),loanOrderEvents);
        loanOrder.AssignLibrarian(command.getLibrarianId(), command.getName(), command.getLastName(), command.getFromHour(), command.getToHour());
        return loanOrder.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
