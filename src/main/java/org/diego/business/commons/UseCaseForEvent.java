package org.diego.business.commons;

import org.diego.generic.DomainEvent;

import java.util.List;

public interface UseCaseForEvent <T extends DomainEvent>{

    List<DomainEvent> apply(T DomainEvent);

}
