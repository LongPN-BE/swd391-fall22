package com.groupswd391.fall22.Project;


import com.groupswd391.fall22.ProjectType.ProjectType;
import com.groupswd391.fall22.User.User;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;


@CrossOrigin
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = ProjectType.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "projecttype_ID", referencedColumnName = "id")
    private ProjectType projectType;

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_ID", referencedColumnName = "id")
    private User user;

    private String name;
    private String description;
    private boolean status;


    public Project() {
    }

    public Project(int id, String name, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
