package com.database.greatlistens.CompositeIds;

import java.io.Serializable;

public class RatingsId implements Serializable{
    private String mem_id;
    private int book_id;
    
    public RatingsId(String mem_id, int book_id) {
        this.mem_id = mem_id;
        this.book_id = book_id;
    }

    public RatingsId() {
    }

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    

}
