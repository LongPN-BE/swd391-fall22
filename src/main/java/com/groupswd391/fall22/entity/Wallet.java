package com.groupswd391.fall22.entity;

public class Wallet {
    String id;
    String user_ID;
    String name;
    double amount;
    boolean status;

    public Wallet() {
    }

    public Wallet(String id, String user_ID, String name, double amount, boolean status) {
        this.id = id;
        this.user_ID = user_ID;
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

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
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
