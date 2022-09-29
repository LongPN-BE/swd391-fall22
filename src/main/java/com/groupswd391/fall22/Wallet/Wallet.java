package com.groupswd391.fall22.Wallet;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.groupswd391.fall22.User.User;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "tbl_wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne( targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_ID", referencedColumnName = "id")
    private User user;
    private String name;
    private double amount;
    private boolean status;

    public Wallet() {
    }

    public Wallet(String id, String name, double amount, boolean status) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
