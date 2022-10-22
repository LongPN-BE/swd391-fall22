package com.groupswd391.fall22.ProjectItem;


import com.groupswd391.fall22.Project.Project;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Getter
@Setter
@CrossOrigin
@Entity
@Table(name = "project_item")
public class ProjectItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Project.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "project_ID", referencedColumnName = "id")
    private Project project;

    @Column(name = "minPrice")
    private double minPrice;

    @Column(name = "maxPrice")
    private double maxPrice;

    @Column(name = "requirement")
    private String requirement;

    @Column(name = "neededNum")
    private Integer neededNum;

    @Column(name = "soldNum")
    private Integer soldNum;

    @Column(name = "appliedNum")
    private Integer appliedNum;

    @Column(name = "status")
    private int status;
}
