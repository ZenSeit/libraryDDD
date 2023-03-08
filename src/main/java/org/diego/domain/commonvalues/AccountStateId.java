package org.diego.domain.commonvalues;

import org.diego.generic.Identity;

public class AccountStateId extends Identity {

    private AccountStateId(String uuid) {
        super(uuid);
    }

    public static AccountStateId of(String uuid){
        return new AccountStateId(uuid);
    }
}
