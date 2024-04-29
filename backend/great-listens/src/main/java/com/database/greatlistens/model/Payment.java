package com.database.greatlistens.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "pay_id")
    private int pay_id;

    @Column(name = "credit_card")
    private String credit_card;

    @Column(name = "card_name")
    private String card_name;

    @Column(name = "expiration")
    private Date expiratation;

    @Column(name = "csv")
    private String csv;

    public Payment() {
    }

    public Payment(int pay_id, String credit_card, String card_name, Date expiratation, String csv) {
        this.pay_id = pay_id;
        this.credit_card = credit_card;
        this.card_name = card_name;
        this.expiratation = expiratation;
        this.csv = csv;
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public String getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public Date getExpiratation() {
        return expiratation;
    }

    public void setExpiratation(Date expiratation) {
        this.expiratation = expiratation;
    }

    public String getCsv() {
        return csv;
    }

    public void setCsv(String csv) {
        this.csv = csv;
    }
}
