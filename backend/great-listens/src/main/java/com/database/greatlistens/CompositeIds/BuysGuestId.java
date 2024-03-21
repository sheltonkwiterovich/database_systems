package com.database.greatlistens.CompositeIds;

import java.io.Serializable;

public class BuysGuestId implements Serializable{
    private String guest_id;
    private int book_id;
    
    public BuysGuestId(String guest_id, int book_id) {
        this.guest_id = guest_id;
        this.book_id = book_id;
    }

    

}
