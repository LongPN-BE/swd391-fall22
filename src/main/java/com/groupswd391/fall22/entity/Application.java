package com.groupswd391.fall22.entity;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "tbl_application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "projectItem_ID", nullable = false)
    private ProjectItem projectItem;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_ID", nullable = false)
    private User user;

    private String requirement;
    private double price;
    private Timestamp time;

    public Application() {
    }

    public Application(String ID, ProjectItem projectItem, User user, String requirement, double price, Timestamp time) {
        this.ID = ID;
        this.projectItem = projectItem;
        this.user = user;
        this.requirement = requirement;
        this.price = price;
        this.time = time;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ProjectItem getProjectItem() {
        return projectItem;
    }

    public void setProjectItem(ProjectItem projectItem) {
        this.projectItem = projectItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
