package com.database.greatlistens.CompositeIds;

import java.io.Serializable;

public class GoesToId implements Serializable {
    private int cart_id;
    private int pay_id;
    public GoesToId(int cart_id, int pay_id) {
        this.cart_id = cart_id;
        this.pay_id = pay_id;
    }
    
    
    
    

    

}
