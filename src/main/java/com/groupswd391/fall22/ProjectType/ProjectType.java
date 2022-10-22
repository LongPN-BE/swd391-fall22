package com.groupswd391.fall22.ProjectType;


import com.groupswd391.fall22.Major.Major;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@CrossOrigin
@Entity
@Table(name = "project_type")
public class ProjectType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne( targetEntity = Major.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "major_ID", referencedColumnName = "id")
    private Major major;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private int status;
}
