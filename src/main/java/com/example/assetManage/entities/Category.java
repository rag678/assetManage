package com.example.assetManage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    private long id;
    @Column(name = "item_id")
    private long itemId;
    @Column(name = "category_name")
    private String c_name;

    public Category() {
    }

    public Category(String c_name,long itemId) {
        this.c_name = c_name;
        this.itemId = itemId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
}
