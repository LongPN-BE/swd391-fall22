package com.groupswd391.fall22.entity;

public class ProjectType {
    String id;
    String major_ID;
    String name;
    String description;

    public ProjectType() {
    }

    public ProjectType(String id, String major_ID, String name, String description) {
        this.id = id;
        this.major_ID = major_ID;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajor_ID() {
        return major_ID;
    }

    public void setMajor_ID(String major_ID) {
        this.major_ID = major_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
