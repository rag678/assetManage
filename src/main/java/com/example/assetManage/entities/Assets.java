package com.example.assetManage.entities;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "assets")
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "customer_Id")
    private long c_id;
    @Column(name = "status_id")
    private long s_id;
    @Column(name = "first_name")
    private String firstName;
    private String lastName;
    @Column(name = "purchase_date")
    private Date p_date;
    @Column(name = "condition_note")
    private String c_note;

    public Assets() {
    }

    public Assets(long c_id, long s_id, String firstName, String lastName, Date p_date, String c_note) {
        this.c_id = c_id;
        this.s_id = s_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.p_date = p_date;
        this.c_note = c_note;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getC_id() {
        return c_id;
    }

    public void setC_id(long c_id) {
        this.c_id = c_id;
    }

    public long getS_id() {
        return s_id;
    }

    public void setS_id(long s_id) {
        this.s_id = s_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getP_date() {
        return p_date;
    }

    public void setP_date(Date p_date) {
        this.p_date = p_date;
    }

    public String getC_note() {
        return c_note;
    }

    public void setC_note(String c_note) {
        this.c_note = c_note;
    }
}
