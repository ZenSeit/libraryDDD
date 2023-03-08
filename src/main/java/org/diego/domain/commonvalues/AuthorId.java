package org.diego.domain.commonvalues;

import org.diego.generic.Identity;

public class AuthorId extends Identity {

    private AuthorId(String uuid) {
        super(uuid);
    }

    public static AuthorId of(String uuid){
        return new AuthorId(uuid);
    }
}
