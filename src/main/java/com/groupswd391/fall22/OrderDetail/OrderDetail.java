package com.groupswd391.fall22.OrderDetail;


import com.groupswd391.fall22.ProjectItem.ProjectItem;
import com.groupswd391.fall22.Order.Order;

import javax.persistence.*;

@Entity
@Table(name = "orderDetail")
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

    public OrderDetail() {
    }

    public OrderDetail(int id, Order order, ProjectItem projectItem) {
        this.id = id;
        this.order = order;
        this.projectItem = projectItem;
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

    public ProjectItem getProjectItem() {
        return projectItem;
    }

    public void setProjectItem(ProjectItem projectItem) {
        this.projectItem = projectItem;
    }
}
