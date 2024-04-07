package com.database.greatlistens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "cart_id")
    private int cart_id;

    @Column(name = "mem_id")
    //@ManyToOne
    private String mem_id;

    @Column(name = "cart_total")
    private double cart_total;

    public Cart() {
    }

    public Cart(int cart_id, String user_id, double cart_total) {
        this.cart_id = cart_id;
        this.mem_id = user_id;
        this.cart_total = cart_total;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }

    public double getCart_total() {
        return cart_total;
    }

    public void setCart_total(double cart_total) {
        this.cart_total = cart_total;
    }

}
