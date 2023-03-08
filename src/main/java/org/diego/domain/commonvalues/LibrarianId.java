package org.diego.domain.commonvalues;

import org.diego.generic.Identity;

public class LibrarianId extends Identity {

    private LibrarianId(String uuid) {
        super(uuid);
    }

    public static LibrarianId of(String uuid){
        return new LibrarianId(uuid);
    }
}
