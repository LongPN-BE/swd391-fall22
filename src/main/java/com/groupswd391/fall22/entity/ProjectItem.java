package com.groupswd391.fall22.entity;

public class ProjectItem {
    String id;
    String project_ID;
    double min_price;
    double max_price;
    String requirement;
    Integer neededNum;
    Integer soldNum;
    Integer appliedNum;

    public ProjectItem() {
    }

    public ProjectItem(String id, String project_ID, double min_price,
                       double max_price, String requirement, Integer neededNum,
                       Integer soldNum, Integer appliedNum) {
        this.id = id;
        this.project_ID = project_ID;
        this.min_price = min_price;
        this.max_price = max_price;
        this.requirement = requirement;
        this.neededNum = neededNum;
        this.soldNum = soldNum;
        this.appliedNum = appliedNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject_ID() {
        return project_ID;
    }

    public void setProject_ID(String project_ID) {
        this.project_ID = project_ID;
    }

    public double getMin_price() {
        return min_price;
    }

    public void setMin_price(double min_price) {
        this.min_price = min_price;
    }

    public double getMax_price() {
        return max_price;
    }

    public void setMax_price(double max_price) {
        this.max_price = max_price;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Integer getNeededNum() {
        return neededNum;
    }

    public void setNeededNum(Integer neededNum) {
        this.neededNum = neededNum;
    }

    public Integer getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(Integer soldNum) {
        this.soldNum = soldNum;
    }

    public Integer getAppliedNum() {
        return appliedNum;
    }

    public void setAppliedNum(Integer appliedNum) {
        this.appliedNum = appliedNum;
    }
}
