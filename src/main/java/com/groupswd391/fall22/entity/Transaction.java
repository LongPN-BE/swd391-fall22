package com.groupswd391.fall22.entity;

public class Transaction {
    String id;
    String order_ID;
    String wallet_ID;

    public Transaction() {
    }

    public Transaction(String id, String order_ID, String wallet_ID) {
        this.id = id;
        this.order_ID = order_ID;
        this.wallet_ID = wallet_ID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(String order_ID) {
        this.order_ID = order_ID;
    }

    public String getWallet_ID() {
        return wallet_ID;
    }

    public void setWallet_ID(String wallet_ID) {
        this.wallet_ID = wallet_ID;
    }
}
