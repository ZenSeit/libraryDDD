package org.diego.business.commons;

import org.diego.generic.Command;
import org.diego.generic.DomainEvent;

import java.util.List;

public interface UserCaseForCommand <T extends Command>{

    List<DomainEvent> apply(T command);
}
