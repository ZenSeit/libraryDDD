package org.diego.domain.commonvalues;

import org.diego.generic.Identity;

public class BookId extends Identity {

    private BookId(String uuid) {
        super(uuid);
    }

    public static BookId of(String uuid){
        return new BookId(uuid);
    }
}
