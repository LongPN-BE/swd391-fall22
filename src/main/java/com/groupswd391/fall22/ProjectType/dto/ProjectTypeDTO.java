package com.groupswd391.fall22.ProjectType.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectTypeDTO implements Serializable {
    private int id;
    @NotNull
    private int majorID;
    @NotNull
    private String name;
    @NotNull
    private String description;
}
