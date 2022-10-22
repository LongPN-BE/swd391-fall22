package com.groupswd391.fall22.Project;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.groupswd391.fall22.ProjectItem.ProjectItem;
import com.groupswd391.fall22.ProjectType.ProjectType;
import com.groupswd391.fall22.User.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.Set;

@CrossOrigin
@Entity
@Getter
@Setter
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = ProjectType.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "projectType_ID", referencedColumnName = "id")
    private ProjectType projectType;

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_ID", referencedColumnName = "id")
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private Set<ProjectItem> listProjectItem;
}
