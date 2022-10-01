package com.groupswd391.fall22.ProjectType;


import com.groupswd391.fall22.Major.Major;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;


@CrossOrigin
@Entity
@Table(name = "projecttype")
public class ProjectType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne( targetEntity = Major.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "major_ID", referencedColumnName = "id")
    private Major major;

    private String name;
    private String description;

    public ProjectType() {
    }

    public ProjectType(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
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
