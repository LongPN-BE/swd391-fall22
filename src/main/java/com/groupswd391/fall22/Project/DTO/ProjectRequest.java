package com.groupswd391.fall22.Project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectRequest {
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private int userID;
    @NotNull
    private int projectTypeID;
}
