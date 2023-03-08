package org.diego.domain.commonvalues;

import org.diego.generic.Identity;

public class LoanOrderId extends Identity {

    private LoanOrderId(String uuid) {
        super(uuid);
    }

    public static LoanOrderId of(String uuid){
        return new LoanOrderId(uuid);
    }

}
