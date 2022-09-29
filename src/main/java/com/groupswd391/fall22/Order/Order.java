package com.groupswd391.fall22.Order;

import com.groupswd391.fall22.Application.Application;

import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name = "tbl_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(targetEntity = Application.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "application_ID", referencedColumnName = "id")
    private Application application;

    private Timestamp time;
    private double amount;
    private boolean status;

    public Order() {
    }

    public Order(String id, Timestamp time, double amount, boolean status) {
        this.id = id;
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

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
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
