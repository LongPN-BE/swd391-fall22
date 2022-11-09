package com.groupswd391.fall22.OrderDetail;


import com.groupswd391.fall22.projectItem.entity.ProjectItem;
import com.groupswd391.fall22.Order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Order.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_ID", referencedColumnName = "id")
    private Order order;

    @ManyToOne(targetEntity = ProjectItem.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "projectitem_ID", referencedColumnName = "id")
    private ProjectItem projectItem;

}
