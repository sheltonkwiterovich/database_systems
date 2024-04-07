package com.database.greatlistens.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.database.greatlistens.CompositeIds.RatingsId;

@Entity
@Table(name = "ratings")
@IdClass(RatingsId.class)
public class Ratings {
    //@ManyToOne
    @Id
    @Column(name = "mem_id")
    private String mem_id;
    
    //@ManyToOne
    @Id
    @Column(name = "book_id")
    private int book_id;

    @Column(name = "rate")
    private int rate;

    public Ratings() {
    }

    public Ratings(String mem_id, int book_id, int rate) {
        this.mem_id = mem_id;
        this.book_id = book_id;
        this.rate = rate;
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    

}
