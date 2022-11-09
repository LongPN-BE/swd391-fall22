package com.groupswd391.fall22.projectType.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectTypeDTO implements Serializable {
    @NotNull
    private int majorID;
    @NotNull
    private String name;
    @NotNull
    private String description;
}
