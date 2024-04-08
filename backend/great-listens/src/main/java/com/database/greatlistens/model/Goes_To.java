package com.database.greatlistens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.database.greatlistens.CompositeIds.GoesToId;

@Entity
@Table(name = "goes_to")
@IdClass(GoesToId.class)
public class Goes_To {
    @Id
    @Column(name = "cart_id")
    private int cart_id;

    @Id
    @Column(name = "pay_id")
    private int pay_id;

    

    public Goes_To() {
    }

    public Goes_To(int cart_id, int pay_id) {
        this.cart_id = cart_id;
        this.pay_id = pay_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }


}
