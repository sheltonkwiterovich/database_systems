package com.database.greatlistens.CompositeIds;

import java.io.Serializable;

public class WritesId implements Serializable{
    private String mem_id;
    private int book_id;
    
    public WritesId(String mem_id, int book_id) {
        this.mem_id = mem_id;
        this.book_id = book_id;
    }

    

}
