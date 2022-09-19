package com.groupswd391.fall22.entity;
import java.sql.Timestamp;

public class Application {
    String ID;
    String projectItem_ID;
    String user_ID;
    String requirement;
    double price;
    Timestamp time;

    public Application() {
    }

    public Application(String ID, String projectItem_ID, String user_ID, String requirement, double price, Timestamp time) {
        this.ID = ID;
        this.projectItem_ID = projectItem_ID;
        this.user_ID = user_ID;
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

    public String getProjectItem_ID() {
        return projectItem_ID;
    }

    public void setProjectItem_ID(String projectItem_ID) {
        this.projectItem_ID = projectItem_ID;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
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
