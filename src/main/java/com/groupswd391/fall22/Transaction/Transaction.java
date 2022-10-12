package com.groupswd391.fall22.Transaction;


import com.groupswd391.fall22.Wallet.Wallet;
import com.groupswd391.fall22.Order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
