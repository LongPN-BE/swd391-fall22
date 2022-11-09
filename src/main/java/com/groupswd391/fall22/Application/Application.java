package com.groupswd391.fall22.Application;

import com.groupswd391.fall22.ProjectItem.ProjectItem;
import com.groupswd391.fall22.User.User;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = ProjectItem.class)
    @JoinColumn(name = "project_item_id", referencedColumnName = "id")
    private ProjectItem projectItem;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_ID", referencedColumnName = "id")
    private User user;

    private String requirement;
    private double price;
    private Date time;
    private int status;
}
