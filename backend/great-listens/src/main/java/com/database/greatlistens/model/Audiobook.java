package com.database.greatlistens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audiobook")
public class Audiobook {
    @Id
    @Column(name = "book_id")
    private int book_id;

    @Column(name = "book_name")
    private String book_name;

    @Column(name = "book_author")
    private String book_author;

    @Column(name = "book_narrator")
    private String book_narrator;

    @Column(name = "categories")
    private String categories;

    @Column(name = "rating")
    private double rating;

    @Column(name = "price")
    private double price;

    @Column(name = "listening_time")
    private int listening_time;

    
    public Audiobook() {
    }

    public Audiobook(Integer book_id, String book_name, String book_author, String book_narrator, String categories,
            double rating, double price, int listening_time) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_narrator = book_narrator;
        this.categories = categories;
        this.rating = rating;
        this.price = price;
        this.listening_time = listening_time;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_narrator() {
        return book_narrator;
    }

    public void setBook_narrator(String book_narrator) {
        this.book_narrator = book_narrator;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getListening_time() {
        return listening_time;
    }

    public void setListening_time(int listening_time) {
        this.listening_time = listening_time;
    }
}
