package com.groupswd391.fall22.Application;

import com.groupswd391.fall22.ProjectItem.ProjectItem;
import com.groupswd391.fall22.User.User;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = ProjectItem.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "projectitem_ID", referencedColumnName = "id")
    private ProjectItem projectItem;

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_ID", referencedColumnName = "id")
    private User user;

    private String requirement;
    private double price;
    private Date time;

    public Application() {
    }

    public Application(int ID, String requirement, double price, Date time) {
        this.id = ID;
        this.requirement = requirement;
        this.price = price;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
