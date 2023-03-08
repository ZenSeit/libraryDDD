package org.diego.domain.commonvalues;

import org.diego.generic.Identity;

public class BookCatalogId extends Identity {

    private BookCatalogId(String uuid) {
        super(uuid);
    }

    public static BookCatalogId of(String uuid){
        return new BookCatalogId(uuid);
    }
}
