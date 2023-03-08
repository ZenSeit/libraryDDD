package org.diego.domain.commonvalues;

import org.diego.generic.Identity;

public class ReaderId extends Identity {

    private ReaderId(String uuid) {
        super(uuid);
    }

    public static ReaderId of(String uuid){
        return new ReaderId(uuid);
    }
}
