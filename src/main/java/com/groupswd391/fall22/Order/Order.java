package com.groupswd391.fall22.Order;

import com.groupswd391.fall22.Application.Application;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@Data
@Entity
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Application.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "application_ID", referencedColumnName = "id")
    private Application application;

    private Date time;
    private double amount;
    private boolean status;

}
