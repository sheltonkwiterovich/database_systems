package com.database.greatlistens.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.database.greatlistens.CompositeIds.BuysId;

@Table(name = "Added_to")
@IdClass(BuysId.class)
public class AddedTo {
    @Id
   //@ManyToOne
    @Column(name = "book_id")
    private int book_id;

    @Id
    @Column(name = "cart_id")
    private int cart_id;

    public AddedTo(int book_id, int cart_id) {
        this.book_id = book_id;
        this.cart_id = cart_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    
}
