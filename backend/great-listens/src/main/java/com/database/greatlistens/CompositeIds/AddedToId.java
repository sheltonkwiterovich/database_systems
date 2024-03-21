package com.database.greatlistens.CompositeIds;


import java.io.Serializable;

public class AddedToId implements Serializable{
    private int book_id;
    private int cart_id;
    
    public AddedToId(int book_id, int cart_id) {
        this.book_id = book_id;
        this.cart_id = cart_id;
    }
    
    

    

}
