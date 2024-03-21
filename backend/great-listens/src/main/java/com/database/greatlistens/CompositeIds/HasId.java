package com.database.greatlistens.CompositeIds;

import java.io.Serializable;

public class HasId implements Serializable{
    private int pay_id;
    private int conf_code;
    public HasId(int pay_id, int conf_code) {
        this.pay_id = pay_id;
        this.conf_code = conf_code;
    }

    
}
