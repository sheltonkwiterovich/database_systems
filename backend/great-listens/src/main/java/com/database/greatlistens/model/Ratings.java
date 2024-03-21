package com.database.greatlistens.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.database.greatlistens.CompositeIds.RatingsId;

@Entity
@Table(name = "Ratings")
@IdClass(RatingsId.class)
public class Ratings {
    @Id
    @Column(name = "rating_id")
    private int rating_id;

    //@ManyToOne
    @Column(name = "mem_id")
    private String mem_id;
    
    //@ManyToOne
    @Column(name = "book_id")
    private int book_id;

    @Column(name = "rate")
    private int rate;


    
    public Ratings(int rating_id, String mem_id, int book_id, int rate) {
        this.rating_id = rating_id;
        this.mem_id = mem_id;
        this.book_id = book_id;
        this.rate = rate;
    }

    public int getRating_id() {
        return rating_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
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
