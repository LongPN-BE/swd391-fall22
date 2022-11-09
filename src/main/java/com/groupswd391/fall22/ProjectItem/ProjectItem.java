package com.groupswd391.fall22.projectItem;


import com.groupswd391.fall22.project.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project_item")
public class ProjectItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "applied_num")
    private Integer appliedNum;

    @Column(name = "max_price")
    private double maxPrice;

    @Column(name = "min_price")
    private double minPrice;

    @Column(name = "needed_num")
    private Integer neededNum;

    @Column(name = "requirement")
    private String requirement;

    @Column(name = "sold_num")
    private Integer soldNum;

    @Column(name = "status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;
}
