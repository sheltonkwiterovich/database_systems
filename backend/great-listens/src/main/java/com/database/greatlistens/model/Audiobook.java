package com.database.greatlistens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Audiobook")
public class Audiobook {
    @Id
    @Column(name = "book_id")
    private Integer book_id;

    @Column(name = "rating")
    private int rating;

    @Column(name = "listening_time")
    private java.sql.Time listening_time;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    public Audiobook() {
    }

    public Audiobook(int book_id, int rating, java.sql.Time listening_time, String title, String author, double price,
            String description) {
        this.book_id = book_id;
        this.rating = rating;
        this.listening_time = listening_time;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public java.sql.Time getListening_time() {
        return listening_time;
    }

    public void setListening_time(java.sql.Time listening_time) {
        this.listening_time = listening_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
