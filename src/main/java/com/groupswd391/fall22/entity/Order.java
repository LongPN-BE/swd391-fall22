package com.groupswd391.fall22.entity;

import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name = "tbl_major")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String application_ID;
    Timestamp time;
    double amount;
    boolean status;

    public Order() {
    }

    public Order(String id, String application_ID, Timestamp time, double amount, boolean status) {
        this.id = id;
        this.application_ID = application_ID;
        this.time = time;
        this.amount = amount;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplication_ID() {
        return application_ID;
    }

    public void setApplication_ID(String application_ID) {
        this.application_ID = application_ID;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
