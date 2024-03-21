package com.database.greatlistens.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.database.greatlistens.CompositeIds.WritesId;

@Table(name = "Writes")
@IdClass(WritesId.class)
public class Writes {
    @Id
    @Column(name = "mem_id")
    //@ManyToOne
    private String mem_id;

    @Id
    @Column(name = "book_id")
    //@ManyToOne
    private int book_id;

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

    public Writes(String mem_id, int book_id) {
        this.mem_id = mem_id;
        this.book_id = book_id;
    }

    

}
