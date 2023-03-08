package org.diego.domain.loanorder.values;

import org.diego.generic.ValueObject;

public class WorkSchedule implements ValueObject<WorkSchedule.Props> {

    private String fromHour;
    private String toHour;

    public WorkSchedule(String fromHour, String toHour) {
        this.fromHour = fromHour;
        this.toHour = toHour;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String fromHour() {
                return fromHour;
            }

            @Override
            public String toHour() {
                return toHour;
            }
        };
    }

    interface Props{
        String fromHour();
        String toHour();
    }
}
