package org.diego.domain.commonvalues;

import org.diego.generic.ValueObject;

public class Address implements ValueObject<Address.Props> {
    private String street;
    private String avenue;
    private int houseNumber;

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String street() {
                return street;
            }

            @Override
            public String avenue() {
                return avenue;
            }

            @Override
            public int houseNumber() {
                return houseNumber;
            }
        };
    }


    interface Props{
        String street();
        String avenue();
        int houseNumber();
    }
}
