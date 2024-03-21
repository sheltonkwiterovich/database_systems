package com.database.greatlistens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @Column(name = "cart_id")
    private int cart_id;

    @Column(name = "user_id")
    //@ManyToOne
    private int user_id;

    @Column(name = "cart_total")
    private double cart_total;

    public Cart(int cart_id, int user_id, double cart_total) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.cart_total = cart_total;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getCart_total() {
        return cart_total;
    }

    public void setCart_total(double cart_total) {
        this.cart_total = cart_total;
    }

    
}
