package com.groupswd391.fall22.Project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDTO implements Serializable {
    @NotNull
    private int userID;
    @NotNull
    private int projectTypeID;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private int status;

}
