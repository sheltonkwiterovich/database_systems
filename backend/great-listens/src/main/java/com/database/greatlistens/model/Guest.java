package com.database.greatlistens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Guest")
public class Guest {
    @Id
    @Column(name = "guest_id")
    private String guest_id;

    public String getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(String guest_id) {
        this.guest_id = guest_id;
    }

    public Guest(String guest_id) {
        this.guest_id = guest_id;
    }

    

}
