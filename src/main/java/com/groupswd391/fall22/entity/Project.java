package com.groupswd391.fall22.entity;


import javax.persistence.*;

@Entity
@Table(name = "tbl_major")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String projectType_ID;
    String name;
    String description;
    String user_ID;

    public Project() {
    }

    public Project(String id, String projectType_ID, String name, String description, String user_ID) {
        this.id = id;
        this.projectType_ID = projectType_ID;
        this.name = name;
        this.description = description;
        this.user_ID = user_ID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectType_ID() {
        return projectType_ID;
    }

    public void setProjectType_ID(String projectType_ID) {
        this.projectType_ID = projectType_ID;
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

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }
}
