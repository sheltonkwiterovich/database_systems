package com.database.greatlistens.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.database.greatlistens.CompositeIds.BuysGuestId;

@Table(name = "Buys_Guest")
@IdClass(BuysGuestId.class)
public class BuysGuest {
    @Id
    @Column(name = "guest_id")
    //@ManyToOne
    private String guest_id;

    @Id
    @Column(name = "book_id")
    //@ManyToOne
    private int book_id;

    public BuysGuest(String guest_id, int book_id) {
        this.guest_id = guest_id;
        this.book_id = book_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }


    public String getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(String guest_id) {
        this.guest_id = guest_id;
    }

    

}

