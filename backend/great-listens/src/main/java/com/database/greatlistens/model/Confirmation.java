package com.database.greatlistens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "confirmation")
public class Confirmation {
    @Id
    @Column(name = "conf_code")
    private int conf_code;

    @Column(name = "pay_id")
    private int pay_id;

    @Column(name = "card_holder")
    private String card_holder;
    
    public Confirmation() {
    }

    public Confirmation(int conf_code, int pay_id, String card_holder) {
        this.conf_code = conf_code;
        this.pay_id = pay_id;
        this.card_holder = card_holder;
    }

    public int getConf_code() {
        return conf_code;
    }

    public void setConf_code(int conf_code) {
        this.conf_code = conf_code;
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public void setCard_holder(String card_holder) {
        this.card_holder = card_holder;
    }
}
