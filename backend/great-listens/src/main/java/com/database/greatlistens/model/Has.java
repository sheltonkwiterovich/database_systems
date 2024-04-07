package com.database.greatlistens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.database.greatlistens.CompositeIds.HasId;

@Entity
@Table(name = "has")
@IdClass(HasId.class)
public class Has {
    @Id
    @Column(name = "pay_id")
    private int pay_id;

    @Id
    @Column(name = "conf_code")
    private int conf_code;

    public Has() {
    }

    public Has(int pay_id, int conf_code) {
        this.pay_id = pay_id;
        this.conf_code = conf_code;
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public int getConf_code() {
        return conf_code;
    }

    public void setConf_code(int conf_code) {
        this.conf_code = conf_code;
    }

    
}
