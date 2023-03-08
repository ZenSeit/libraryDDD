package org.diego.domain.commonvalues;

import org.diego.generic.ValueObject;

public class FullName implements ValueObject<FullName.Props> {

    private String name;
    private String lastName;

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String name() {
                return name;
            }

            @Override
            public String lastName() {
                return lastName;
            }
        };
    }

    interface Props{
        String name();
        String lastName();
    }
}
