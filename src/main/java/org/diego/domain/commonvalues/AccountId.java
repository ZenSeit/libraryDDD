package org.diego.domain.commonvalues;

import org.diego.generic.Identity;

public class AccountId extends Identity {

    private AccountId(String uuid) {
        super(uuid);
    }

    public static AccountId of(String uuid){
        return new AccountId(uuid);
    }
}
