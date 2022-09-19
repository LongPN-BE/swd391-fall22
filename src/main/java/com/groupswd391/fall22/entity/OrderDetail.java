package com.groupswd391.fall22.entity;


import javax.persistence.*;

@Entity
@Table(name = "tbl_major")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String order_ID;
    String projectItem_ID;

    public OrderDetail() {
    }

    public OrderDetail(String id, String order_ID, String projectItem_ID) {
        this.id = id;
        this.order_ID = order_ID;
        this.projectItem_ID = projectItem_ID;
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

    public String getProjectItem_ID() {
        return projectItem_ID;
    }

    public void setProjectItem_ID(String projectItem_ID) {
        this.projectItem_ID = projectItem_ID;
    }
}
