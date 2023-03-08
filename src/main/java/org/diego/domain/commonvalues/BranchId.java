package org.diego.domain.commonvalues;

import org.diego.generic.Identity;

public class BranchId extends Identity {

    private BranchId(String uuid) {
        super(uuid);
    }

    public static BranchId of(String uuid){
        return new BranchId(uuid);
    }
}
