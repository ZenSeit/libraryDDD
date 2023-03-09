package org.diego.business.commons;

import org.diego.generic.DomainEvent;

import java.util.List;

public interface EventsRepository {

    DomainEvent saveEvent(DomainEvent event);

    List<DomainEvent> findByAggregatedRootId(String aggregatedRootId);

}
