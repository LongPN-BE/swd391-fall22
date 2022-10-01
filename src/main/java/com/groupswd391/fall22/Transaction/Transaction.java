package com.groupswd391.fall22.Transaction;


import com.groupswd391.fall22.Wallet.Wallet;
import com.groupswd391.fall22.Order.Order;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Order.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "oder_ID", referencedColumnName = "id")
    private Order order;

    @ManyToOne(targetEntity = Wallet.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_ID", referencedColumnName = "id")
    private Wallet wallet;

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
