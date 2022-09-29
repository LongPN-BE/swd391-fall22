package com.groupswd391.fall22.Transaction;


import com.groupswd391.fall22.Wallet.Wallet;
import com.groupswd391.fall22.Order.Order;

import javax.persistence.*;

@Entity
@Table(name = "tbl_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(targetEntity = Order.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "oder_ID", referencedColumnName = "id")
    private Order order;

    @ManyToOne(targetEntity = Wallet.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_ID", referencedColumnName = "id")
    private Wallet wallet;

    public Transaction() {
    }

    public Transaction(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
