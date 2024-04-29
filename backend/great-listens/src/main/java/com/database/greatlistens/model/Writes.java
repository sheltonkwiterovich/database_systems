package com.database.greatlistens.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.database.greatlistens.CompositeIds.WritesId;

@Entity
@Table(name = "writes")
@IdClass(WritesId.class)
public class Writes {
    @Id
    @Column(name = "mem_id")
    private String mem_id;

    @Id
    @Column(name = "book_id")
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
    
    public Writes() {
    }

    public Writes(String mem_id, int book_id) {
        this.mem_id = mem_id;
        this.book_id = book_id;
    }
}
