package com.groupswd391.fall22.entity;


import javax.persistence.*;

@Entity
@Table(name = "tbl_project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(targetEntity = ProjectType.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "projecttype_ID", referencedColumnName = "id")
    private ProjectType projectType;

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_ID", referencedColumnName = "id")
    private User user;

    private String name;
    private String description;


    public Project() {
    }

    public Project(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
