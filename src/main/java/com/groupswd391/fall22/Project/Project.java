package com.groupswd391.fall22.Project;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.groupswd391.fall22.ProjectItem.ProjectItem;
import com.groupswd391.fall22.ProjectType.ProjectType;
import com.groupswd391.fall22.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "projectType_ID", referencedColumnName = "id")
    private ProjectType projectType;

    @ManyToOne
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
